"""
Bài 6: Viết một chương trình tính giá trị của a+aa+aaa+aaaa với a là số được nhập vào bởi 
người dùng. Giả sử a được nhập vào là 1 thì đầu ra sẽ là: 1+11+111+1111 = 1234
"""

def main():
    number = input('Input a number: ')
    while not number.isdigit():
        number = input('Input again a number: ')
    result = 0
    temp = number
    for i in range(1, 5):
        temp += number
        result += int(temp)
    print(result)

if __name__ == '__main__':
    main()