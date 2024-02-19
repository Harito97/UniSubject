echo '1. Hiển thị thư mục hiện tại của bạn' 
pwd 

echo '2. Chuyển đến thư mục người dùng' 
cd && pwd

echo '3. Tạo thư mục Linux trong thư mục người dùng' 
mkdir Linux

echo '4. Tạo 2 thư mục con trong đó là: Work & Play. Trong Work tạo thư mục Dir1, Dir2'
cd Linux && mkdir Work Play && cd Work && mkdir Dir1 Dir2

echo '5. Chuyển thư mục Play đến thư mục Desktop của người dùng' 
cd .. && mv Play ~/Desktop && ls ~/Desktop 

echo '6. Xóa thư mục Play' 
rm -r ~/Desktop/Play 

echo '7. Trong thư mục Work/Dir1, tạo hai tệp tin: file1.txt và file2.txt có nội dung lần lượt là: "Xin chao" và "cac ban sinh vien!". Thêm nội dung "Hom nay la buoi hoc thuc hanh dau tien mon Linux" cho tệp tin file1.txt'
cd ~/Linux/Work/Dir1
echo Xin chao > file1.txt
echo cac ban sinh vien! > file2.txt
echo Hom nay la buoi hoc thuc hanh dau tien mon Linux >> file1.txt

echo '8. Hiển thị nội dung từng tệp tin vừa tạo'
cat file1.txt
cat file2.txt

echo '9. Sao chép nội dung của hai tệp tin này vào một tệp tin mới là file3.txt'
cat file1.txt file2.txt > file3.txt

echo '10. Chuyển tệp tin file3.txt này về thư mục Dir2'
mv file3.txt ../Dir2

echo '11. Tạo liên kết cứng cho tệp tin file3.txt với tên là file4.txt. Sau đó xóa đi file3.txt và hiển thị nội dung của file4.txt?'
cd ../Dir2
ln file3.txt file4.txt
rm file3.txt && cat file4.txt

echo '12. Tạo liên kết mềm cho tệp tin file4.txt với tên là file5.txt. Sau đó xóa đi file4.txt và hiển thị nội dung của file5.txt?'
ln -s file4.txt file5.txt
rm file4.txt && cat file5.txt
