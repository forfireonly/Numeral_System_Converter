import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scn = new Scanner(System.in);
        int lengthOfArray = scn.nextInt();
        int[] array = new int[lengthOfArray];
        for (int i = 0; i < lengthOfArray; i++) {
            array[i] = scn.nextInt();
        }
        int longestSequence = 1;
        int counterForSequence = 1;
        for (int i = 0; i < lengthOfArray - 1; i++) {
            if (array[i] < array[i + 1]) {
                counterForSequence++;
            } else {
                counterForSequence = 1;
            }
            if (counterForSequence > longestSequence) {
                longestSequence = counterForSequence;
            }
        }
        System.out.print(longestSequence);
    }
}