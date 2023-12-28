# Viết chương trình nhập vào một xâu S, in ra ký tự và số lần xuất hiện của ký tự xuất hiện nhiều nhất trong xâu S. Kết quả in ra dưới dạng: #C #N trong đó #C là ký tự, #N số lần xuất hiện của ký tự #C

def most_char(string: str):
    import operator
    string = string.replace(' ', '')
    dict_char = {}
    for char in string:
        if char not in dict_char:
            dict_char[char] = 1
        else:
            dict_char[char] += 1
    result = max(dict_char.items(), key=operator.itemgetter(1))
    print(result[0], result[1])

most_char(input())

