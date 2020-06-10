import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        double pressure = scanner.nextDouble();
        double height = scanner.nextDouble();
        System.out.print(pressure * height * 9.8);
    }
}