factorial(){
	tich=1
	for ((i=1;i<=$1;i++))
	do
		tich=$((tich*i))
	done
	return $tich
}
sum_factorial(){
	tong=0
	for i in `seq 1 $1`
	do
		factorial $i
		tong=$((tong+$?))
	done
	return $tong
}
factorial $1
echo "S1 = $?"
sum_factorial $1
echo "S2 = $?" 
