echo '1. Hiển thị người dùng đã đăng nhập vào hệ thống và hoạt động của người dùng đó.'
w

echo '2. Hiển thị mã người dùng và mã nhóm người dùng của người dùng đang đăng nhập vào hệ thống.'
id

echo '3. Tạo một người dùng mới có tên là user1 có thư mục người dùng là "/home/user1" và mật khẩu là "123456". Sau đó hiển thị mã id và mã group của người dùng user1.'
sudo su
useradd -m -d /home/user1 user1
passwd user1 

echo '4. Hiển thị tất cả cả nhóm người dùng trong hệ thống và danh sách các nhóm người dùng thuộc nhóm.'
cat /etc/group

echo '5. Tạo một thư mục có tên "LinuxTuan02" ngoài Desktop. Tạo một tập tin “test1.txt” có nội dung "Buổi thực hành Linux Tuần 02" và cấp phát quyền truy cập cho tệp tin như sau: Người sở hữu có quyền đọc, ghi, thực thi; Nhóm người sở hữu có quyền đọc ghi; Nhóm người dùng khác chỉ có quyền đọc. Sử dụng hai cách phân quyền là dùng ký tự và dùng số bát phân.'
cd ~/Desktop && mkdir LinuxTuan02 && cd LinuxTuan02 && echo 'Buổi thực hành Linux Tuần 02' > test1.txt
chmod u+x,g+w test1.txt 
hoặc chmod 764 test1.txt

echo '6. Thay đổi quyền sở hữu tệp tin “test1.txt” và nhóm người sử dụng tệp tin “test1.txt” là  “user1”.'
sudo chown user1:user1 test1.txt 