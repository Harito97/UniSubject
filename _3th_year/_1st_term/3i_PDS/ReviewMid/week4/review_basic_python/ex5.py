"""
Bài 5: Viết một chương trình chấp nhận đầu vào là chuỗi các số nhị phân 4 chữ số, phân 
tách bởi  dấu phẩy, kiểm  tra  xem chúng có chia  hết cho 5 không. Sau đó in các số 
chia hết cho 5 thành dãy phân tách bởi dấu phẩy. Ví dụ đầu vào là: 0100,0011,1010,1001 
Đầu ra sẽ là: 1010 Gợi ý: Sử dụng hàm dựng int(giá trị, hệ cơ số) để chuyển một chuỗi dạng nhị phân sang số 
dạng thập phân.
"""

def get_input():
    """
    Input Eg: 1001,1111,1010,1110,0000,0001,0010
    """
    return input('Nhập vào list các số nhị phân: ').strip().split(',')

def main():
    data = get_input()
    result = []
    for number in data:
        if int(number, 2) % 5 == 0:
            result.append(number)
    print(result)

if __name__ == '__main__':
    main()