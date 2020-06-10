import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        System.out.print(Math.abs(scanner.nextInt() * 60 * 60 + scanner.nextInt() * 60 + scanner.nextInt() -
                (scanner.nextInt() * 60 * 60 + scanner.nextInt() * 60 + scanner.nextInt())));
    }
}