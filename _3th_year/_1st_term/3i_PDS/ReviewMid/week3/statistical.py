# Viết chương trình tính giá trị trung bình phương sai, độ lệch chuẩn của  một danh sách các số thực

# 1.    Giá trị trung bình là trung bình cộng của các giá trị trong danh sách

# 2.    Phương sai tính bằng công thức  

# công thức tính phương sai

# trong đó e là giá trị trung bình, xi là giá trị thứ i của danh sách.

# 3.    Độ lệch chuẩn được tính bằng căn bậc 2 của phương sai.

def mean(s):
    return sum(s) / len(s)

def variance(s):
    mean_value = mean(s)
    error = [(num - mean_value) * (num - mean_value) for num in s] 
    return sum(error) / len(s)

def standarddeviation(s):
    from math import sqrt
    return sqrt(variance(s))

# Test
s = [1,2,3,4,5,5,6]
print(mean(s), variance(s), standarddeviation(s), sep= '\n')

