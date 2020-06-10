import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int distance = scanner.nextInt();
        int time = scanner.nextInt();
        System.out.print((double) distance / time );
    }
}