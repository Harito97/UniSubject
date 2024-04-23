sumArray(){
   for i in "${N[@]}"
   do
      sum=$((sum+i))
   done
   echo "Tong cac phan tu trong mang la $sum"
}

max(){
   max=${N[0]}
   for i in "${N[@]}"
   do
      if [ $i -ge $max ]
      then
         max=$i
      fi
   done
   echo "Phan tu lon nhat la $max"
}

min(){
   min=${N[0]}
   for i in "${N[@]}"
   do
      if [ $i -le $min ]
      then
         min=$i
      fi
   done
   echo "Phan tu nho nhat la $min"
}

isPrime(){
   if [ $1 -lt 2 ]
   then 
      return 1
   fi
   for ((i=2;i<$1;i++))
   do
      if [ $(($1%i)) -eq 0 ]
      then
         return 1
      fi
   done
   return 0
}

listPrime(){
   echo -n "Cac so nguyen to trong mang la "
   for j in "${N[@]}"
   do
      if isPrime $j
      then 
         echo -n "$j, "
      fi
   done
   echo " "
}

isSquare(){
   for ((i=1;i<$1;i++))
   do
      if [ $((i*i)) -eq $1 ]
      then 
         return 0
      fi
   done
   return 1
}

listSquare(){
   echo -n "Cac so chinh phuong trong mang la "
   for j in "${N[@]}"
   do
      if isSquare $j
      then 
         echo -n "$j, "
      fi
   done
   echo " "
}

echo -n "Hay nhap mot mang so nguyen: "
read -a N
sum=0
max=${N[0]}
min=${N[0]}
while [ 0 -eq 0 ]
do
   echo "---------------------------------------------"
   echo "   1. Tinh va in ra tong cac phan tu trong mang"
   echo "   2. Tim phan tu lon nhat va nho nhat trong mang"
   echo "   3. Tim va in ra tat ca so nguyen to trong mang"
   echo "   4. Tim va in ra tat ca cac so chinh phuong trong mang"
   echo "   5. Thoat"
   echo -n "Hay nhap lua chon cua ban: "
   read n
   case $n
   in
   1)
      sumArray;;
   2)
      max
      min;;
   3)
      listPrime;;
   4)
      listSquare;;
   5)
      break;;
   *)
      echo "Ban chon sai"
   esac
done

