# Nhập ba số a, b, c tương ứng là độ dài 3 cạnh của một tam giác. Kiểm tra xem 3 cạnh có lập thành tam giác hay không, nếu có tính chu vi và diện tích tam giác.
# Warn: a, b, c được nhập lần lượt trên từng dòng.
# - Nếu 3 cạnh không lập thành tam giác in ra INVALID
# - Nếu 3 cạnh lập thành tam giác in ra S = #S ; C = #C
#   trong đó #C, #S là chu vi và diện tích của tam giác

from math import sqrt

def check_triangle(a: float, b: float, c: float):
    return a + b > c and b + c > a and c + a > b

a, b, c =  float(input()), float(input()), float(input())

if check_triangle(a, b, c):
    C = a + b + c
    p = C / 2
    S = sqrt(p * (p - a) * (p - b) * (p - c))
    print('S =', S, 'C =', C) 
else:
    print('INVALID')
