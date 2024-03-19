max=0
while IFS= read -r line
do 
	n=`echo $line | wc -c`
	if [ $n -ge $max ]
	then 
		count=$n
		dong="$line"
	fi
done < $1
echo $dong
