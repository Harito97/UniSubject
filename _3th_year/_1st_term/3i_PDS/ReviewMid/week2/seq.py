# Hoàn thiện các hàm trong file Seq.py thực hiện các yêu cầu sau

# 1. Hàm isAlt(a) thực hiện kiểm tra dãy số a có phải là dãy đan dấu hay không? Nếu đúng trả về giá trị là True/ Nếu sai trả về giá trị là False

# 2. Hàm isGrow(a) thực hiện kiểm tra dãy số a có phải là dãy tăng hay không? Nếu đúng trả về giá trị là True/ Nếu sai trả về giá trị là False

# 3. Hàm isMulti(a) thực hiện kiểm tra dãy số a có phải là cấp số nhân hay không? Nếu đúng trả về giá trị là True/ Nếu sai trả về giá trị là False

# 4. Hàm isAdd(a) thực hiện kiểm tra dãy số a có phải là cấp số cộng hay không? Nếu đúng trả về giá trị là True/ Nếu sai trả về giá trị là False

# * Sai số chấp nhận cho các phép tính là 10e-10

def isAlt(a):
    for i in range(len(a) - 1):
        if a[i] * a[i + 1] > 0:
            return False
    return True

def isGrow(a):
    for i in range(len(a) - 1):
        if a[i] >= a[i + 1]:
            return False
    return True

def isMulti(a):
    q = a[0] / a[1] 
    for i in range(len(a) - 1):
        if abs(a[i] / a[i + 1] - q) >= 10e-10:
            return False
    return True

def isAdd(a):
    d = a[0] - a[1]
    for i in range(len(a) -1):
        if abs(a[i] - a[i + 1] - d) >= 10e-10:
            return False
    return True

# Test
a1 = [1,-2,3,-4,5]
a2 = [1,2,3,2,1]
a3 = [1,2,3,4,5]
a4 = [1,2,4,8,16]

print(isAlt(a1), True)
print(isAlt(a2), False)
print(isGrow(a3), True)
print(isGrow(a1), False)
print(isMulti(a4), True)
print(isMulti(a1), False)
print(isAdd(a3), True)
print(isAdd(a1), False)

