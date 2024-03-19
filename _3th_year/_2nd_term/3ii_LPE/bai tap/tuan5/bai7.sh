count(){
	dem=0
	for item in `ls $1`
	do
		dem=$((dem+1))
	done
	return $dem
}
count $1
echo $?
