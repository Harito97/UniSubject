package lab3;

public class Matrix {
    //Method signatures
    public static void createRandomIntMatrix(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int idxRows = 0; idxRows < rows; idxRows++){
            for (int idxCols = 0; idxCols < cols; idxCols++){
                matrix[idxRows][idxCols] = (int) (Math.random() * 100);
                //matrix[i][j] has value >= 0 && <= 100
            }
        }
    }

    public static int[][] createRandomIntMatrix(int rows, int cols){
        int[][] matrix = new int[rows][cols];
        for (int idxRows = 0; idxRows < rows; idxRows++){
            for (int idxCols = 0; idxCols < cols; idxCols++){
                matrix[idxRows][idxCols] = (int) (Math.random() * 100);
                //matrix[i][j] has value >= 0 && <= 100
            }
        }
        return matrix;
    }

    public static void createRandomDoubleMatrix(double[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int idxRows = 0; idxRows < rows; idxRows++){
            for (int idxCols = 0; idxCols < cols; idxCols++){
                matrix[idxRows][idxCols] = Math.random() * 100;
                //matrix[i][j] has value >= 0.0 && <= 100.0
            }
        }
    }

    public static double[][] createRandomDoubleMatrix(int rows, int cols){
        double[][] matrix = new double[rows][cols];
        for (int idxRows = 0; idxRows < rows; idxRows++){
            for (int idxCols = 0; idxCols < cols; idxCols++){
                matrix[idxRows][idxCols] = Math.random() * 100;
                //matrix[i][j] has value >= 0.0 && <= 100.0
            }
        }
        return matrix;
    }

    public static void print(int[][] matrix){
        if (matrix == null){
            System.out.println("That matrix can't exist.");
            return;
        } else if (matrix.length != 0 && matrix[0].length != 0){
            int rows = matrix.length;
            int cols = matrix[0].length;
            for (int idxRows = 0; idxRows < rows; idxRows++){
                for (int idxCols = 0; idxCols < cols; idxCols++){
                    System.out.printf("%6s", matrix[idxRows][idxCols]);
                }
                System.out.println();
            }
        } else {
            System.out.println("That matrix can't exist.");
        }
    }

    public static void print(double[][] matrix){
        if (matrix == null){
            System.out.println("That matrix can't exist.");
            return;
        } else if (matrix.length != 0 && matrix[0].length != 0){
            int rows = matrix.length;
            int cols = matrix[0].length;
            double temp;
            for (int idxRows = 0; idxRows < rows; idxRows++){
                for (int idxCols = 0; idxCols < cols; idxCols++){
                    temp = Math.round(matrix[idxRows][idxCols] * 100.0) / 100.0;
                    System.out.printf("%8s", temp);
                }
                System.out.println();
            }
        } else {
            System.out.println("That matrix can't exist.");
        }
    }

    //Used in add(), subtract()
    public static boolean haveSameDimension(int[][] matrix1,
                                            int[][] matrix2){
        if ( (matrix1.length != matrix2.length) ||
                (matrix1[0].length != matrix2[0].length) ){
            return false;
        }
        return true;
    }

    public static boolean haveSameDimension(double[][] matrix1,
                                            double[][] matrix2){
        if ( (matrix1.length != matrix2.length) ||
                (matrix1[0].length != matrix2[0].length) ){
            return false;
        }
        return true;
    }

    public static int[][] add(int[][] matrix1, int[][] matrix2){
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int idxRows = 0; idxRows < rows; idxRows++){
            for (int idxCols = 0; idxCols < cols; idxCols++){
                result[idxRows][idxCols] = matrix1[idxRows][idxCols] + matrix2[idxRows][idxCols];
            }
        }
        return result;
    }

    public static double[][] add(double[][] matrix1, double[][] matrix2){
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        double[][] result = new double[rows][cols];

        for (int idxRows = 0; idxRows < rows; idxRows++){
            for (int idxCols = 0; idxCols < cols; idxCols++){
                result[idxRows][idxCols] = matrix1[idxRows][idxCols] + matrix2[idxRows][idxCols];
            }
        }
        return result;
    }

    public static int[][] subtract(int[][] matrix1, int[][] matrix2){
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int idxRows = 0; idxRows < rows; idxRows++){
            for (int idxCols = 0; idxCols < cols; idxCols++){
                result[idxRows][idxCols] = matrix1[idxRows][idxCols] - matrix2[idxRows][idxCols];
            }
        }
        return result;
    }

    public static double[][] subtract(double[][] matrix1, double[][] matrix2){
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        double[][] result = new double[rows][cols];

        for (int idxRows = 0; idxRows < rows; idxRows++){
            for (int idxCols = 0; idxCols < cols; idxCols++){
                result[idxRows][idxCols] = matrix1[idxRows][idxCols] - matrix2[idxRows][idxCols];
            }
        }
        return result;
    }

    public static int[][] multiply(int[][] matrix1, int[][] matrix2){
        //A(mxn) * B(nxp) = C(mxp)
        int rowsResult = matrix1.length;           //here is m
        int colsResult = matrix2[0].length;        //here is p
        int n = matrix2.length;                    //here is n
        int[][] result = new int[rowsResult][colsResult];

        //Cij = Ai1B1j+Ai2B2j+…+AinBnj = ∑(k=1 -> n) AikBkj
        for (int idxRows = 0; idxRows < rowsResult; idxRows++){
            for (int idxCols = 0; idxCols < colsResult; idxCols++){
                for (int i = 0; i < n; i++){
                    result[idxRows][idxCols] = matrix1[idxRows][i] * matrix2[i][idxCols];
                }
            }
        }
        return result;
    }

    public static double[][] multiply(double[][] matrix1, double[][] matrix2){
        //A(mxn) * B(nxp) = C(mxp)
        int rowsResult = matrix1.length;           //here is m
        int colsResult = matrix2[0].length;        //here is p
        int n = matrix2.length;                    //here is n
        double[][] result = new double[rowsResult][colsResult];

        //Cij = Ai1B1j+Ai2B2j+…+AinBnj = ∑(k=1 -> n) AikBkj
        for (int idxRows = 0; idxRows < rowsResult; idxRows++){
            for (int idxCols = 0; idxCols < colsResult; idxCols++){
                for (int i = 0; i < n; i++){
                    result[idxRows][idxCols] = matrix1[idxRows][i] * matrix2[i][idxCols];
                }
            }
        }
        return result;
    }
}
