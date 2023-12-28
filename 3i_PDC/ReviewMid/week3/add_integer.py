#Hoàn thiện hàm addNum(a, b) theo yêu cầu trong đề bài

def addNum(a, b):
    '''
    Cho 2 số nguyên a, b được biểu diễn bởi 2 danh sách
    thực hiện phép cộng 2 số a, b trên 2 danh sách theo quy tắc cộng thông thường. kết quả trả về là 1 danh sách biểu diễn tổng a+b
    ví dụ 
    a = [1,2,4,5]
    b =   [7,8,9]
   
    c = [2,0,3,4]
    '''
    if len(a) < 1 or len(b) < 1:
        return []

    c = []
    a = [str(digit) for digit in a]
    b = [str(digit) for digit in b]

    num_a = int(''.join(a))
    num_b = int(''.join(b))

    num_c = num_a + num_b

    while num_c != 0:
        c.insert(0, int(num_c % 10))
        num_c = int(num_c / 10)

    # Cách 2:
    # number_str = str(num_c)  # Chuyển số thành chuỗi
    # c = list(number_str)  # Chuyển chuỗi thành danh sách
    
    # c = [int(string) for string in c]

    return c

a = [1,2,3,4]
b = [9,4]

print(addNum(a,b))
