"""
Thuật toán RLE thích hợp để nén các ảnh đen trắng. 
Mục tiêu chính là rút gọn một mảng nhị phân thành một mảng ngắn hơn, như sau. 
Thay vì biểu diễn ảnh bởi mảng gồm 11 phần tử t =  [0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0] 
ta dùng mảng gồm 5 phần từ ct = [0, 5, 1, 1, 0, 5], 
biểu diễn số lần lặp lại của mỗi phần tử: lặp lại 5 lần số 0, 1 lần số 1 và lại 5 lần số 0.

Hoàn thiện các hàm trong file RLE.py theo các yêu cầu sau:

1.    Hàm length(t): Để tính độ dài của mảng nén của một danh sách t. 
Trong ví dụ trên, hàm này sẽ trả về 6. Hàm bạn viết cần xử lí các trường hợp đặc biệt. 
Nếu đầu vào là danh sách độ dài 0 thì mảng nén cũng có độ dài 0.

2.    Hàm compress(t): Hàm này thực hiện nén danh sách t và trả lại danh sách sau khi nén. 
Trong ví dụ trên kết quả trả về là danh sách ct  

3.    Hàm lengthInverse(ct): Thực hiện tính kích thước danh sách giải nén từ danh sách nén ct. 
Trong ví dụ trên, kết quả trả về là 11.

4.    Hàm decompress(ct): Thực hiện tính và trả lại danh sách giải nén từ danh sách nén ct.
"""

def length(t):
    # ý tưởng thuật toán là đếm số lần chuyển trạng thái (count_change)
    # return (count_change + 1) * 2
    count_change = 0
    current_stage = t[0]
    for i in range(1, len(t)):
        if t[i] != current_stage:
            current_stage = t[i]
            count_change += 1
    return (count_change + 1) * 2
    
def compress(t):
    list_compressed = []
    current_stage = t[0]
    current_count_stage = 1
    for i in range(1, len(t)):
        if t[i] != current_stage:
            list_compressed.append(current_stage)
            list_compressed.append(current_count_stage)
            current_stage = t[i]
            current_count_stage = 1
            continue
        current_count_stage += 1
    list_compressed.append(current_stage)
    list_compressed.append(current_count_stage)
    return list_compressed
    
def lengthInverse(ct):
    # ý tưởng là tính tổng các phần tử có index lẻ 
    total_sum = 0
    for i in range(1, len(ct), 2):
        total_sum += ct[i]   
    return total_sum
    
def decompress(ct):
    # ý tưởng là cộng 2 list 
    result_list = []
    for i in range(0, len(ct), 2):
        temp_list = [ct[i]] * ct[i + 1]
        result_list += temp_list
    return result_list

def test_demo():
    t = [0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0]
    ct = compress(t)
    print(ct)
    print(lengthInverse(ct))
    print(decompress(ct))
    print(length(t))

# test_demo()