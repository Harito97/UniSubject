# Nhập vào một danh sách gồm Họ tên từ bàn phím

# Viết hàm tách tên và họ đệm từ một chuỗi họ tên, sắp xếp danh sách  họ tên theo tên, nếu tên trùng nhau thì sắp theo họ đệm.

# > Hàm inputList() thực hiện việc nhập và trả lại danh sách họ tên từ bàn phím, mỗi chuỗi họ tên trên 1 dòng, việc nhập kết thúc khi gặp dòng trống
# > Hàm getName(s) trả lại bộ gồm 2 chuỗi tương ứng là họ đệm và tên từ chuỗi s
# > Hàm sortNamesList(names) thực hiện sắp xếp danh sách  họ tên names theo tên, nếu tên trùng nhau thì sắp theo họ đệm, kết quả trả về một danh sách đã được sắp xếp theo Tên, họ đệm.

# -*- coding: utf-8 -*-
import locale

locale.setlocale(locale.LC_ALL, 'vi_VN.utf8')

def inputList():
    names = []
    line = input()
    while line != '':
        names.append(line.strip())
        line = input()
    return names
    
def getName(s):
    s = s.split(' ')
    lname = s[-1]
    fname = ' '.join(s[:-1]) 
    return (lname, fname)
    
def sortNamesList(names):
    return sorted(names, key= lambda x: tuple(locale.strxfrm(name) for name in getName(x)))

# Test
names = inputList()
print(names)
names = sortNamesList(names)
print(names)

