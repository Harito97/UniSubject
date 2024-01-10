# Đề bài
'''
Cho tệp văn bản chứa các chữ và các số trong đó có duy nhất 1 số may mắn. Số may mắn là số nguyên tố có tổng các chữ số chia hết cho 5.

Ví dụ 5, 37, 73, ... là các số may mắn.

Tìm và in ra số may mắn trong file văn bản.

Các xâu trong văn bản cách nhau bởi 1 dấu cách, văn bản có thể có nhiều dòng và chứa ký tự Unicode.

Nhiệm vụ của sinh viên là hoàn thiện hàm findLuckyNumber(filename). Hàm này nhận vào 1 đối là filename là tên file văn bản chứa dữ liệu, hàm trả về số may mắn có trong file filename.

Gợi ý: 

> Mở file filename, đọc vào từng dòng của văn bản

>>Với mỗi dòng, tách ra thành từng xâu (split), dùng phương thức của xâu để kiểm tra xem nó có phải là số hay không (xem lại phần xâu ký tự nếu cần). 

>>>Nếu xâu đó là số, chuyển xâu thành số nguyên rồi kiểm tra xem số đó có phải số may mắn theo định nghĩa ở trên hay không,

>>>> nếu đó là số may mắn trả lại kết quả cho hàm là số đó.
'''

# Bài làm
from math import isqrt
def findLuckyNumber(filename):
    with open(filename, "r") as f:
        for line in f:
            words = line.split(" ")
            for word in words:
                if word.isdigit():
                    if isLuckyNumber(int(word)):
                        return int(word)
    return None

def isLuckyNumber(num):
    if isPrime(num) and sumDigitAndFive(num):
        return True
    return False

def isPrime(num):
    if num < 2:
        return False
    for i in range(2, isqrt(num) + 1):
        if num % i == 0:
            return False
    return True

def sumDigitAndFive(num):
    sum = 0
    while num > 0:
        sum += num % 10
        num //= 10
    return sum % 5 == 0