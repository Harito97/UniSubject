# Nhập vào một số nguyên dương N, tính giai thừa kép N!! của N.
# Công thức tính giai thừa kép
# Kết quả in ra n!! = #
# Ví dụ n = 6, kết quả in ra là
# 6!! = 48

def double_factorial(n: int):
    result = 1
    for num in range(n, 1, -2):
        result *= num
    return result

n = int(input())
print(str(n) + '!! =', double_factorial(n))
