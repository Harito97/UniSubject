# Viết chương trình thực hiện các chức năng sau:

#    Nhập ma trận
#    Kiểm tra xem ma trận đó có phải ma trận tam giác trên hay không?

def inputMatrix():
    m = []
    line = input()
    while line != '':
        row = list(map(int, line.split()))
        m.append(row)
        line = input()
    return m


def isUpperTriangleMatrix(m):
    if len(m) != len(m[0]):
        return False
    # $$$$
    # #$$$
    # ##$$
    # ###$ with # = 0
    for row in range(1, len(m)):
        for col in range(row):
            if m[row][col] != 0:
                return False
    return True


m = inputMatrix()
print(isUpperTriangleMatrix(m))
