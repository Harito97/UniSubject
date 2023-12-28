# Hoàn thiện hàm solver(a,b,c) trong file P2.py thực hiện các yêu cầu sau:
# Giải và biện luận phương trình ax2 + bx + c = 0
# - Phương trình có nghiệm duy nhất in ra nghiệm duy nhất
# - Phương trình Có 2 nghiệm in ra 2 nghiệm cách nhau bởi 1 dấu cách
# - Phương trình vô nghiệm in ra VN
# - Phương trình vô số nghiệm in ra VSN

from math import sqrt

def solver(a,b,c):
    # ax2 + bx + c = 0
    if a == 0:
        if b == c:
            print('VSN')
        elif b == 0 and c != 0:
            print('VN')
        else:
            print(-c / b)
    else:
        delta = b*b - 4*a*c
        if delta < 0:
            print('VN')
        elif delta == 0:
            print(-b/2/a)
        else:
            sqrt_delta = sqrt(delta)
            print((-b-sqrt_delta)/2/a, (-b+sqrt_delta)/2/a)

a, b, c = int(input()), int(input()), int(input())
solver(a, b, c)
