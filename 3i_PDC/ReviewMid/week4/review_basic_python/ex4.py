"""
Bài 4: 
Python có nhiều hàm được tích hợp sẵn, nếu không biết cách sử dụng nó, bạn có thể 
đọc tài  liệu trực tuyến  hoặc tìm  vài cuốn sách. Nhưng Python cũng có sẵn tài  liệu 
(__doc__) về hàm cho  mọi hàm tích hợp trong Python. Yêu cầu của bài tập này là 
viết  một  chương  trình  để  in  tài  liệu  về  một  số  hàm  Python  được  tích  hợp  sẵn 
như abs(), int(), input() và thêm tài liệu cho hàm bạn tự định nghĩa.
"""
def add(a: int, b: int):
    """
    :para a: the first number
    :para b: the second nubmer
    :return: result of sum 2 integer
    """
    return a + b

print("abs() doc:", abs.__doc__)
print("add() doc:", add.__doc__)
