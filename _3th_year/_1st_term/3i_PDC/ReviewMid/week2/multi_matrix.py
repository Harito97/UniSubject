# Viết chương trình cho phép nhập 2 ma trận A và B có kịch thước tương ứng là (NxM) và (MxD) từ bàn phím, thực hiện phép nhân ma trận AxB.

#    Hàm inputMatrix() thực hiện việc nhập và trả lại một ma trận (mảng 2 chiều)  các số nguyên. Dòng đầu là kích thước ma trận nxm, n dòng tiếp theo là các hàng trong ma trận.
#    Hàm multiMatrix(m1, m2) thực hiện việc nhân hai ma trận và trả lại một ma trận các số nguyên.
#    Hàm printMatrix(m) thực hiện in ra ma trận.
#    Input: 
#        ma trận A: NxM
#        ma trận B: MxD
#    Output:
#        ma trận C: NxD

def inputMatrix():
    m = []
    size = list(map(int, input().split()))
    for i in range(size[0]):
        line = list(map(int, input().split()))
        array = []
        for j in range(size[1]):
            array.append(line[j])
        m.append(array)
    return m

def multiMatrix(m1, m2):
    # axb * bxc = axc
    r = [   [0 for _ in range(len(m2[0]))]     for _ in range(len(m1))]
    #                           c                              a
    # -> r have size axc
    for i in range(len(m1)):            # Iterator each row
        for j in range(len(m2[0])):     # Iterator each col
            for _ in range(len(m2)):    # Iterator each element on row's m1 and col's m2
                r[i][j] += m1[i][_] * m2[_][j]
    return r

def printMatrix(m):
    print(m)

m1 = inputMatrix()
m2 = inputMatrix()

mm = multiMatrix(m1, m2)
printMatrix(mm)
