package refactoredtaxcalculator;
import java.util.Scanner;

// @author DTG Dylan Geraghty

public class RefactoredTaxCalculator {

// Ask for income
    public static double getIncome() {
        Scanner askIncome = new Scanner(System.in);
        System.out.println("What is your income? Please insert a number.");
        while (!askIncome.hasNextDouble()) {
            System.out.println("That was not valid input. Please insert a number.");
            askIncome.next();
        }
        double incomeInput = askIncome.nextDouble();
        return (incomeInput);
    }

// USC calculation
    public static double calculateUSC(double income) {
        double usc = 0;
        if (income < 12012) {
            usc = income * 0.005;
        } else {
            usc += 12012 * 0.005;
            income -= 12012;
        }
        if (income < 10908) {
            usc += income * 0.02;
        } else {
            usc += 10908 * 0.02;
            income -= 10908;
            }
        if (income < 47198) {
            usc += income * 0.04;
        } else {
            usc += 47198 * 0.04;
            income -= 47198;
            usc += income * 0.08;
        }
        return (usc);
    }

// PRSI calculation
    public static double calculatePRSI(double income) {
        double prsi = income * 0.04;
        return (prsi);
    }

// PAYE calculation
    public static double calculatePAYE(double income) {
            double payeCutoff = 40000;
            double paye = 0;
            if (income > payeCutoff) {
                paye += payeCutoff * 0.2;
                paye += (income - payeCutoff) * 0.4;
            } else {
                paye = income * 0.2;
            }
        return (paye);
    }

// Main method. "Does not need to look exactly like this", but meh why not
    public static void main(String[] args) {
        double income = getIncome();
        double usc = calculateUSC(income);
        double prsi = calculatePRSI(income);
        double paye = calculatePAYE(income);

        double tax = usc + prsi + paye;
        System.out.println("Your tax is: " + tax);
    }
}