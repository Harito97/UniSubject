from kafka import Consumer, KafkaError, Producer
import cv2

# Kafka consumer configuration
consumer_config = {
    "bootstrap.servers": "localhost:9092",
    "group.id": "video_consumer_group",
    "auto.offset.reset": "earliest",
}

# Create Kafka consumers for the two topics
consumer1 = Consumer(consumer_config)
consumer2 = Consumer(consumer_config)

# Subscribe to the two topics
consumer1.subscribe(["videoTopic1"])
consumer2.subscribe(["videoTopic2"])

# Kafka producer configuration
producer_config = {
    "bootstrap.servers": "localhost:9092",
}

# Create Kafka producer
producer = Producer(producer_config)


# Build playback video function
def playback_video(video_data1):
    import cv2
    import numpy as np
    # Tạo một cửa sổ hiển thị video
    cv2.namedWindow("Video Player", cv2.WINDOW_NORMAL)
    # Khởi tạo biến để lưu video
    video1 = cv2.VideoCapture(video_data1)
    while True:
        # Đọc frame từ video1
        ret, frame = video1.read()

        # Kiểm tra xem video còn frame để đọc hay không
        if not ret:
            break

        # Hiển thị frame trong cửa sổ
        cv2.imshow("Video Player", frame)

        # Thoát nếu người dùng nhấn phím 'q'
        if cv2.waitKey(1) & 0xFF == ord("q"):
            break

    # Giải phóng tài nguyên và đóng cửa sổ
    video1.release()
    cv2.destroyAllWindows()

# Thực thi lệnh
while True:
    # Poll for messages from the first topic
    msg1 = consumer1.poll(
        "/home/harito/Documents/simplescreenrecorder-2023-11-05_20.45.30.mkv"
    )
    if msg1 is None:
        continue
    if msg1.error():
        if msg1.error().code() == KafkaError._PARTITION_EOF:
            continue
        else:
            print("Error while polling topic 1:", msg1.error())
            break

    # Process and display the video from topic 1
    video_data1 = msg1.value()
    print("Received video from topic 1")
    # You need to implement video playback from the video_data1
    playback_video()


    
    # # Poll for messages from the second topic
    # msg2 = consumer2.poll("/home/harito/Documents/VideoDemo.mkv")
    # if msg2 is None:
    #     continue
    # if msg2.error():
    #     if msg2.error().code() == KafkaError._PARTITION_EOF:
    #         continue
    #     else:
    #         print("Error while polling topic 2:", msg2.error())
    #         break

    # # Process and display the video from topic 2
    # video_data2 = msg2.value()
    # print("Received video from topic 2")
    # # You need to implement video playback from the video_data2
