# Import library
import cv2
from kafka import KafkaConsumer
import numpy as np
import threading

def consume_video_from_kafka(consumer, topic):
    # Khởi tạo hàm “consume_video_from_kafka”: 
    # Đọc dữ liệu được gửi từ “topica” và
    # yêu cầu hiển thị ra màn hình video gốc
    # Tạo cửa số nhờ OpenCV để hiện thị các frame ảnh
    cv2.namedWindow('Video', cv2.WINDOW_NORMAL)

    for message in consumer:
        frame_data = np.frombuffer(message.value, dtype=np.uint8)
        frame = cv2.imdecode(frame_data, cv2.IMREAD_COLOR)

        # Display video with the window name as the topic
        cv2.imshow('Video', frame)
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break

    cv2.destroyAllWindows()

def consume_video_from_kafka2(consumer, topic):
    # Khởi tạo hàm “consume_video_from_kafka2”: 
    # Đọc dữ liệu được gửi từ “topicb” và
    # xử lý các khung hình sao cho tách các vật thể ra khỏi khung hình. 
    # Cuối cùng yêu cầu hiển thị ra màn hình video sau khi xử lý
    last_gray = None

    # Tạo cửa số nhờ OpenCV để hiện thị các frame ảnh
    cv2.namedWindow('Video', cv2.WINDOW_NORMAL)

    for message in consumer:
        frame_data = np.frombuffer(message.value, dtype=np.uint8)
        frame = cv2.imdecode(frame_data, cv2.IMREAD_COLOR)
        gray_frame = cv2.GaussianBlur(frame, (5, 5), 0)

        if last_gray is None:
            last_gray = gray_frame
            continue

        diff = cv2.absdiff(gray_frame, last_gray)

        _, difference = cv2.threshold(diff, 70, 255, cv2.THRESH_BINARY)

        last_gray = gray_frame

        # Display video with the window name as the topic
        cv2.imshow('Video', difference)
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break

    cv2.destroyAllWindows()

def consume_video_from_kafka3(consumer, topic):
    count_left, count_right = 0, 0
    last_gray = None

    # Tạo cửa số nhờ OpenCV để hiện thị các frame ảnh
    cv2.namedWindow('Video', cv2.WINDOW_NORMAL)

    for message in consumer:
        frame_data = np.frombuffer(message.value, dtype=np.uint8)

        # print(frame_data.size) # 1280x720

        frame = cv2.imdecode(frame_data, cv2.IMREAD_COLOR)
        # Chuyển frame nhận từ Topic thành frame gray 
        gray_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY) 
        # Dùng Gaussian khử nhiễu 
        gray_frame = cv2.GaussianBlur(gray_frame, (5, 5), 0)

        if last_gray is None:
            last_gray = gray_frame
            continue
        
        # Lấy frame gray sau trừ frame gray trước 
        diff = cv2.absdiff(gray_frame, last_gray)

        # Xác định kênh alpha từ ngưỡng màu
        _, difference = cv2.threshold(diff, 70, 255, cv2.THRESH_BINARY)

        # Tăng kích thước miền của object di chuyển bằng cv2.dilate()
        # để lọc đi nhiều bounding nhỏ cùng bao 1 đối tượng 
        # Nên để lớn vì dù có thể có lúc 1 bound bao 2 ô tô nhưng
        # đảm bảo được lúc qua vạch đếm thì đúng số lượng 
        kernel = np.ones((35, 35), np.uint8) 
        difference = cv2.dilate(difference, kernel, iterations=1) 

        # Tìm các contour từ MatLike (difference)
        contours = cv2.findContours(difference, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)[0]

        # Chọn ra các boundingBoxes lớn nhất bao trùm các vật thể chuyển động
        boundingBoxes = []
        for cnt in contours:
            x, y, w, h = cv2.boundingRect(cnt)
            x1, y1, x2, y2 = x, y, x + w, y + h
            boundingBoxes.append((x1, y1, x2, y2))
        # Remove đi bounding box parent (chính là khung hình bound toàn bộ hình ảnh), 
        # nếu không khi áp dụng non max suppression chỉ giữ lại bounding box này
        boundingBoxes = [box for box in boundingBoxes if box[:2] != (0, 0)]
        boundingBoxes = np.array(boundingBoxes)
        # Set pick - những bounding boxes được chọn để ghi đè vào gray frame ảnh
        pick = non_max_suppression(boundingBoxes, 5.5)

        # Ghi đè các bounding box vào gray frame ảnh hiện tại - difference
        for (startX, startY, endX, endY) in pick:
            frame = cv2.rectangle(frame, (startX, startY), (endX, endY), (0, 255, 0), 2)
            
            # Đếm làn
            if startY > 650:
                if endX < 480:
                    count_left += 1
                elif startX > 720:
                    count_right += 1

        frame = cv2.rectangle(frame, (0, 650), (480, 650), (0, 0, 255), 10)
        frame = cv2.rectangle(frame, (720, 650), (1280, 650), (0, 0, 255), 10)

        # Update gray frame hiện tại thành gray frame cũ
        last_gray = gray_frame

        # Display video with the window name as the topic
        cv2.imshow('Video', frame)
        if cv2.waitKey(1) & 0xFF == ord('q'):
            print("Before \nLeft have:", count_left, "\nRight have:", count_right)
            f = open("CountCar.txt", "a")
            f.write("Before press 'q'" + "\nLeft have: " + str(count_left) + "\nRight have: " + str(count_right) + "\n")
            f.close()
            break

    cv2.destroyAllWindows()

