# Viết chương trình thực hiện các chức năng sau:
#    Nhập mảng
#    Sắp xếp các phần tử trong mảng theo thứ tự tăng dần
#    In mảng
# Eg:
#    input: 1 2 4 5 3 6 0 9 8 7
#    output: 0 1 2 3 4 5 6 7 8 9

def inputArray():
    array = []
    string = input().strip().split(' ')
    for num in string:
        if num == '':
            continue
        array.append(int(num))
    return array

def sort_array(array):
    return sorted(array)

def printArray(r):
    for num in r:
        print(num, end= ' ')
    print()

arr = inputArray()
r = sort_array(arr)
printArray(r)
