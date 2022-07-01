package ua.test.taskOne;

import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfExpressions = 0;

        System.out.println("Please, enter number of brackets: ");

        if (scanner.hasNextInt()) {
            int numberOfEachBracket = scanner.nextInt();
            if (numberOfEachBracket < 0) {
                System.out.println("Number of brackets must be more than 0.");
            } else if (numberOfEachBracket == 0) {
                System.out.println("Number of expressions - 0");
            } else {
                numberOfExpressions = calculateNumberOfExpressions(numberOfEachBracket);
                System.out.println("Number of expressions - " + numberOfExpressions);
            }
        } else {
            System.out.println("You entered not number");
        }
    }

    /*
    Our sequence is Catalan number, so we can calculate number of expressions by formula -
    C(n) = Sum(from i = 0 to (n - 1)) C(i) * C(n - 1 - i) for n >= 0;
     */
    private static int calculateNumberOfExpressions(int numberOfEachBracket) {
        int numberOfExpressions = 0;
        if (numberOfEachBracket == 0) {
            return 1;
        }
        for (int i = 0; i < numberOfEachBracket; i++) {
            numberOfExpressions += calculateNumberOfExpressions(i) * calculateNumberOfExpressions((numberOfEachBracket - 1) - i);
        }
        return numberOfExpressions;
    }
}
