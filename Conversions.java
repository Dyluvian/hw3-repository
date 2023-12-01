package conversions;

import java.lang.Math;
import java.util.Scanner;

public class Conversions {
    public static void main(String[] args) {
        Scanner conversions = new Scanner(System.in);
        boolean repeat = true;
        do {
            try {
                System.out.println("Enter the number system to convert from (binary, decimal, octal, or hexadecimal).");
                String convertfrom = conversions.nextLine();
            // DECIMAL CONVERSIONS
                if (convertfrom.matches("(decimal|Decimal|dec|Dec|d|D)")) {
                    System.out.println("Decimal: enter a number to convert.");
                    int num1 = conversions.nextInt();
                    System.out.println("Now enter the system to convert to.");
                    conversions.nextLine();
                    String convertto = conversions.nextLine();
                    if (convertto.matches("(binary|Binary|bin|Bin|b|B)")) {
                        System.out.println("Decimal " + num1 + " in binary is " + Integer.toBinaryString(num1) + ". Press any key to restart.");
                    }
                    else if (convertto.matches("(octal|Octal|oct|Oct|o|O)")) {
                    System.out.println("Decimal " + num1 + " in octal is " + Integer.toOctalString(num1) + ". Press any key to restart.");
                    }
                    else if (convertto.matches("(hexadecimal|Hexadecimal|hex|Hex|h|H)")) {
                    System.out.println("Decimal " + num1 + " in hexadecimal is " + Integer.toHexString(num1) + ". Press any key to restart.");
                    }
                    else {
                    System.out.println("Catastrophe");
                    }
                }
            // BINARY CONVERSIONS
                else if (convertfrom.matches("(binary|Binary|bin|Bin|b|B)")) {
                    System.out.println("Binary: enter a number to convert.");
                    int num1 = conversions.nextInt();
                    System.out.println("Now enter the system to convert to.");
                    conversions.nextLine();
                    String convertto = conversions.nextLine();
                    if (convertto.matches("(decimal|Decimal|dec|Dec|d|D)")) {
                    System.out.println("Binary " + num1 + " in decimal is " + Integer.parseInt(String.valueOf(num1),2) + ". Press any key to restart.");
                    }
                    else if (convertto.matches("(octal|Octal|oct|Oct|o|O)")) {
                    System.out.println("Binary " + num1 + " in octal is " + Integer.toOctalString(Integer.parseInt(String.valueOf(num1),2)) + ". Press any key to restart.");
                    }
                    else if (convertto.matches("(hexadecimal|Hexadecimal|hex|Hex|h|H)")) {
                    System.out.println("Binary " + num1 + " in hexadecimal is " + Integer.toHexString(Integer.parseInt(String.valueOf(num1),2)) + ". Press any key to restart.");
                    }
                    else {
                    System.out.println("Catastrophe");
                    }
                }
            // OCTAL CONVERSIONS
                else if (convertfrom.matches("(octal|Octal|oct|Oct|o|O)")) {
                    System.out.println("Octal: enter a number to convert.");
                    int num1 = conversions.nextInt();
                    System.out.println("Now enter the system to convert to.");
                    conversions.nextLine();
                    String convertto = conversions.nextLine();
                    if (convertto.matches("(decimal|Decimal|dec|Dec|d|D)")) {
                    System.out.println("Octal " + num1 + " in decimal is " + Integer.parseInt(String.valueOf(num1),8) + ". Press any key to restart.");
                    }
                    else if (convertto.matches("(binary|Binary|bin|Bin|b|B)")) {
                    System.out.println("Octal " + num1 + " in binary is " + Integer.toBinaryString(Integer.parseInt(String.valueOf(num1),8)) + ". Press any key to restart.");
                    }
                    else if (convertto.matches("(hexadecimal|Hexadecimal|hex|Hex|h|H)")) {
                    System.out.println("Octal " + num1 + " in hexadecimal is " + Integer.toHexString(Integer.parseInt(String.valueOf(num1),8)) + ". Press any key to restart.");
                    }
                    else {
                    System.out.println("Catastrophe");
                    }
                }
            // HEXADECIMAL CONVERSIONS
                else if (convertfrom.matches("(hexadecimal|Hexadecimal|hex|Hex|h|H)")) {
                    System.out.println("Hexadecimal: enter a number to convert.");
                    String num1 = conversions.nextLine();
                    System.out.println("Now enter the system to convert to.");
                    String convertto = conversions.nextLine();
                    if (convertto.matches("(decimal|Decimal|dec|Dec|d|D)")) {
                    System.out.println("Hexadecimal " + num1 + " in decimal is " + Integer.parseInt(String.valueOf(num1),16) + ". Press any key to restart.");
                    }
                    else if (convertto.matches("(binary|Binary|bin|Bin|b|B)")) {
                    System.out.println("Hexadecimal " + num1 + " in binary is " + Integer.toBinaryString(Integer.parseInt(String.valueOf(num1),16)) + ". Press any key to restart.");
                    }
                    else if (convertto.matches("(octal|Octal|oct|Oct|o|O)")) {
                    System.out.println("Hexadecimal " + num1 + " in octal is " + Integer.toOctalString(Integer.parseInt(String.valueOf(num1),16)) + ". Press any key to restart.");
                    }
                    else {
                    System.out.println("Catastrophe");
                    }
                }
                conversions.nextLine();
                }
            catch (Exception e) {
                System.out.println("Forget about it.");
                }
            }
        while (repeat);
    }
}