"""
Cho một danh sách các số nguyên, trong đó các phần tử đều xuất hiện đúng 2 lần, ngoại trừ duy nhất 1 phần tử xuất hiện đúng 1 lần. Tìm phần tử xuất hiện đúng 1 lần trong danh sách.


Ví dụ a = [1,2,3,2,3,1,4,5,4] phần tử cần tìm là 5

hoàn thiện hàm findUniq(a) trong file Pract.py theo các mô tả trên.

Hàm này nhận đối số a là danh sách số nguyên và trả về 1 số nguyên là phần tử xuất hiện duy nhất 1 lần trong danh sách a.

<> Chú ý, test chương trình sẽ khá lớn, bạn nên làm với thuật toán với độ phức tạp ~O(n), với các giải thuật với độ phức tạp lớn hơn có thể chương trình sẽ không đạt được điểm tối đa. 

Chương trình bạn cần chạy trong thời gian <= 100000 microsecond (100 ms)
"""

def findUniq(a):
    '''
    Tìm phần tử xuất hiện đúng 1 lần trong danh sách.

    Ví dụ a = [1,2,3,2,3,1,4,5,4] phần tử cần tìm và trả về là 5
    
    '''
    uniq_number = 0
    for number in a:
        uniq_number ^= number
    return uniq_number

def test():
    a = [1,2,3,2,3,1,4,5,4,5,5] # cách này may là để chỉ yêu cầu mỗi số xuất hiện <= 2 lần và chỉ có 1 số xuất hiện 1 lần
    print(findUniq(a))

test()