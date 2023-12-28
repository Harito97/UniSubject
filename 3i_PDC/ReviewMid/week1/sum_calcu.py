# Viết chương trình cho phép nhập một số nguyên n từ bàn phím
# tính và in ra kết quả của biểu thức n + nn + nnn + nnnn
# Ví dụ n = 5, kết quả là 5 + 55 + 5555 + 5555 = 6170
# Chú ý: n có thể là số tự nhiên bất kỳ

def sum_calcu(n: str):
    result = 0
    for i in range(1, 5):
        num = n * i
        result += int(num)
    return result

num = input().strip()   # num have to can change to int
print(sum_calcu(num))
