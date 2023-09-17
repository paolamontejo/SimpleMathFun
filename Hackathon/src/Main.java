import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random rndGen = new Random();
        Scanner scn = new Scanner(System.in);
        boolean valid = false;
        String operation = "";
        while (!valid) {
            try {
                System.out.println("Hello, Learner! Please type 'add', 'subtract', 'multiply', or 'divide' " +
                        "to practice the skill.");
                operation = scn.nextLine();
                if (!operation.equalsIgnoreCase("add") &&
                        !operation.equalsIgnoreCase("subtract") &&
                        !operation.equalsIgnoreCase("multiply") &&
                        !operation.equalsIgnoreCase("divide")) {
                    throw new Exception();
                }
                valid = true;
            } catch (Exception e) {
                System.out.println("Invalid Operation! Try again.");
            }
        }

        BigDecimal bg = new BigDecimal(rndGen.nextDouble(-100, 101));
        bg = bg.setScale(2, BigDecimal.ROUND_HALF_UP);
        double num1 = bg.doubleValue();

        BigDecimal bg2 = new BigDecimal(rndGen.nextDouble(-100, 101));
        bg2 = bg2.setScale(2, BigDecimal.ROUND_HALF_UP);
        double num2 = bg2.doubleValue();

        double correctAnswer = 0;

        if (operation.equalsIgnoreCase("Add")) {
            System.out.println(num1 + " + " + num2 + ":");
            correctAnswer = Addition.add(num1, num2);
        } else if (operation.equalsIgnoreCase("Subtract")) {
            System.out.printf(num1 + " - " + num2 + ":");
            correctAnswer = Subtraction.subtract(num1, num2);
        } else if (operation.equalsIgnoreCase("Multiply")) {
            System.out.printf(num1 + " * " + num2 + ":");
            correctAnswer = Multiplication.multiply(num1, num2);
        } else if (operation.equalsIgnoreCase("Divide")) {
            System.out.printf(num1 + " / " + num2 + ": \n(Round to the nearest hundredth)");
            correctAnswer = Division.divide(num1, num2);
        }

        boolean answerFound = false;
        double userAnswer = 0.0;
        while (!answerFound) {
            System.out.println("\nPlease input the answer:");
            try {
                userAnswer = scn.nextDouble();
                if (userAnswer == correctAnswer) {
                    System.out.println("You are correct!");
                    answerFound = true;
                } else {
                    System.out.println("Incorrect answer! Please try again");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please only enter digits!");
                scn.nextLine();
            }
        }
        scn.nextLine();

        System.out.println("Do you want to keep practicing? (Y/N)");
        String userResponse = scn.nextLine();
        if (userResponse.toUpperCase().charAt(0) == 'Y'){
            main(args);
        }
        else{
            System.out.println("Good work!");
        }
    }

}