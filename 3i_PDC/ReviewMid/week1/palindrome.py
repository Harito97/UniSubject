# Hoàn thiện hàm is_palindrome(p), 
# hàm này thực hiện kiểm tra số nguyên p 
# có phải là số đối xứng hay không, 
# nếu có thì trả lại giá trị True, 
# và ngược lại thì trả lại giá trị False.

def is_palindrome(p):
    num = str(p)
    for i in range(int(len(num)/2) + 1):
        if num[i] != num[- i - 1]:
            return False
    return True

p = int(input())
print(is_palindrome(p))        
