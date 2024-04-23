#!/bin/bash

# Hàm để tìm và in ra dòng dài nhất trong tệp
find_longest_line() {

    echo "Hãy nhập tên tệp:"
    read file_name

    longest_line=""
    max_length=0

    # Kiểm tra xem tệp tồn tại không
    if [ -f "$file_name" ] 
    then
    	    # Đọc từng dòng trong tệp và lưu dòng đó vào biến "line"
	    while read -r line
	    do	
	    	# Lấy ra chiều dài của dòng hiện tại
			length=${#line}
	
			# Nếu chiều dài dòng hiện tại lớn hơn max_length đang có thì cập nhật lại max_length
			if [ "$length" -gt "$max_length" ] 
			then
				max_length=$length
				longest_line="$line"
			fi
	    done < "$file_name"

	    # In ra dòng dài nhất
	    echo "Dòng dài nhất trong tệp $file_name là: "
	    echo "$longest_line"
    	
    else
        echo "Tệp $file_name không tồn tại"
    fi


}


find_longest_line 


#Lưu ý: Chương trình hiện tại chỉ có thể in được 1 dòng dài nhất. Bạn hãy thử phát triển thêm cho trường hợp file có nhiều dòng dài nhất và có thể in ra được tất cả dòng đó.
