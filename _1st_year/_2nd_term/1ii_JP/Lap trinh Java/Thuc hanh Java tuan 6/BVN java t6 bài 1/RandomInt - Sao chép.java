/*************************************************
 * 
 *  Thực thi: java RandomInt N k
 *  
 *  In k số nguyên giả ngẫu nhiên từ 0 đến N-1.
 * @version 1.0
 *
 **************************************************/
public class RandomInt { 

	/**
	* In một số số nguyên giả ngẫu nhiên trong một khoảng thời gian nhất định
	* @param args[0] xác định khoảng thời gian của mỗi số nguyên giả ngẫu nhiên
	* @param args[1] cung cấp số lượng các số nguyên giả ngẫu nhiên được tạo
	*/
    public static void main(String[] args) { 
        // một số nguyên dương
    	int k = Integer.parseInt(args[0]);
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		int va = 0;
		for (int i = 1; i <= k; i++){
			va = random();
			if (va == 0) count0++;
			if (va == 1) count1++;
			if (va == 2) count2++;
		}
		System.out.println("So lan xuat hien 0 la: " + count0);
		System.out.println("So lan xuat hien 1 la: " + count1);
		System.out.println("So lan xuat hien 2 la: " + count2);
	}

	
	/**
	* Một hàm trả về một số nguyên giả ngẫu nhiên
	* @param n giới hạn trên của số giả ngẫu nhiên được tạo
	* @return một số giả ngẫu nhiên nhỏ hơn @n
	*/
	public static int random(){
		// một thực giả ngẫu nhiên trong khoảng từ 0,0 đến 1,0
       	double r = Math.random(); 
		// Chuyển đổi kiểu rõ ràng (ép kiểu) từ double sang int.
        // trả ve một số nguyên giả ngẫu nhiên từ 0 đến n-1
		return (int) (r * 3);
		
		/* Chúng ta có thể chon viết trực tiếp :
			return (int) (Math.random() * n); */
	}

}	
