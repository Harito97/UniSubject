# Find Fibonacci i-th
# 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
# 0, 1, 2, 3, 4, 5, 6,  7,  8,  9, 10, 11,  12, ...

def fibonacci_by_loop(i):
    # i from 0 to vo cung
    if i <= 1:
        return i
    a = 0
    b = 1
    for _ in range(2, i + 1):
        a, b = b, a + b
    return b

def fibonacci_by_retrieval(i):
    # i from 0 to vo cung
    if i <= 1:
        return i
    return fibonacci_by_retrieval(i - 1) + fibonacci_by_retrieval(i - 2)

print(fibonacci_by_loop(10))
print(fibonacci_by_retrieval(10))
'''
Output:
55
55
'''
'''
Nhận xét: 
Nếu dùng đệ quy với truờng hợp số rất lớn thì dễ bị xảy ra trường hợp 
stack over flow
'''
