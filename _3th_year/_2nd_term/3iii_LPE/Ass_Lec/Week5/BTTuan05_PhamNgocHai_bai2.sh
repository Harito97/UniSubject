echo 'Input a filename: '
read filename
if [ -e $filename ]
then cat $filename
else echo 'File ' $filename ' khong ton tai'
fi