echo 'Bai 1'
echo '1. Tim cac so tu nhien'
grep -Eo '\b^[0-9]+\b' data/dataset.txt 

echo '2. Tim cac so tu nhien chia het cho 5'
grep -Eo '\b(^[0-9]*[05]$)\b' data/dataset.txt

echo '3. Tim cac so nhi phan do dai 6 va chia het cho 4'
echo 'Note: end = 00 or 100'
grep -Eo '\b[01]{4}[0]{2}\b' data/dataset.txt

echo '4. Tap cac dong bat dau = "T" va chua it nhat 2 xau "This is an exercise"'
grep -E '^T' data/dataset.txt | grep -E '(This is an exercise).*\1'

echo 'Bai 2'
mkdir output
echo '1.'
ls /etc | grep -E '.*a.*a.*' > output/output1.txt
cat output/output1.txt

echo '2.'
ls /etc | grep -E '^b[^c]*$' > output/output2.txt
cat output/output2.txt

echo '3.'
grep -Ei '^jiayant' data/name_list.txt > output/out_jiayant.txt
cat output/out_jiayant.txt

echo '4.'
grep -E '^(024-)[0-9]*' data/phone_list.txt > output/out_phonehanoi.txt
cat output/out_phonehanoi.txt

echo '5.'
grep -Eo '\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,}\b' data/data_list.txt > output/mail_list.txt
cat output/mail_list.txt