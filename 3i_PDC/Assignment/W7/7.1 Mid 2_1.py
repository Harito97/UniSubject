
def getTop2gram(filename, n):
    '''
    Hàm trả lại danh sách (list) n 2-gram  có số lần nhiều nhất trong file văn bản filename.
    Trong file văn bản filename, mỗi từ phân cách nhau bởi dấu cách, một 2-gram là ghép của 2 từ đi liền nhau trong một dòng,
    ví dụ "a b c d" sẽ có các 2 gram là 'a b', 'b c' và 'c d'
    Danh sách kết quả được sắp xếp giảm dần theo thứ tự từ điển của các 2 gram.
    Nếu 2 2-gram có tần số xuất hiện bằng nhau thì ưu tiên 2-gram có thứ tự từ điển lớn hơn 
    (ví dụ 'd a' > 'c a' vì vậy nếu 'd a' và 'c a' có cùng số lần xuất hiện thì lấy 'd a')
    Ví dụ, file văn bản có nội dung như sau: 
    "
    a b c a a a b c d f d a d a f g s g h f s s a
    a g h b c e f g m n j s a r t y y u v z x k l a   
    "
    
    danh sách các 2-gram cùng số lần xuất hiện sắp xếp theo số lần xuất hiện tăng dần, 2-gram tăng dần theo thứ tự từ điển như sau:
    
    [('b c', 3), ('s a', 2), ('g h', 2), ('f g', 2), ('d a', 2), ('a b', 2), ('a a', 2), ('z x', 1), 
    ('y y', 1), ('y u', 1), ('x k', 1), ('v z', 1), ('u v', 1), ('t y', 1), ('s s', 1), ('s g', 1), 
    ('r t', 1), ('n j', 1), ('m n', 1), ('l a', 1), ('k l', 1), ('j s', 1), ('h f', 1), ('h b', 1), 
    ('g s', 1), ('g m', 1), ('f s', 1), ('f d', 1), ('e f', 1), ('d f', 1), ('c e', 1), ('c d', 1), 
    ('c a', 1), ('a r', 1), ('a g', 1), ('a f', 1), ('a d', 1)]
    
    Như vậy với n = 5, kết quả là
    
   ['s a', 'g h', 'f g', 'd a', 'b c']
    
    
    Chú ý, file văn bản có nhiều dòng và không có ký tự unicode
    Nếu n > số 2gram thì kết quả là toàn bộ danh sách các 2gram.
    '''
    result_dict = {}
    with open(filename, "rt") as f:
        for line in f:
            gram1 = line.split()
            for i in range(len(gram1) - 1):
                gram2 = gram1[i] + " " + gram1[i + 1]
                if gram2 in result_dict:
                    result_dict[gram2] += 1
                else:
                    result_dict[gram2] = 1
    result_list = sorted(result_dict.items(), key=lambda x: (x[1],x[0]), reverse=True)
    # result_list là 1 list có các (key, value) sắp xếp value (int) giảm dần, key (string nên không dùng -x[0] được) giảm dần
    result_list = sorted(list(result_list)[:n], reverse=True)
    # result_list là 1 list có n phần tử (n = len(result_list cũ) nếu n > len(result_list cũ)) có các (key, value) sắp xếp key (string) giảm dần
    result_list = list(map(lambda x: x[0], result_list))
    return result_list

def getVector(filename, top2gram):
    '''
        Hàm này trả lại danh sách (list) số nguyên tương ứng với vector biểu diễn văn bản trong file filename.
        phần tử thứ i trong danh sách là số lần top2gram[i] xuất hiện trong văn bản.
        
        ví dụ văn bản là 
        "
        a b c a a a b c d f d a d a f g s g h f s s a
        a g h b c e f g m n j s a r t y y u v z x k l a   
        "        
        
        
        top2gram = ['s a', 'g h', 'f g', 'd a', 'b c']
        
        kết quả là: [2, 2, 2, 2, 3]
        
    '''
    result_dict = {}
    for gram2 in top2gram:
        result_dict[gram2] = 0
    with open(filename, "rt") as f:
        for line in f:
            gram1 = line.split()
            for i in range(len(gram1) - 1):
                gram2 = gram1[i] + " " + gram1[i + 1]
                if gram2 in result_dict:
                    result_dict[gram2] += 1
    return list(result_dict.values())
    

def getDistance(u, v):
    from math import sqrt
    '''
        Phương thức tính khoảng cách giữa 2 điểm u, v trên không gian vector
        
        u = (u1, u2,..., un)
        v = (v1, v2,..., vn)
        
        
        ví dụ với u = [1,2,3,4], v = [1,2,1,1], kết quả làm tròn đến 5 chữ số là: 3.60555
    '''
    if len(u) != len(v):
        if len(u) < len(v):
            u = u + [0] * (len(v) - len(u))
        else:
            v = v + [0] * (len(u) - len(v))
    result = 0
    for i in range(len(u)):
        result += (u[i] - v[i]) ** 2
    return sqrt(result)


def coshTaylor(x, e):
    '''
     Viết chương trình tính sinh(x) theo khai triển Taylor,
     trong đó e là sai số để xác định  thời điểm dừng thuật toán,
     Thuật toán dừng lại tại số hạng Pi nếu |Pi - Pi-1| <= e 
     
     ví dụ x = 5.5, e = 0.00001 kết quả làm tròn đến 5 chữ số là: 122.34801
          nhưng với e = 0.5     kết quả làm tròn đến 5 chữ số là: 92.69794
     
    '''
    # cosh(x) = 1 + (x^2 / 2!) + (x^4 / 4!) + (x^6 / 6!) + (x^8 / 8!) + ...
    temp, index_run, pi = x**2/2, 2, 1
    result = pi
    while abs(temp) > e:
        pi += temp
        temp = temp * (x**2) / ((index_run + 1) * (index_run + 2))
        index_run += 2
    return pi + temp + temp * (x**2) / ((index_run + 1) * (index_run + 2)) # cosh(x) = p_(i+1) + O(n)




'''
    Chú ý, các phương thức sẽ được gọi đến để chấm điểm, 
    do vậy bài nộp của sinh viên cần phải bỏ hết (hoặc comment #) các lệnh in ra màn hình
     
'''


def testDemo():
    import os
    current_dir = os.path.dirname(os.path.abspath(__file__))  # Lấy đường dẫn thư mục chứa file b.py
    file_path = os.path.join(current_dir, 'text.txt')

    print(getTop2gram(file_path, 5))
    print(getVector(file_path, getTop2gram(file_path, 5)))
    print(round(getDistance([1, 2, 3, 4], [1, 2, 1, 1]), 5))
    print(round(coshTaylor(5.5, 0.5), 5))
    

'''
Bỏ comment lệnh testDemo() dưới đây để chạy chương trình, và comment lại lệnh đó khi nộp bài
'''
# testDemo()

# print(round(coshTaylor(3.4, 0.0001), 5))
# print(round(coshTaylor(6, 0.5), 5))
'''
Test 4: test4 coshTaylor
Incorrect program output
--- Input ---
 test4
number_of_test 2
3.4 0.0001
6 0.5

--- Program output ---
14.99872
201.56331

--- Expected output (exact text)---
14.99874
201.71401

Summary of tests
+------------------------------+
|  4 tests run/ 3 tests passed |
+------------------------------+
'''
