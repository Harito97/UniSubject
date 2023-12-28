package lab2;

import java.util.Scanner;

public class ExercisesOnMethod {
    //This class includes 3 parts
    //Part 1: The methods from 2.3 to 2.10 (line 11 st to line 118 th)
    //Part 2: Main (line 120 th to line 211 st)
    //Part 3: main3 to main10 to test each method in Part 1 (line 213 rd to line 445 th)

    //PART1
    //Method print() 2.3
    public static void print(int[] array){
        int length = array.length;
        System.out.print("[" + array[0]);
        for (int idx = 1; idx < length; idx++){
            System.out.print(", " + array[idx]);
        }
        System.out.print("]");
    }
    public static void print(double[] array){
        int length = array.length;
        System.out.print("[" + (Math.round(array[0]*100.0) / 100.0) );
        for (int idx = 1; idx < length; idx++){
            System.out.print(", " + (Math.round(array[idx]*100.0) / 100.0));
        }
        System.out.print("]");
    }
    public static void print(float[] array){
        int length = array.length;
        System.out.print("[" + (Math.round(array[0]*100.0) / 100.0) );
        for (int idx = 1; idx < length; idx++){
            System.out.print(", " + (Math.round(array[idx]*100.0) / 100.0));
        }
        System.out.print("]");
    }

    //Method arrayToString() 2.4
    public static String arrayToString(int[] array){
        String output ="";
        for (int idx = 0; idx < array.length; idx++){
            output += (array[idx]);
        }
        return output;
    }

    //Method contains() 2.5
    public static boolean contains(int[] array, int key){
        for (int idx = 0; idx < array.length; idx++){
            if (array[idx] == key){
                return true;
            }
        }
        return false;
    }

    //Method search() 2.6
    public static int search(int[] array, int key){
        for (int idx = 0; idx < array.length; idx++){
            if (array[idx] == key){
                return idx;
            }
        }
        return -1;
    }

    //Method equals() 2.7
    public static boolean equals(int[] array1, int[] array2){
        if (array1.length != array2.length){
            return false;
        }
        for (int idx = 0; idx < array1.length; idx++){
            if (array1[idx] != array2[idx]){
                return false;
            }
        }
        return true;
    }

    //Method copyOf() 2.8
    public static int[] copyOf(int[] array){
        int[] newArray = new int[array.length];
        for (int idx = 0; idx < array.length; idx++){
            newArray[idx] = array[idx];
        }
        return newArray;
    }
    public static int[] copyOf(int[] array, int newLength){
        int[] newArray = new int[newLength];
        for (int idx = 0; idx < newLength; idx++){
            newArray[idx] = array[idx];
        }
        return newArray;
    }

    //Method swap() 2.9
    public static boolean swap(int[] array1, int[] array2){
        if (array1.length != array2.length){
            return false;
        }
        int temp;
        for (int idx = 0; idx < array1.length; idx++){
            temp = array1[idx];
            array1[idx] = array2[idx];
            array2 [idx] = temp;
        }
        return true;
    }

    //Method reverse() 2.10
    public static void reverse(int[] array){
        int temp;
        for (int idx = 0; idx <= array.length / 2; idx++){
            temp = array[idx];
            array[idx] = array[array.length - idx - 1];
            array[array.length - idx -1] = temp;
        }
    }

