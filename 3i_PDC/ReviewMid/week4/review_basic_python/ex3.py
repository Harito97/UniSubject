"""
Bài 3: Nhập vào một danh sách các chuỗi từ một dòng từ bàn phím (mỗi chuỗi cách nhau 
bởi 1 dấu cách), sinh ra từ điển gồm khóa là chuỗi s, và giá trị là xâu đối xứng tạo 
được từ s và đảo ngược của s. Ví dụ s = “abc”, xâu đối xứng là “abccba”.  In từ điển ra màn hình. Gợi ý: 
Để tạo xâu đối xứng của một xâu s, ta có thể sử dụng vòng lặp, sử dụng phương thức 
reversed của kiểu danh sách, hoặc sử dụng kỹ thuật trượt (slicing) ví dụ s[::-1],..
"""

def get_input():
    return input("Nhập vào 1 dòng gồm các string ngăn cách bởi dấu cách: ").strip().split()

def create_dict(string_list: list):
    dictionary = {}
    for string in string_list:
        dictionary[string] = string + string[::-1]
    return dictionary

def main():
    print(create_dict(get_input()))

if __name__ == '__main__':
    main()
