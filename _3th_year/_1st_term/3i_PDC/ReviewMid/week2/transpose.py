# Viết chương trình thực hiện các chức năng sau:

#    Nhập ma trận vuông 2 chiều M: NxN
#    Thực hiện phép chuyển vị cho ma trận M
#    In ra ma trận chuyển vị

def inputMatrix():
    m = []
    row = input()
    while row != '':
        row = list(map(int, row.split()))
        m.append(row)
        row = input()
    return m

def transpose(m):
    t = []
    for row_index in range(len(m[0])):
        row = []
        for col_index in range(len(m)):
            row.append(m[col_index][row_index])
        t.append(row)
    return t

def printMatrix(t):
    for row in t:
        # print(row, sep= '\t')
        print(*row, sep= '\t')

m = inputMatrix()
t = transpose(m)
printMatrix(t)
