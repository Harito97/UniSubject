# Hàm f(x) liên tục trên đoạn [a, b]
# và có f(a)*f(b) < 0
# thì tồn tại giá trị c thuộc [a, b] sao cho f(c) = 0.
# Hoàn thiện hàm solver(f, a, b, e=0.00001)
# để tìm nghiệm xấp xỉ của phương trình f(x) = 0.
# trong các đối số có f là 1 hàm,
# khi đó lời gọi hàm f(t) sẽ trả lại giá trị của hàm f tại điểm t.
# nghiệm cần tìm là giá trị c sao cho |f(c)| <= e.
# Dùng hàm abs trong module math để tính giá trị tuyệt đối.  
# Áp dụng phương pháp chia đôi để tìm nghiệm gần đúng của phương trình.

def solver(f, a, b, e=0.000001):
    # f(a)*f(b) will all < 0
    c = (a + b) / 2
    if abs(f(c)) <= e:
        return c
    elif f(c) * f(a) < 0:
        return solver(f, a, c, e) 
    elif f(c) * f(b) < 0:
        return solver(f, c, b, e)

f = lambda x: 3*x*x - 4*x - 6
print(solver(f, 0, 9))
