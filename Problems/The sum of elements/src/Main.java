import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scn = new Scanner(System.in);
        int number = 0;
        int result = 0;
        while (scn.hasNext()) {
            number = scn.nextInt();
            if (number == 0) {
                break;
            } else {
                result += number;
            }
        }
        System.out.print(result);
    }
}