tinh_tich(){
	for ((i=1;i<=10;i++))
	do
		tich=$(($1*i))
		echo $1"x"$i "=" $tich
	done
}
tinh_tich $1
