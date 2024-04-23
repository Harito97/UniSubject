for ((i=0;i<8;i++))
do
	for ((j=0;j<8;j++))
	do
		tong=$((i+j))
		if [ $((tong%2)) -eq 0 ]
		then
			echo -ne `echo -e "\033[47m _ \033[m"`
		else
			echo -ne `echo -e "\033[30m _ \033[m"`
		fi
	done
	echo ""
done
