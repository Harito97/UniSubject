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

import numpy as np 

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
    m1_array = np.array(m1)
    m2_array = np.array(m2)

    r = np.dot(m1_array, m2_array)

    return r
	
def printMatrix(m):
    for r in m:
        row = ' '.join(str(i) for i in r)

m1 = inputMatrix()
m2 = inputMatrix()

mm = multiMatrix(m1, m2)
printMatrix(mm)