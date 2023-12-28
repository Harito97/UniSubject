"""
Bài 3: 
Viết chương trình đọc dữ  liệu từ tệp  input.txt, in dữ  liệu đọc được theo thứ tự đảo 
ngược ra file reverse.txt  Ví dụ input.txt có các dòng 123 456 789 Thì file reverse.txt có các dòng là 987 654 321
"""

def get_input(filename_input: str):
    result = []
    with open(filename_input) as f:
        lines = f.readlines()
        for line in lines:
            result += line.strip().split()
    return result

def export_output(filename_output: str, data: str):
    with open(filename_output, 'w') as f:
        f.write(data)

def main(filename_input: str, filename_output: str):
    data = get_input(filename_input)
    result = ''
    for number in data:
        result += number[::-1] + '\n'
    export_output(filename_output, result)
    
if __name__ == '__main__':
    main('ex3_data_input.txt', 'ex3_data_output.txt')