    //PART2
    //Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Input 3 to test method print()" +
                "%nInput 4 to test method arrayToString()" +
                "%nInput 5 to test method contains()" +
                "%nInput 6 to test method search()" +
                "%nInput 7 to test method equals()" +
                "%nInput 8 to test method copyOf()" +
                "%nInput 9 to test method swap()" +
                "%nInput 10 to test method reverse()" +
                "%nInput -1 to end the program");
        System.out.printf("%nEnter a number from 3 to 10 (or -1 to end): ");
        int caseMain = Integer.parseInt(sc.next());
        boolean flagToTest = true;
        if ( !( (caseMain == -1) || (caseMain >= 3 && caseMain <= 10) ) ){
            flagToTest = false;
        }
        while (!flagToTest){
            flagToTest = true;
            System.out.print("%nEnter again a number from 3 to 10 (or -1 to end): ");
            caseMain = sc.nextInt();
            if ( !(caseMain == -1 || (caseMain >= 3 && caseMain <= 10)) ){
                flagToTest = false;
            }
        }

        //If caseMain = 0 and If caseMain != 0
        while (caseMain != -1){
            System.out.println();
            switch (caseMain){
                case 3:
                    System.out.println("You are testing the method print().");
                    main3(sc);
                    break;
                case 4:
                    System.out.println("You are testing the method arrayToString().");
                    main4(sc);
                    break;
                case 5:
                    System.out.println("You are testing the method contains().");
                    main5(sc);
                    break;
                case 6:
                    System.out.println("You are testing the method search().");
                    main6(sc);
                    break;
                case 7:
                    System.out.println("You are testing the method equals().");
                    main7(sc);
                    break;
                case 8:
                    System.out.println("You are testing the method copyOf().");
                    main8(sc);
                    break;
                case 9:
                    System.out.println("You are testing the method swap().");
                    main9(sc);
                    break;
                default:
                    System.out.println("You are testing the method reverse().");
                    main10(sc);
                    break;
            }
            System.out.println();
            System.out.printf("%nInput 3 to test method print()" +
                    "%nInput 4 to test method arrayToString()" +
                    "%nInput 5 to test method contains()" +
                    "%nInput 6 to test method search()" +
                    "%nInput 7 to test method equals()" +
                    "%nInput 8 to test method copyOf()" +
                    "%nInput 9 to test method swap()" +
                    "%nInput 10 to test method reverse()" +
                    "%nInput -1 to end the program");
            System.out.printf("%nEnter a number from 3 to 10 (or -1 to end): ");
            caseMain = Integer.parseInt(sc.next());
            flagToTest = true;
            if ( !( (caseMain == -1) || (caseMain >= 3 && caseMain <= 10) ) ){
                flagToTest = false;
            }
            while (!flagToTest){
                flagToTest = true;
                System.out.printf("%nEnter again a number from 3 to 10 (or -1 to end): ");
                caseMain = sc.nextInt();
                if ( !(caseMain == -1 || (caseMain >= 3 && caseMain <= 10)) ){
                    flagToTest = false;
                }
            }
        }
        sc.close();
    }

    //PART3
    //main3
    public static void main3(Scanner in){
        System.out.printf("%nEnter the size of the (int) array that you want - remember it have to >0: ");
        int size = Integer.parseInt(in.next());
        if (size > 0){
            int[] array = new int[size];
            System.out.printf("%nEnter " + size + " (int) number - remember is (int) number or program will error " +
                    "and we are so tired to write more code lines: ");
            for (int idx = 0; idx < size; idx++){
                array[idx] = Integer.parseInt(in.next());
            }
            System.out.printf("%nYour array here: ");
            print(array);
        } else {
            System.out.printf("%nPlease read carefully. Now let's read careful ok?");
        }

        System.out.printf("%nEnter the size of the (double) array that you want - remember it have to >0: ");
        size = Integer.parseInt(in.next());
        if (size > 0){
            double[] array = new double[size];
            System.out.printf("%nEnter " + size + " (double) number - remember is (double) number or program will error " +
                    "and we are so tired to write more code lines: ");
            for (int idx = 0; idx < size; idx++){
                array[idx] = Double.parseDouble(in.next());
            }
            System.out.printf("%nYour double array here: ");
            print(array);
        } else {
            System.out.printf("%nPlease read carefully. Now let's read careful ok?");
        }

        System.out.printf("%nEnter the size of the (float) array that you want - remember it have to >0: ");
        size = Integer.parseInt(in.next());
        if (size > 0){
            float[] array = new float[size];
            System.out.printf("%nEnter " + size + " (float) number - remember is (float) number or program will error " +
                    "and we are so tired to write more code lines: ");
            for (int idx = 0; idx < size; idx++){
                array[idx] = Float.parseFloat(in.next());
            }
            System.out.printf("%nYour float array here: ");
            print(array);
        } else {
            System.out.printf("%nPlease read carefully. Now, let's read careful ok?");
        }
    }

    public static void main4(Scanner in){
        System.out.printf("%nEnter the size of the (int) array that you want - remember it have to >0: ");
        int size = Integer.parseInt(in.next());
        if (size > 0){
            int[] array = new int[size];
            System.out.printf("%nEnter " + size + " (int) number - remember is (int) number or program will error " +
                    "and we are so tired to write more code lines: ");
            for (int idx = 0; idx < size; idx++){
                array[idx] = Integer.parseInt(in.next());
            }
            System.out.printf("%nArray to String here: ");
            System.out.print( arrayToString(array) );
        } else {
            System.out.printf("%nPlease read carefully. Now let's read careful ok?");
        }
    }

    public static void main5(Scanner in){
        System.out.printf("%nEnter the size of the (int) array that you want - remember it have to >0: ");
        int size = Integer.parseInt(in.next());
        if (size > 0){
            int[] array = new int[size];
            System.out.printf("%nEnter " + size + " (int) number - remember is (int) number or program will error " +
                    "and we are so tired to write more code lines: ");
            for (int idx = 0; idx < size; idx++){
                array[idx] = Integer.parseInt(in.next());
            }
            System.out.printf("%nEnter a number that you think is a item of array you inputted: ");
            int key = Integer.parseInt(in.next());
            if ( contains(array, key) ){
                System.out.printf("%nYesss. That's number is a item of array you inputted. ");
            } else {
                System.out.printf("%nNoooo. That's not a item of array you inputted. ");
            }
        } else {
            System.out.printf("%nPlease read carefully. Now let's read careful ok?");
        }
    }

    public static void main6(Scanner in){
        System.out.printf("%nEnter the size of the (int) array that you want - remember it have to >0: ");
        int size = Integer.parseInt(in.next());
        if (size > 0){
            int[] array = new int[size];
            System.out.printf("%nEnter " + size + " (int) number - remember is (int) number or program will error " +
                    "and we are so tired to write more code lines: ");
            for (int idx = 0; idx < size; idx++){
                array[idx] = Integer.parseInt(in.next());
            }
            System.out.printf("%nEnter a number that you want to know it's index in the array you inputted: ");
            int key = Integer.parseInt(in.next());
            if ( search(array, key) != -1){
                System.out.printf("%nIt's index is " + search(array, key));
            } else {
                System.out.printf("%nNoooo. That's not a item of array you inputted.");
            }
        } else {
            System.out.printf("%nPlease read carefully. Now let's read careful ok?");
        }
    }

    public static void main7(Scanner in){
        System.out.printf("%nEnter the size of the first (int) array that you want - remember it have to >0: ");
        int size = Integer.parseInt(in.next());
        if (size > 0){
            int[] array1 = new int[size];
            System.out.printf("%nEnter " + size + " (int) number - remember is (int) number or program will error " +
                    "and we are so tired to write more code lines: ");
            for (int idx = 0; idx < size; idx++){
                array1[idx] = Integer.parseInt(in.next());
            }
            System.out.printf("%nEnter the size of the second (int) array that you want - remember it have to >0: ");
            size = Integer.parseInt(in.next());
            if (size > 0) {
                int[] array2 = new int[size];
                System.out.printf("%nEnter " + size + " (int) number - remember is (int) number or program will error " +
                        "and we are so tired to write more code lines: ");
                for (int idx = 0; idx < size; idx++) {
                    array2[idx] = Integer.parseInt(in.next());
                }
                if ( (equals(array1, array2))){
                    System.out.printf("%nTwo array is the same.");
                } else {
                    System.out.printf("%nTwo array is not the same.");
                }
            } else {
                System.out.printf("%nPlease read carefully. Now let's read careful ok?");
            }
        } else {
            System.out.printf("%nPlease read carefully. Now let's read careful ok?");
        }
    }

    public static void main8(Scanner in){
        System.out.printf("%nEnter the size of the (int) array that you want - remember it have to >0: ");
        int size = Integer.parseInt(in.next());
        if (size > 0){
            int[] array = new int[size];
            System.out.printf("%nEnter " + size + " (int) number - remember is (int) number or program will error " +
                    "and we are so tired to write more code lines: ");
            for (int idx = 0; idx < size; idx++){
                array[idx] = Integer.parseInt(in.next());
            }
            System.out.printf("%nYour new array after copied the array you inputted here: ");
            int[] newArray = copyOf(array);
            print(newArray);

            System.out.printf("%n%nEnter the length of the (int) array " +
                    "that you want to have after copied the array you inputted - " +
                    "remember it have to >0: ");
            int newLength = Integer.parseInt(in.next());
            if (newLength > 0){
                System.out.printf("%nThe array you inputted here: ");
                print(array);
                System.out.printf("%nThe array you copied from array above with the length = " + newLength + " here: ");
                print( copyOf(array, newLength) );

            } else {
                System.out.printf("%nPlease read carefully. Now let's read careful ok?");
            }
        } else {
            System.out.printf("%nPlease read carefully. Now let's read careful ok?");
        }
    }

    public static void main9(Scanner in){
        System.out.printf("%nEnter the size of the first (int) array that you want - remember it have to >0: ");
        int size = Integer.parseInt(in.next());
        if (size > 0){
            int[] array1 = new int[size];
            System.out.printf("%nEnter " + size + " (int) number - remember is (int) number or program will error " +
                    "and we are so tired to write more code lines: ");
            for (int idx = 0; idx < size; idx++){
                array1[idx] = Integer.parseInt(in.next());
            }
            System.out.printf("%nEnter the size of the second (int) array that you want - remember it have to >0: ");
            size = Integer.parseInt(in.next());
            if (size > 0) {
                int[] array2 = new int[size];
                System.out.printf("%nEnter " + size + " (int) number - remember is (int) number or program will error " +
                        "and we are so tired to write more code lines: ");
                for (int idx = 0; idx < size; idx++) {
                    array2[idx] = Integer.parseInt(in.next());
                }
                System.out.printf("%nThe first array here: ");
                print(array1);
                System.out.printf("%nThe second array here: ");
                print(array2);

                if ( swap(array1, array2) ){
                    System.out.printf("%nWe just swap 2 array you inputted.");
                    System.out.printf("%nNow. The first array here: ");
                    print(array1);
                    System.out.printf("%nNow. The second array here: ");
                    print(array2);
                } else {
                    System.out.printf("%nTwo array above can't be swapped: ");
                }
            } else {
                System.out.printf("%nPlease read carefully. Now let's read careful ok?");
            }
        } else {
            System.out.printf("%nPlease read carefully. Now let's read careful ok?");
        }
    }

    public static void main10(Scanner in){
        System.out.printf("%nEnter the size of the (int) array that you want - remember it have to >0: ");
        int size = Integer.parseInt(in.next());
        if (size > 0){
            int[] array = new int[size];
            System.out.printf("%nEnter " + size + " (int) number - remember is (int) number or program will error " +
                    "and we are so tired to write more code lines: ");
            for (int idx = 0; idx < size; idx++){
                array[idx] = Integer.parseInt(in.next());
            }
            reverse(array);
            System.out.printf("%nYour array after reverse here: ");
            print(array);
        } else {
            System.out.printf("%nPlease read carefully. Now let's read careful ok?");
        }
    }
}