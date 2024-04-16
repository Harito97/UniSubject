option1() {
	ls /etc/a*
}


option2() {
	date
}


menu() {
	# Tạo một vòng lặp luôn đúng để menu luôn hiện thị lại sau mỗi lựa chọn giúp người dùng có thể chọn tiếp các lựa chọn khác mà không phải chạy lại chương trình. Menu chỉ được dừng lại khi người dùng chọn THOÁT!
	while [ 1 -eq 1 ]
	do	
		echo "----------MENU----------"
		echo "1. Hiển thị thông tin của tất cả các thư mục hoặc tệp tin bắt đầu bởi chữ cái “a” trong thư mục /etc."
		echo "2. Hiển thị ngày và giờ của hệ thống"
		echo "Mô tả tương ứng cho các lựa chọn còn lại..."
		echo "0. Thoát Menu"
		echo "Hãy nhập lựa chọn của bạn: "
		read choice

		case $choice in
		
		    # Gọi hàm tương ứng để thực hiện lựa chọn 1
		    1)	option1
			;;
		    
		    # Gọi hàm tương ứng để thực hiện lựa chọn 2
		    2)	option2
			;;
		    3)
			echo "Gọi ra hàm tương ứng thực hiện lựa chọn..."
			;;
		    #Các bạn tự triển khai các lựa chọn còn thiếu
		    0)
			echo "Thoát khỏi chương trình!"
			exit
			;;
		esac
	done
}


# Gọi hàm menu
menu