"""
Bài 2 
Nhập số nguyên  dương  từ bàn phím, hãy viết  chương  trình  để tạo ra 
một dictionary chứa (i, và đảo ngược của i*i) với i là số nguyên từ 1 đến n (bao gồm 
cả 1 và n) sau đó in ra dictionary này. Ví dụ: Giả sử số n là 8 thì đầu ra sẽ là: {1: 1, 
2: 4, 3: 9, 4: 61, 5: 52, 6: 63, 7: 94, 8: 46}.
"""
def config_dictionary(number: int):
    if number < 0:
        return {} 
    
    dictionary = {}
    for i in range(1, number + 1):
        dictionary[str(i)] = str(i * i)[::-1]
    
    return dictionary

def main():
    number = int(input("Nhập vào 1 số nguyên dương: "))
    while number < 0:
        number = int(input("Nhập vào lại 1 số nguyên dương: "))

    print(config_dictionary(number))

if __name__ == '__main__':
    main()