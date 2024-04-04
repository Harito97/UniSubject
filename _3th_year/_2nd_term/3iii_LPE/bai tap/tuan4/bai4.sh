limit=2
start=1
while [ $start -lt $limit ]
do
 echo "===========MENU=========="
 echo "1.Xem dung luong su dung cua may tinh."
 echo "2.Xem noi dung thu muc hien hanh."
 echo "3.Xem cac tien trinh dang chay tren may tinh duoi dang cay."
 echo "4.Xem ten nguoi dung dang nhap he thong."
 echo "5.Thoát"
 echo "Moi nhap lua chon"
 read choose
 case $choose 
 in
 1) 
   free;;
 2) 
   for i in `ls`
   do echo $i", "
   done;;
 3) 
   pstree;;
 4) 
   whoami;;
 5) 
   break;;
 *)
   echo "Ban chon sai"
 esac
done
