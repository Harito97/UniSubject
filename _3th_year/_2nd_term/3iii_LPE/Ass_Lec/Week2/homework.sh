echo 'Cau 1'
ls -a /etc

echo 'Cau 2'
cd ~/Desktop && mkdir LINUX Ontap Ontap/LyThuyet Ontap/BaiTap

echo 'Cau 3'
mv Ontap/BaiTap LINUX

echo 'Cau 4'
cd Ontap/LyThuyet && echo 'Ôn tập các thao tác trên tệp tin và thư mục' > lythuyet01.txt && echo 'thực hành các bài tập về lập trình shell' > lythuyet02.txt

echo 'Cau 5'
cat lythuyet01.txt lythuyet02.txt > tonghop.txt

echo 'Cau 6'
mv tonghop.txt ../../LINUX/BaiTap

echo 'Cau 7'
ls -l ../../LINUX/BaiTap/tonghop.txt
chmod 777 ../../LINUX/BaiTap/tonghop.txt

echo 'Cau 8'
cd ../../ && mv Ontap OntapLinux

echo 'Cau 9'
rm -r OntapLinux/LyThuyet

echo 'Cau 10'
cd 

echo 'Cau 11'
ls /tmp *[[:upper:]]* -a

echo 'Cau 12'
ls /tmp *[[:digit:]]* -a

echo 'Cau 13'
ls /etc a*a*

echo 'Cau 14'
cd ~/Desktop/OntapLinux/BaiTap
touch file_{1..8}.txt

echo 'Cau 15'
rm file_{1..8}.txt
rm file*
rm *[[:digit:]]*
