from math import factorial

def combination(n: int, k: int):
    return int(factorial(n) / factorial(k) / factorial(n - k))

def pascal(n: int):
    for i in range(n + 1):
        for j in range(i + 1):
            print(combination(i, j), end = ' ')
        print()

# Test
n = int(input())
pascal(n)