def non_max_suppression(boxes, overlapThresh):
    '''
    boxes: List các bounding box
    overlapThresh: Ngưỡng overlapping giữa các hình ảnh
    '''
    # Nếu không có bounding boxes thì trả về empty list
    if len(boxes)==0:
        return []
    # Nếu bounding boxes nguyên thì chuyển sang float.
    if boxes.dtype.kind == "i":
        boxes = boxes.astype("float")

    # Khởi tạo list của index được lựa chọn
    pick = []
    
    # Lấy ra tọa độ của các bounding boxes
    x1 = boxes[:,0]
    y1 = boxes[:,1]
    x2 = boxes[:,2]
    y2 = boxes[:,3]

    # Tính diện tích của các bounding boxes và sắp xếp chúng theo thứ tự từ bottom-right, chính là tọa độ theo y của bounding box
    area = (x2 - x1 + 1) * (y2 - y1 + 1)
    idxs = np.argsort(y2)
    # Khởi tạo một vòng while loop qua các index xuất hiện trong indexes
    while len(idxs) > 0:
        # Lấy ra index cuối cùng của list các indexes và thêm giá trị index vào danh sách các indexes được lựa chọn
        last = len(idxs) - 1
        i = idxs[last]
        pick.append(i)

        # Tìm cặp tọa độ lớn nhất (x, y) là điểm bắt đầu của bounding box và tọa độ nhỏ nhất (x, y) là điểm kết thúc của bounding box
        xx1 = np.maximum(x1[i], x1[idxs[:last]])
        yy1 = np.maximum(y1[i], y1[idxs[:last]])
        xx2 = np.minimum(x2[i], x2[idxs[:last]])
        yy2 = np.minimum(y2[i], y2[idxs[:last]])

        # Tính toán width và height của bounding box
        w = np.maximum(0, xx2 - xx1 + 50)
        h = np.maximum(0, yy2 - yy1 + 50)

        # Tính toán tỷ lệ diện tích overlap
        overlap = (w * h) / area[idxs[:last]]

        # Xóa index cuối cùng và index của bounding box mà tỷ lệ diện tích overlap > overlapThreshold
        idxs = np.delete(idxs, np.concatenate(([last],
            np.where(overlap > overlapThresh)[0])))
    # Trả ra list các index được lựa chọn
    return boxes[pick].astype("int")
                       
# Khởi tạo hàm main:
# Tạo Kafka consumer cho “topica” và “topicb”
# Tạo 2 luồng, mỗi luồng nhận và xử lý dữ liệu từ các frame 
# đồng thời từ consumer và topic được gọi đến.
def main():
    topic1 = 'topica'
    topic2 = 'topicb'

    # Create Kafka consumer for topic 1
    consumer1 = KafkaConsumer(
        topic1,
        bootstrap_servers=['localhost:9092'],
        api_version=(0, 10)
    )

    # Create Kafka consumer for topic 2
    consumer2 = KafkaConsumer(
        topic2,
        bootstrap_servers=['localhost:9092'],
        api_version=(0, 10)
    )

    # Create and start threads for xonsuming videos
    # consumer_thread1 = threading.Thread(target=consume_video_from_kafka, args=(consumer1, topic1))
    consumer_thread2 = threading.Thread(target=consume_video_from_kafka3, args=(consumer2, topic2))
    
    # consumer_thread1.start()
    consumer_thread2.start()

    # Wait for threads to finish

    # consumer_thread1.join()
    consumer_thread2.join()
    
if __name__ == "__main__":
    main()
