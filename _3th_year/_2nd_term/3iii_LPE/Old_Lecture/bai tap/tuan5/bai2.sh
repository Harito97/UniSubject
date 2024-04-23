tinhtong(){
	sum=0
	for ((i=1;i<=$1;i++))
	do
		sum=$((sum+i))
	done
	return $sum
}
tongchan(){
	sum=0
	for ((i=1;i<$1;i++))
	do
		du=$((i%2))
		if [ $du -eq 0 ]
		then 
			sum=$((sum+i))
		fi
	done
	return $sum
}
tongle(){
	sum=0
	for ((i=1;i<$1;i++))
	do
		du=$((i%2))
		if [ $du -ne 0 ]
		then 
			sum=$((sum+i))
		fi
	done
	return $sum
}
tinhtong $1
echo "Tong S la " $?
tongchan $1
echo "Tong cac so chan nho hon n la " $?
tongle $1
echo "Tong cac so le nho hon n la " $?
