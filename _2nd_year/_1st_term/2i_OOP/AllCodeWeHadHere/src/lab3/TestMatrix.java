package lab3;

public class TestMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = null;
        int[][] matrix2 = null;
        System.out.println("Here is the (int) matrix A: ");
        Matrix.print(matrix1);
        System.out.println("Here is the (int) matrix B: ");
        Matrix.print(matrix2);

//        int rows = 5;
//        int cols = 5;
//        int[][] matrix1 = new int[rows][cols];
//        Matrix.createRandomIntMatrix(matrix1);
//        System.out.println("Here is the (int) matrix A: ");
//        Matrix.print(matrix1);
//
//        int[][] matrix2 = Matrix.createRandomIntMatrix(5,5);
//        System.out.println("Here is the (int) matrix B: ");
//        Matrix.print(matrix2);

        //Method add(int[][], int[][])
        System.out.println("Here is the A + B: ");
        if (matrix1 == null || matrix2 == null){
            System.out.println("That matrix can't exist.");
        } else if (Matrix.haveSameDimension(matrix1, matrix2)){
            int[][] result = Matrix.add(matrix1, matrix2);
            Matrix.print(result);
        } else {
            System.out.println("That matrix can't exist.");
        }

        //Method subtract(int[][], int[][])
        System.out.println("Here is the A - B: ");
        if (matrix1 == null || matrix2 == null){
            System.out.println("That matrix can't exist.");
        } else if (Matrix.haveSameDimension(matrix1, matrix2)){
            int[][] result = Matrix.subtract(matrix1, matrix2);
            Matrix.print(result);
        } else {
            System.out.println("That matrix can't exist.");
        }

        //Method multiply(int[][], int[][])
        System.out.println("Here is the A * B: ");
        if (matrix1 == null || matrix2 == null){
            System.out.println("That matrix can't exist.");
        } else if (matrix1[0].length == matrix2.length){      //colMatrix1 = rowMatrix2 (n = n)
            int[][] result = Matrix.multiply(matrix1, matrix2);
            Matrix.print(result);
        } else {
            System.out.println("That matrix can't exist.");
        }


//        double[][] matrix3 = null;
//        double[][] matrix4 = null;
//        System.out.println("Here is the (int) matrix A: ");
//        Matrix.print(matrix3);
//        System.out.println("Here is the (int) matrix B: ");
//        Matrix.print(matrix4);

        int rows = 5;
        int cols = 5;
        double[][] matrix3 = new double[rows][cols];
        Matrix.createRandomDoubleMatrix(matrix3);
        System.out.println("Here is the (double) matrix C: ");
        Matrix.print(matrix3);

        double[][] matrix4 = Matrix.createRandomDoubleMatrix(5,5);
        System.out.println("Here is the (double) matrix D: ");
        Matrix.print(matrix4);

        //Method add(double[][], double[][])
        System.out.println("Here is the C + D: ");
        if (matrix3 == null || matrix4 == null){
            System.out.println("That matrix can't exist.");
        } else if (Matrix.haveSameDimension(matrix3, matrix4)){
            double[][] result = Matrix.add(matrix3, matrix4);
            Matrix.print(result);
        } else {
            System.out.println("That matrix can't exist.");
        }

        //Method subtract(double[][], double[][])
        System.out.println("Here is the C - D: ");
        if (matrix3 == null || matrix4 == null){
            System.out.println("That matrix can't exist.");
        } else if (Matrix.haveSameDimension(matrix3, matrix4)){
            double[][] result = Matrix.subtract(matrix3, matrix4);
            Matrix.print(result);
        } else {
            System.out.println("That matrix can't exist.");
        }

        //Method multiply(double[][], double[][])
        System.out.println("Here is the C * D: ");
        if (matrix3 == null || matrix4 == null){
            System.out.println("That matrix can't exist.");
        } else if (matrix3[0].length == matrix4.length){      //colMatrix1 = rowMatrix2 (n = n)
            double[][] result = Matrix.multiply(matrix3, matrix4);
            Matrix.print(result);
        } else {
            System.out.println("That matrix can't exist.");
        }
    }
}
