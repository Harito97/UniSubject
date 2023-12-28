# Viết chương trình thực hiện việc nhập số nguyên n, 
# liệt kê các số nguyên a, b, c trong đoạn [1, n] 
# để bộ 3 (a, b, c) lập thành bộ Pitago.
# a, b, c được sắp theo thứ tự tăng dần (a <= b <= c), 
# mỗi bộ trên 1 dòng theo mẫu (a, b, c)

def pytago_numbers(n: int):
    from math import sqrt
    result = []
    for a in range(1, n - 1):
        for b in range(a, n):
            for c in range(b, n + 1):
                if a*a + b*b == c*c:
                    result.append((a, b, c))
    # return result
    # print result
    for res in result:
        print(res)

n = int(input())
pytago_numbers(n)
