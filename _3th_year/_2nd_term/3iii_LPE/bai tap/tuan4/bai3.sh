gio=`date +%H`
if [ $gio -ge 5 -a $gio -lt 12 ]
then echo "Chao buoi sang"
elif [ $gio -gt 12 -a $gio -lt 18 ]
then echo "Chao buoi chieu"
else echo "Chao buoi toi"
fi
