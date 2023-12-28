/*************************************************
 * 
 *  Thực thi: java RandomInt N k
 *  
 *  In k số nguyên giả ngẫu nhiên từ 0 đến N-1.
 * @version 1.0
 *
 **************************************************/
public class RandomInt2D { 

	/**
	* In một số số nguyên giả ngẫu nhiên trong một khoảng thời gian nhất định
	* @param args[0] xác định khoảng thời gian của mỗi số nguyên giả ngẫu nhiên
	* @param args[1] cung cấp số lượng các số nguyên giả ngẫu nhiên được tạo
	*/
	public static double meanArray(int arrayargs[]) {
		//bai 1 dua ra gia tri trung binh cua cac phan tu mang
		double mean = 0.0;
		int sum = 0;
		for (int i = 0; i < arrayargs.length; i++){
			sum += arrayargs[i];
		}
		mean = sum / arrayargs.length;
		return mean;
	}

    public static void main(String[] args) { 
        // một số nguyên dương
		int n = Integer.parseInt(args[0]);
    	int k = Integer.parseInt(args[1]);
		int[][] count = new int[n][500];
		int va = 0;
		for (int j = 0; j < 500; j++){
			for (int i = 1; i <= k; i++){
				va = random(n);
				count[va][j]++;
			}
		}
		for (int a = 0; a < n; a++){
			System.out.println("So lan xuat hien " + a + " la: " + meanArray(count[a]) );
		}
	}

	
	/**
	* Một hàm trả về một số nguyên giả ngẫu nhiên
	* @param n giới hạn trên của số giả ngẫu nhiên được tạo
	* @return một số giả ngẫu nhiên nhỏ hơn @n
	*/
	public static int random(int n){
		// một thực giả ngẫu nhiên trong khoảng từ 0,0 đến 1,0
       	double r = Math.random(); 
		// Chuyển đổi kiểu rõ ràng (ép kiểu) từ double sang int.
        // trả ve một số nguyên giả ngẫu nhiên từ 0 đến n-1
		return (int) (r * n);
		
		/* Chúng ta có thể chon viết trực tiếp :
			return (int) (Math.random() * n); */
	}

}	
