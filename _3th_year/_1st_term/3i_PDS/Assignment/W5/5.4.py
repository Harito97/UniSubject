# Đề bài 
'''
Cho file văn bản chứa các xâu, trong đó có chứa duy nhất 1 cặp đôi hoàn hảo.

Một cặp đôi (a, b) được gọi là hoàn hảo nếu a khác b và là đảo ngược của b hay nói cách khác ab tạo thành 1 xâu đối xứng (a, b không phải xâu đối xứng)

Ví dụ 123 và 321, hay dfg và gfd là các cặp đôi hoàn hảo. 

12321 và 12321 không phải là cặp đôi hoàn hảo do chúng giống nhau.

Các xâu trong văn bản được phân cách bởi dấu cách, file có nhiều dòng và chứa ký tự Unicode.


Sinh viên hoàn thiện phương thức findCouple(filename), phương thức này nhận vào đối số là tên file, kết quả trả về là 1 bộ (tuple) 2 phần tử tương ứng với cặp đôi hoàn hảo sắp theo thứ tự tăng dần . Ví dụ như minh họa trên thì kết quả trả về là (123, 321)  và (dfg, gfd)

Gợi ý:

> Sinh viên đọc vào cả file văn bản hoặc từng dòng

> Tách văn bản ra thành từng xâu bằng phương thức split() của xâu ký tự, lưu các xâu này vào trong 1 danh sách

> Với mỗi phần tử x trong danh sách, tìm xem có xâu đảo ngược của x cũng có trong danh sách hay không

>> Nếu có thì x và đảo ngược của x chính là cặp đôi cần tìm
'''

def findCouple(filename):
    with open(filename, "r", encoding="utf-8") as f:
        content = f.read()
        word_list = content.split()
        for word in word_list:
            word_reversed = word[::-1]
            if word != word_reversed and word_reversed in word_list:
                if word <= word_reversed:
                    return word, word_reversed
                return word_reversed, word
    return 'None','None'