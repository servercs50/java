public class Main{

    public static void main(String[] args) {

//1.4
        System.out.println("Starting project");
//2.1
        int a = 789;
        byte b = 23;
        short c = 34;
        char d = 'f';
        long e = 300000000;
        float f = 0.23f;
        double g = 34.532673656;
        boolean h = true;
//2.2
        System.out.println("This is a int: " + a);
        System.out.println("This is a byte: " + b);
        System.out.println("This is a short: " + c);
        System.out.println("This is a char: " + d);
        System.out.println("This is a long: " + e);
        System.out.println("This is a float: " + f);
        System.out.println("This is a double: " + g);
        System.out.println("This is a boolean: " + h);
//2.3
        byte v_byte = 120;
        short v_short = 129;
        char v_char = 'a';
        int v_int = 65999;
        long v_long = 4294967296L;
        float v_float = 0.33333334f;
        double v_double = 0.3333333333333333;
        boolean v_double1 = true;
        System.out.println("This is a byte: " + v_byte);
        System.out.println("This is a short: " + v_short);
        System.out.println("This is a char: " + v_char);
        System.out.println("This is a int: " + v_int);
        System.out.println("This is a long: " + v_long);
        System.out.println("This is a float: " + v_float);
        System.out.println("This is a double: " + v_double);
        System.out.println("This is a boolean: " + v_double1);
//3.1
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.println(i);
        }
//3.2
        long begin = new java.util.Date().getTime();
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        long end = new java.util.Date().getTime();
        end -= begin;
        System.out.println(end);
//5.1
        int[] mas = {12, 43, 12, -65, 778, 123, 32, 76};
        int max = -32000;
        for (int i = 0; i < 8; i++) {
            if (mas[i] > max) max = mas[i];
        }
        System.out.println(max);
//5.2
        int[][] matrix = new int[3][3];
        for(int i=0; i< matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int)Math.round(Math.random() * 10);
            }
        }
        for(int i=0; i<matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for(int j=0; j<matrix.length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}