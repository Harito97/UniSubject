sum(){
	tong=0
	for item in $*
	do
		tong=$((tong+$item))
	done
	return $tong
}
sum $*
echo $?
