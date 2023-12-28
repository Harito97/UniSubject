# Hoàn thiện hàm customSort

import functools

def customSort(a):
    """
    Hàm thực hiện sắp xếp các phần tử trong a, theo thứ tự:
    - Chẵn bên trái, lẻ bên phải
    - Chẵn tăng dần, lẻ giảm dần
    ví dụ a  = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    kết quả là [2, 4, 6, 8, 10, 9, 7, 5, 3, 1]
    """

    # Cách 1
    # temp_left = []
    # temp_right = []

    # while len(a) != 0:
    #     temp = min(a)
    #     a.remove(temp)
    #     if temp % 2 == 0:
    #         temp_left.append(temp)
    #     else:
    #         temp_right.append(temp)
    # temp_right = temp_right[::-1]

    # a = temp_left + temp_right

    # Cách 2: Định nghĩa ra tiêu chí so sánh bằng cách dùng hàm compare và thư viện functools
    # a = a.sort(key = functools.cmp_to_key(compare)) # thế này trả về None vì phương thức sort của list tác động trực tiếp vào list nên trả về None (không có giá trị trả về)
    a.sort(key = functools.cmp_to_key(compare))
    return a

def compare(a, b):
    if a % 2 == b % 2:
        if a % 2 == 0:
            return a - b
        else:
            return b - a
    else:
        if a % 2 == 0:
            return -1
        else:
            return 1

a = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
print(customSort(a))
