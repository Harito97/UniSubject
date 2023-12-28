"""
Bài 1.
Viết chương trình tìm tất cả các số chia hết cho 11 nhưng không phải bội số của 3,
nằm trong đoạn 1100 và 9090 (tính cả 1100 và 9090). Các số thu được sẽ được in
thành chuỗi trên một dòng, cách nhau bằng dấu chấm phẩy và dấu cách “; ”.
Ví dụ “7; 14; 21”
Gợi ý:
Sử dụng range(#begin, #end), sử dụng phương thức join của kiểu String để in kết
quả.
"""
def main(begin: int, end: int):
    result = []
    for i in range(begin, end + 1):
        if i % 11 == 0 and i % 3 != 0:
            result.append(str(i))
    print('; '.join(result))

if __name__ == '__main__':
    main(1100, 9090)
