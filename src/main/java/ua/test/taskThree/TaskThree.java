package ua.test.taskThree;

import java.math.BigInteger;

public class TaskThree {
    public static void main(String[] args) {

        BigInteger sumDigits = getSumDigits(getFactorial(100));
        System.out.println("Sum of digits is - " + sumDigits);

    }

    public static BigInteger getFactorial(int numberToCalculate) {      // method for calculate factorial of number
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= numberToCalculate; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    public static BigInteger getSumDigits(BigInteger factorial) {       // method for calculate sum of digits
        BigInteger sumDigits = BigInteger.ZERO;
        while (!factorial.equals(BigInteger.ZERO)) {
            sumDigits = sumDigits.add((factorial.mod(BigInteger.valueOf(10))));
            factorial = factorial.divide(BigInteger.valueOf(10));
        }
        return sumDigits;
    }
}
