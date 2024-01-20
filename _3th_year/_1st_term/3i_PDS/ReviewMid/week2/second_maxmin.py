# Viết chương trình thực hiện các chức năng sau:

#    Nhập mảng
#    Tìm phần tử nhỏ thứ hai và lớn thứ 2 trong mảng

def input_array():
    array = []
    string = input().strip().split()
    for num in string:
        array.append(int(num))
    return array

def find_second_max_min(array):
    a = 0 # second_max
    b = max(array) # second_min
    ma = max(array)
    mi = min(array)
    for el in array:
        if el > a and el < ma:
            a = el
        if el < b and el > mi:
            b = el
    return a, b

array = input_array()
print(find_second_max_min(array))
