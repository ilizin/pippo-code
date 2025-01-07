package me.ilizin.coding.executor;

import java.util.InputMismatchException;
import java.util.Scanner;

import me.ilizin.coding.BinaryGap;

public class Executor {

    private static final String LN = System.lineSeparator();

    private static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    private static void runBinaryGap(Scanner scanner){
        BinaryGap binaryGap = new BinaryGap();
        System.out.println(LN + "Binary gap" + LN);
        System.out.print("Insert a natural number from the range [1..2147483647]: ");
        int longestBinaryGap = binaryGap.findTheLongestBinaryGap(scanner.nextInt());
        System.out.println("The longest binary gap is: " + longestBinaryGap + LN);
    }

    public static void main(String[] args) {
        String[] options = {
                "1- Binary gap",
                "4- Exit",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 4) {
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1 : {
                        runBinaryGap(scanner);
                        break;
                    }
                    default : {
                        System.out.println(LN + "An incorrect input was inserted. Please try again" + LN);
                        break;
                    }
                }
            }
            catch (InputMismatchException ex) {
                System.out.println(LN + "An incorrect input was inserted. Please try again" + LN);
                scanner.next();
            }
        }
    }
}
