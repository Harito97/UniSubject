"""
Bài 8: Viết chương trình sắp  xếp  tuple  (name,  age,  score)  theo  thứ  tự  tăng dần,  name  là 
string, age và height là number. Tuple được nhập vào bởi người dùng. Tiêu chí sắp 
xếp là: Sắp xếp theo name sau đó sắp xếp theo age, sau đó sắp xếp theo score. Ưu tiên là 
tên > tuổi > điểm. Nếu đầu vào là: Tom,19,80 
John,20,90 
Jony,17,91 
Jony,17,93 
Json,21,85 
Thì đầu ra sẽ là: [('John', '20', '90'), ('Jony', '17', '91'), ('Jony', '17', '93'), ('Json', '21', '85'), ('Tom', '19', 
'80')] Gợi ý: Sử dụng itemgetter để chấp nhận nhiều key sắp xếp.
"""
from operator import itemgetter

def get_input(filename=None):
    input_data = []
    if filename == None:
        while True:
            data = input()
            if data == '':
                break
            data = data.strip().split(',')
            input_data.append((data[0], data[1], data[2]))
    else:
        with open(file=filename, mode='+rt', encoding='utf-8') as f:
            lines = f.readlines()
            for line in lines:
                data = line.strip().split(',')
                input_data.append((data[0], data[1], data[2]))
    return input_data

def process_sort(data: list):
    # return sorted(data, key=lambda x: (x[0], x[1], x[2]))
    return sorted(data, key=itemgetter(0, 1, 2))

def main(filename=None):
    data = get_input(filename)
    print(process_sort(data))

if __name__ == '__main__':
    # main()
    main('ex8_data.txt')