# Đề bài
'''
Viết chương trình tìm kiếm từ khóa trong các tệp văn bản.

Từ khóa x là một chuỗi, thực hiện tìm kiếm x trong các tệp trong thư mục , kết quả trả về là một Danh sách các Bộ, mỗi phần tử trong danh sách là một bộ gồm (tên tệp, dòng văn bản đầu tiên chứa từ khóa x trong tệp), các phần tử trong danh sách được sắp xếp theo tên tệp. 

Hoàn thiện phương thức searchInFiles(x, path)  trong file FileUtils.py theo mô tả ở trên.
Trong đó, x là từ khóa, path là đường dẫn tới thư mục chứa các file text.

<> Để liệt kê danh sách các tệp và thư mục trong một thư mục có thể dùng phương thức listdir trong module os
Ví dụ: 

import os
os.listdir("đường dẫn tới thư mục")

Gợi ý:
> os.listdir(path) sẽ trả lại danh sách các file/thư mục con bên trong path
> Với mỗi file bên trong path, đọc từng dòng, kiểm tra xem x có trong dòng đó hay không, nếu có thì đưa kết quả vào danh sách chứa kết quả và làm việc với file tiếp theo.
> thực hiện cho đến khi hết các file
'''

import os 

def searchInFiles(x, path):
    listdir = sorted(os.listdir(path))
    result = []
    for direction in listdir:
        f = open(direction, "r")
        for line in f:
            if x in line:
                result.append((path + "/" + direction, line))
                break
        f.close()
    return result

# Here the input/output
'''
Failed tests
Test 1: test anh
Test 2: test em
Test 3: test tình yêu
Test 4: test đẹp
Test 1: test anh
Incorrect program output
--- Input ---

 anh


--- Program output ---

('text10.txt', '“Em bảo anh đi đi,\n')
('text10.txt', 'Sao anh không đứng lại?\n')
('text10.txt', 'Em bảo anh đừng đợi,\n')
('text10.txt', 'Sao anh lại về ngay?\n')
('text10.txt', 'Sao mà anh ngốc thế\n')
('text7.txt', 'Này anh hỡi tình em như lửa\n')
('text7.txt', 'Em chờ đợi mong anh quay lại\n')
('text7.txt', 'Sao anh mãi không về ?\n')
('text7.txt', 'Hay anh mong em phải chết sầu?\n')
('text7.txt', 'Không gặp nhau, tan vỡ hết anh ơi\n')
('text7.txt', 'Cho anh\n')
('text7.txt', 'Cứ rực rỡ soi dấu chân anh để lại\n')
('text5.txt', 'Anh muốn em trả lại tim cho anh,\n')
('text5.txt', 'Bởi tim em anh phải xa mãi mãi.\n')
('text5.txt', 'Sao em muốn giữ tim anh lại?\n')
('text3.txt', 'Quên đón nhận tình anh?\n')
('text2.txt', 'Vô tình anh gặp em\n')
('text2.txt', 'Vô tình anh không nói\n')


--- Expected output (exact text)---

('docs/text10.txt', '“Em bảo anh đi đi,\n')
('docs/text2.txt', 'Vô tình anh gặp em\n')
('docs/text3.txt', 'Quên đón nhận tình anh?\n')
('docs/text5.txt', 'Anh muốn em trả lại tim cho anh,\n')
('docs/text7.txt', 'Này anh hỡi tình em như lửa\n')


Test 2: test em
Incorrect program output
--- Input ---

 em


--- Program output ---

('text10.txt', 'Không nhìn vào mắt em?”\n')
('text9.txt', 'Đều vụt bỏ rơi ta, về với lứa em sau!\n')
('text7.txt', 'Này anh hỡi tình em như lửa\n')
('text7.txt', 'Trên đường đi em ngó bốn bên\n')
('text7.txt', 'Lửa tình nung má em nóng cháy\n')
('text7.txt', 'Để em buồn đứt ruột\n')
('text7.txt', 'Chỉ riêng em đơn lẻ nơi này\n')
('text7.txt', 'Mái lều em rêu mốc, đứng im\n')
('text7.txt', 'Dòng lệ em chan hòa máu đỏ\n')
('text7.txt', 'Hay anh mong em phải chết sầu?\n')
('text7.txt', 'Tuổi trẻ của em trôi như mây khói mong manh\n')
('text7.txt', 'Vì khổ đau hồn em tan nát\n')
('text7.txt', 'Như tro tàn em sống cô đơn\n')
('text7.txt', 'Bên em vội vã\n')
('text7.txt', 'Này vai em như tuyết trắng tinh\n')
('text5.txt', 'Bài số 75: “Anh muốn em…”\n')
('text5.txt', 'Anh muốn em trả lại tim cho anh,\n')
('text5.txt', 'Bởi tim em anh phải xa mãi mãi.\n')
('text5.txt', 'Một khi em không muốn tặng tim mình,\n')
('text5.txt', 'Sao em muốn giữ tim anh lại?\n')
('text3.txt', 'Chỉ còn em đơn thân?\n')
('text3.txt', 'Mà sao hoa – em – gái\n')
('text3.txt', 'Có nghĩa gì em nhỉ?\n')
('text3.txt', 'Nếu em còn cô đơn?\n')
('text2.txt', 'Vô tình anh gặp em\n')
('text2.txt', 'Thế là em hờn dỗi\n')
('text2.txt', 'Vô tình em không biết\n')
('text1.txt', 'Tôi yêu em đến nay chừng có thể\n')
('text1.txt', 'Nhưng không để em bận lòng thêm nữa\n')
('text1.txt', 'Hay hồn em phải gợn bóng u hoài\n')
('text1.txt', 'Tôi yêu em âm thầm, không hy vọng,\n')
('text1.txt', 'Tôi yêu em, yêu chân thành đằm thắm\n')
('text1.txt', 'Cầu em được người tình như tôi đã yêu em\n')


--- Expected output (exact text)---

('docs/text1.txt', 'Tôi yêu em đến nay chừng có thể\n')
('docs/text10.txt', 'Không nhìn vào mắt em?”\n')
('docs/text2.txt', 'Vô tình anh gặp em\n')
('docs/text3.txt', 'Chỉ còn em đơn thân?\n')
('docs/text5.txt', 'Bài số 75: “Anh muốn em…”\n')
('docs/text7.txt', 'Này anh hỡi tình em như lửa\n')
('docs/text9.txt', 'Đều vụt bỏ rơi ta, về với lứa em sau!\n')


Test 3: test tình yêu
Incorrect program output
--- Input ---

 tình yêu


--- Program output ---

('text5.txt', 'Ôi tình yêu, sao nỡ bắt ta đau,\n')
('text3.txt', 'Triết lý của tình yêu\n')


--- Expected output (exact text)---

('docs/text3.txt', 'Triết lý của tình yêu\n')
('docs/text5.txt', 'Ôi tình yêu, sao nỡ bắt ta đau,\n')


Test 4: test đẹp
Incorrect program output
--- Input ---

 đẹp


--- Program output ---

('text8.txt', 'Niềm tin ấy tuyệt đẹp\n')
('text8.txt', 'nhưng sự bất tất cũng đẹp kém gì đâu\n')
('text6.txt', 'Và chiều lòng người đẹp\n')


--- Expected output (exact text)---

('docs/text6.txt', 'Và chiều lòng người đẹp\n')
('docs/text8.txt', 'Niềm tin ấy tuyệt đẹp\n')


Summary of tests

+------------------------------+
|  4 tests run/ 0 tests passed |
+------------------------------+

'''