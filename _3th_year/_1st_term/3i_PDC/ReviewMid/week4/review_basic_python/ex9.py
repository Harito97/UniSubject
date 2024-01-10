"""
Bài 9: Một Robot di chuyển trong mặt phẳng bắt đầu từ điểm đầu tiên (0,0). Robot có thể 
di chuyển theo hướng UP, DOWN, LEFT và RIGHT với những bước nhất định. Dấu 
di chuyển của robot được đánh hiển thị như sau: UP 5 DOWN 3 LEFT 3 RIGHT 3 
Các con số sau phía sau hướng di chuyển chính là số bước đi. Hãy viết chương trình 
để  tính  toán  khoảng  cách  từ  vị  trí  hiện  tại đến  vị  trí đầu tiên, sau khi robot đã di 
chuyển một quãng đường. Nếu khoảng cách là một số thập phân chỉ cần in só nguyên 
gần nhất. Ví dụ: Nếu tuple sau đây là input của chương trình: 
UP 5 
DOWN 3 
LEFT 3 
RIGHT 2 
thì đầu ra sẽ là 2.
"""
str 
def get_input(filename=None):
    input_data = []
    if filename == None:
        while True:
            data = input()
            if data == '':
                break
            data = data.strip().split()
            input_data.append((data[0], data[1]))
    else:
        with open(file=filename, mode='+rt', encoding='utf-8') as f:
            lines = f.readlines()
            for line in lines:
                data = line.strip().split()
                input_data.append((data[0], data[1]))
    return input_data

def process(data: list):
    x, y = 0, 0
    for pair in data:
        if pair[0].upper() == 'LEFT':
            x -= int(pair[1])
        elif pair[0].upper() == 'RIGHT':
            x += int(pair[1])
        elif pair[0].upper() == 'UP':
            y += int(pair[1])
        elif pair[0].upper() == 'DOWN':
            y -= int(pair[1])
    from math import sqrt
    return int(sqrt(x*x + y*y))

def main(filename=None):
    data = get_input(filename)
    print(process(data))

if __name__ == '__main__':
    # main()
    main('ex9_data.txt')