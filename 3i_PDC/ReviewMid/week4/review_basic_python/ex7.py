"""
Bài 7 Viết chương trình tính số  tiền  thực  của  một tài  khoản  ngân  hàng  dựa  trên  nhật ký 
giao dịch được nhập vào từ giao diện điều khiển.  
Định dạng nhật ký được hiển thị như sau: 
D 100 
W 200 (D là tiền gửi, W là tiền rút ra). 
Giả sử đầu vào được cung cấp là: D 300 D 300 W 200 D 100 
Thì đầu ra sẽ là: 500 
Đầu  vào có thể được nhập từ  file,  hoặc từ  bàn phím  trên từng dòng, việc  nhập kết 
thúc khi gặp dòng trống. 
"""
def get_input(filename=None):
    if filename == None:
        return input('Nhập vào lịch sử giao dịch: ').strip().split()
    else:
        with open(filename, "r", encoding='utf-8') as f:
            data = []
            lines = f.readlines()
            for line in lines:
                data += line.strip().split()
        return data 
    
def process(type: str, money: str):
    if type.upper() == 'D':
        return int(money)
    elif type.upper() == 'W':
        return - int(money)
    else:
        return ValueError('type not correct')
    
def main(filename=None):
    data = get_input(filename)
    result = 0
    for index in range(0, len(data), 2):
        result += process(data[index], data[index+1])
    print(result)

# def main():
#     dictionary = {'D' : 0, 'W' : 0}
#     while True:
#         line = input()
#         if line == "":
#             break
#         commend_list = line.strip().split()
#         dictionary[commend_list[0]] += int(commend_list[1])
#     result = dictionary['D'] - dictionary['W']
#     print(result)

if __name__ == '__main__':
    # main()
    main('ex7_data.txt')