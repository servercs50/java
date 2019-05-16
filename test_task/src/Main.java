import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer MaxNum = scanner.nextInt();
        int amt = 0;
            for(int i =0; amt < MaxNum; i++){
                String StrNum = Integer.toString(i);
                if(i % StrNum.length() == 0) {
                    System.out.println(i);
                    amt += 1;
                }
            }
    }
}
