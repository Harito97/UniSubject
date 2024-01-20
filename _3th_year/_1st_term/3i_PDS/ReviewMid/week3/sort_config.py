def customSort(a):
    '''
    Hàm thực hiện sắp xếp các phần tử trong a, theo thứ tự:
    - Chẵn bên trái, lẻ bên phải
    - Chẵn tăng dần, lẻ giảm dần
    ví dụ a  = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    kết quả là [2, 4, 6, 8, 10, 9, 7, 5, 3, 1]
    '''
    left, right = [], []
    for el in a:
        if el % 2 == 0:
            left.append(el)
        else:
            right.append(el)
    a = sorted(left) + sorted(right, reverse= True)  
    return a

# Test
a = [1,2,3,4,5,6,7,8,9,10]
print(customSort(a))
