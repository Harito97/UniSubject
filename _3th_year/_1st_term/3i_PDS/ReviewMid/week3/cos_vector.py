# Viết chương trình tính góc giữa 2 vector:

# Hoàn thiện hàm def cosineb2v(u,v) trong file Vec.py, hàm này trả về giá trị cosine của góc giữa hai vector u và v:

def cosineb2v(u, v):
    if len(u) != len(v):
        return None

    from math import sqrt

    uv = sum([u[i]*v[i] for i in range(len(u))])
    _u_ = sqrt(sum([u_i*u_i for u_i in u]))
    _v_ = sqrt(sum([v_i*v_i for v_i in v]))

    return uv / (_u_ * _v_)

# Test
u = [1,2,3,45]
v = [1,2,3,4]
print(cosineb2v(u, v))
