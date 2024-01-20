# Viết chương trình nhập vào ma trận từ bàn phím, kiểm tra xem ma trận có phải là ma phương hay không?
# Ma trận ma phương là ma trận có tổng các hàng, các cột và các đường chéo bằng nhau.

# > Hàm isMagicSquare là hàm kiểm tra tính chất ma phương của một ma trận
# > Hàm inputMatrix() thực hiện việc nhập và trả lại một ma trận (mảng 2 chiều)  các số nguyên.
# + Mỗi hàng của ma trận được nhập trên 1 dòng, mỗi số cách nhau bởi 1 dấu tab ('\t')
# + Việc nhập kết thúc khi gặp dòng trống

def isMagicSquare(m):
    sum_row = sum(num for num in m[0])
    
    # Check sum row
    for row in m:
        temp = sum(num for num in row)
        if temp != sum_row:
            return False

    # Check sum col
    for i in range(len(m[0])):
        temp = sum(m[j][i] for j in range(len(m)))     
        if temp != sum_row:
            return False

    # Check diagonal line
    temp = 0
    for i in range(len(m)):
        temp += m[i][i]
    if temp != sum_row:
        return False
    
    temp = 0
    for i in range(len(m)):
        temp += m[i][len(m) - 1 - i]
    if temp != sum_row:
        return False

    # Final return True
    return True

def inputMatrix():
    m = []
    line = input()
    while line != '':
        array = line.strip().split('\t')
        array = [int(num) for num in array]
        m.append(array)
        line = input()
    return m

# Test
m = inputMatrix()
# print(m)
print(isMagicSquare(m))

