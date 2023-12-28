'''
Đề bài: Viết chương trình cho phép nhập 2 ma trận A và B có kịch thước tương ứng là (NxM) và (M XD) từ bàn phím, thực hiện phép nhân ma trận AxB.

    Hàm inputMatrix() thực hiện việc nhập và trả lại một ma trận (mảng 2 chiều)  các số nguyên.
    Hàm multiMatrix(m1, m2) thực hiện việc nhân hai ma trận và trả lại một ma trận các số nguyên.
    Hàm printMatrix(m) thực hiện in ra ma trận.
    Input: 
        ma trận A: NxM
        ma trận B: MxD
    output:
        ma trận C: NxD
'''

'''
--- Input ---

3 2
1 2
4 5
7 8
2 3
1 0 1
1 0 1

--- Program output ---

--- Expected output (exact text)---

3 0 3
9 0 9
15 0 15

'''


def inputMatrix():
    # m = []
    # while True:
    #     string = input()
    #     if string == "":
    #         break
    #     nums = string.split(" ")
    #     m.append(list(map(int, nums)))
    # return m
    while input() == "":
        m = []
        size_row, size_col = map(int, input().split(" "))
        for i in range(size_row):
            row = list(map(int, input().split(" ")))
            m.append(row)
        return m
	
def multiMatrix(m1, m2):
    r = [[0 for _ in range(len(m2[0]))] for _ in range(len(m1))]

    for i in range(len(m1)):
        for j in range(len(m2[0])):
            for k in range(len(m1[0])):
                r[i][j] += m1[i][k] * m2[k][j]

    return r
	
def printMatrix(m):
    for row in m:
        for num in row:
            print(num, end = " ")
        print()

m1 = inputMatrix()
m2 = inputMatrix()

mm = multiMatrix(m1, m2)
printMatrix(mm)