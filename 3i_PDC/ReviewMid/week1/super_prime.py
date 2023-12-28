# Viết chương trình nhập vào số nguyên dương n từ bàn phím, kiểm tra xem n có phải là số siêu nguyên tố hay không?
# Số siêu nguyên tố là số nguyên tố mà khi bỏ 1 số tùy ý các chữ số bên phải của nó thì phần còn lại vẫn là số nguyên tố.
# Ví dụ:
#    Với n = 5939 kết quả là True
#    Với n = 26 kết quả là False
#    Với n = 43 kết quả là False

number = input().strip()

def check_prime(num: int):
    if num <= 0:
        return False
    if num == 1 or num == 2 or num == 3:
        return True
    from math import sqrt
    for i in range (2, int(sqrt(num) + 1)):
        if num % i == 0:
            return False
    return True

def check_super_prime(num: str):
    if num is None or len(num) == 0:
        return False
    for length in range(len(num), 0, -1):
        if not check_prime(int(num[:length])):
            return False
    return True

print(check_super_prime(number))

