hour=`date +%H`
if [ $hour -ge 0 -a $hour -lt 12 ]
then echo 'Chao buoi sang'
elif [ $hour -ge 12 -a $hour -lt 18 ]
then echo 'Chao buoi chieu'
else echo 'Chao buoi toi'
fi