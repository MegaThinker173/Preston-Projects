import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        int totalCount = 1;
        int userInputNumber = 0;

        Scanner inputScanner = new Scanner(System.in);
        int resultNumber = (int) (Math.random() * 999 + 1);

        while (true) {
            System.out.println(totalCount+"/5");
            System.out.print("Enter a number between 1 to 1000. You have 9 tries. \n");
            userInputNumber = inputScanner.nextInt();

            if (userInputNumber < 1 || userInputNumber > 1000) {
                System.out.println("Please enter a valid number.");
                continue;
            } else if (totalCount == 9) {
                System.out.println("Maximum number of attempts reached! Please try again. The correct number is: " + resultNumber);
                break;
            } else if (userInputNumber < resultNumber) {
                System.out.println("It is smaller than the result!");
            } else if (userInputNumber > resultNumber) {
                System.out.println("It is greater than the result!");
            } else {
                System.out.println("It is correct. You Won! It took you " + totalCount + "tries to get the correct answer.");
                break;
            }
            totalCount++;
        }
    }
}
