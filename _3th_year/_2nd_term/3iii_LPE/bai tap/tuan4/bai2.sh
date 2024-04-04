echo "Nhap ten file: "
read name
if [ -s $name ]
then cat $name
else echo "File "$name" khong ton tai"
fi
