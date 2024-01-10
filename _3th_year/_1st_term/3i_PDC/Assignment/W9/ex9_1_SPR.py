'''
Biểu diễn vector thưa. Trong thực tế có nhiều bài toán làm việc với dữ liệu là các vector với kích thước rất lớn, 
nhưng đa phần các thành phần trên vector này đều có giá trị bằng 0, 
chỉ có một số ít các thành phần có giá trị khác không. 
Do vậy, thay vì biểu diễn vector đầy đủ với rất nhiều vị trí bằng 0, 
t =  [0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 5, 0, 0, 0, 9, 0] 
ta có thể biểu diễn vectơ bằng cách chỉ biển diễn thông tin kích thước vec tơ 
và các thành phần khác không của vector. 
Như ví dụ trên, ta có thể biểu diễn t bằng 1 bộ (tuple) 2 phần tử spr =(16, {5:1, 10: 5, 14: 9}) 
biểu diễn kích thước vector t = 16, và các thành phần khác 0 (đánh chỉ số từ 0): vị trí 5 = 1,  vị trí 10 = 5,  vị trí 14 = 9.

Hoàn thiện các hàm trong file SPR.py theo các yêu cầu sau:

1.    Hàm sparseForm(t): Hàm này tính và trả lại biểu diễn (spr) thưa của vector t theo mô tả trên.

2.    Hàm revert(spr): Hàm này trả về vector tương ứng với biểu diễn thưa spr.  

3.    Hàm dot(spr1, spr2): Thực hiện tính và trả lại tích vô hướng của 2 vector u, v được biểu diễn bởi biểu diễn thưa spr1 và spr2.

4.    Hàm getCosineSim(spr1, spr2): thực hiện tính và trả lại giá trị cosine của góc giữa 2 vector u, v được biểu diễn tương ứng bởi 2 biểu diễn thưa spr1 và spr2.

Cosine của góc giữa hai vector được tính theo công thức sau:
'''
def sparseForm(t):
    # dictionary = {}
    # length = len(t)
    # for i in range(length):
    #     if t[i] != 0:
    #         dictionary[i] = t[i]
    # return length, dictionary
    return len(t), {i:t[i] for i in range(len(t)) if t[i] != 0}
    
def revert(spr):
    result_vector = [0] * spr[0]
    for i in spr[1]:
        result_vector[i] = spr[1][i]
    return result_vector

def dot(spr1, spr2):
    # result = 0
    # min_degree = min(spr1[0], spr2[0]) # các chiều cao hơn bị thừa 
    # # thì sẽ nhân với chiều còn thiếu của vector kia mặc định là 0 nên kết quả sẽ vẫn là 0
    # for i in range(min_degree):
    #     if i in spr1[1] and i in spr2[1]:
    #         result += spr1[1][i] * spr2[1][i]
    return sum(spr1[1][i] * spr2[1][i] for i in spr1[1] if i in spr2[1])
    
def getCosinSim(spr1, spr2):
    # from math import sqrt
    # dot_2_vector = dot(spr1, spr2)
    # _spr1_, _spr2_ = 0, 0
    # max_degree = max(spr1[0], spr2[0])
    # for i in range(max_degree):
    #     if i in spr1[1]:
    #         _spr1_ += spr1[1][i] ** 2
    #     if i in spr2[1]:
    #         _spr2_ += spr2[1][i] ** 2
    # return dot_2_vector / (sqrt(_spr1_) * sqrt(_spr2_))
    from math import sqrt
    uv = dot(spr1, spr2)
    uu = sqrt(sum(v*v for v in spr1[1].values()))
    vv = sqrt(sum(v*v for v in spr2[1].values()))
    return uv / uu / vv

'''
Test 4: test 4 getCosineSim
Incorrect program output
--- Input ---

T4
34 :: 5:1 11:9 14:8 17:6 20:7 21:5 22:1 25:2 26:8 32:5 33:1
34 :: 1:2 3:3 5:4 11:8 15:1 18:1 22:1 25:1 29:1 30:1 31:1 33:1
34 :: 0:1 1:2 2:5 4:1 12:9 16:2 20:2 23:3 25:1 30:4 31:5 32:6 33:7
34 :: 1:2 3:3 5:4 11:8 15:1 17:1 22:1 25:1 29:1 30:1 31:1 32:1


--- Program output ---

Traceback (most recent call last):
  File "Main.py", line 77, in <module>
    print('%.5f'%(spr.getCosinSim((n,sp),(n1,sp1))))
  File "/home/p10958/SPR.py", line 27, in getCosinSim
    dot = dot(spr1, spr2)
UnboundLocalError: local variable 'dot' referenced before assignment


--- Expected output (exact text)---

0.42489
0.12438


Summary of tests

+------------------------------+
|  4 tests run/ 3 tests passed |
+------------------------------+

==> kinh nghiệm rút ra là không đặt tên biến trùng với tên hàm, phương thức để tránh lỗi không mong muốn
'''
