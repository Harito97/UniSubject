# Một mật khẩu của một tài khoản trên trang web môn học được coi là hợp lệ nếu có đủ các yếu tố sau:

# 1.    Độ dài từ 8 đến 100 ký tự

# 2.    Có chữ cái in hoa

# 3.    Có chữ cái thường

# 4.    Có số

# 5.    Có ký tự đặc biệt là một trong các ký tự sau: ~!@#$%^&*
           
# Viết chương trình nhập vào một mật khẩu, kiểm tra xem mật khẩu đó có hợp lệ theo quy tắc ở trên hay không?

# Hoàn thành hàm checkPassword(s) trong file Password.py, hàm này trả về True nếu mật khẩu là hợp lệ, trả lại false nếu mật khẩu không hợp lệ.
       
def checkPassword(s):
    # Check lchar in special:
    if not 8 <= len(s) <= 100:
        return False
    special = '~!@#$%^&*'
    is_upper, is_lower, is_digit, is_special = False, False, False, False
    for char in s:
        if char.islower():
            is_lower = True
        elif char.isupper():
            is_upper = True
        elif char.isdigit():
            is_digit = True
        elif char in special:
            is_special = True
    return is_upper and is_lower and is_digit and is_special

# Test
s = 'nf93#@%#NNNDda'
print('Is', s, 'a good password: ', checkPassword(s))
