package tradestxttocsv;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

// @author DTG Dylan Geraghty

public class TradesTxtToCsv {
    public static void main(String[] args) {

// Try-catch general exception #1
        try {

// Readme
            System.out.println("A thousand welcomes.\nThis code processes valid trades text data to csv format, unless I'm painfully mistaken.\nFor successful output, please insert a text file at C:\\Users\\celeb\\Desktop\\POOA\\trades.txt in a format following the example \"EURUSD123-5O\".\n---\nThe format specifically requires, in order:\n1. a 3-letter currency\n2. a second discrete 3-letter currency\n3. a number representing the price of trade\n4. a hyphen\n5. another number representing the amount traded\n6. ...and an \"R\" or an \"O\" to denote a reversed trade.\n---\nShould you fail to meet these demands, cheap error messages await.\nCode has been set up to support (append) multiple lines based on the instruction \"each row should be a trade\". Apologies if this is overkill.\nMuch obliged for your patience.\nHave a great one.\n---");

// Read in text file
            Scanner readTradesTxt = new Scanner(new FileReader("C:\\Users\\celeb\\Desktop\\POOA\\trades.txt")); // What does celeb stand for?
//          Scanner readTradesTxt = new Scanner(new FileReader("C:\\Users\\User\\Desktop\\trades.txt")); // For non-celebrity self testing

// Define the correct format
            Pattern correctformat = Pattern.compile("[a-zA-Z]{6}[0-9]+\\.?[0-9]*[-]{1}[0-9]+\\.?[0-9]*[o,O,r,R]{1}");

// If empty
            if (!readTradesTxt.hasNext()) {
                System.out.println("Input: nothing. No output. This file is empty.\nNothing in, nothing out.");
                System.exit(0);
            }

// Otherwise, start loop
            while (readTradesTxt.hasNextLine()) {

// Parse to string
                String tradescurrentline = readTradesTxt.nextLine();
                Matcher correctformatmatcher = correctformat.matcher(tradescurrentline);
                boolean correct = correctformatmatcher.matches();

// Error handling
                if (tradescurrentline.isEmpty()) {
                    System.out.println("Input: nothing. No output. This line is blank. Please insert some input.");
                    continue;
                }
                else if (!tradescurrentline.matches("[a-zA-Z0-9\\-\\.]+")) {
                    System.out.println("Input: \"" + tradescurrentline + "\". No output. Input must consist of only letters, numbers, and hyphens. Please replace any extraneous characters on this line.");
                    continue;
                }
                else if (!tradescurrentline.matches("[a-zA-Z]{6}.*")) {
                    System.out.println("Input: \"" + tradescurrentline + "\". No output. Both currencies must consist of three letters each. Please replace any other input at the start of the line.");
                    continue;
                }
                else if (!tradescurrentline.matches("[a-zA-Z]{6}[0-9]+\\.?[0-9]*.*")) {
                    System.out.println("Input: \"" + tradescurrentline + "\". No output. The price of trade must be a number. Please input a number after the currencies (first six letters).");
                    continue;
                }
                else if (!tradescurrentline.matches("[a-zA-Z]{6}[0-9]+\\.?[0-9]*[-].*")) {
                    System.out.println("Input: \"" + tradescurrentline + "\". No output. There is no hyphen in the correct position. Please input a hyphen after the price of trade.");
                    continue;
                }
                else if (!tradescurrentline.matches("[a-zA-Z]{6}[0-9]+\\.?[0-9]*[-][0-9]+\\.?[0-9]*.*")) {
                    System.out.println("Input: \"" + tradescurrentline + "\". No output. The amount traded must be a number. Please input a number after the initial hyphen.");
                    continue;
                }
                else if (!tradescurrentline.matches("[a-zA-Z]{6}[0-9]+\\.?[0-9]*[-][0-9]+\\.?[0-9]*[o,O,r,R]{1}")) {
                    System.out.println("Input: \"" + tradescurrentline + "\". No output. The final character of each line must be either a single \"R\" (denoting a reversed trade) or a single \"O\". Please input either letter after the amount traded.");
                    continue;
                }
                else if (correct == false) {
                    System.out.println("Input: \"" + tradescurrentline + "\". No output. The input is not correctly formatted.");
                    continue;
                }

// Define each comma-separated value
                String originatingcurrency = tradescurrentline.substring(0, 3); // originating currency = first 3 characters
                String destinationcurrency = tradescurrentline.substring(3, 6); // destination currency = next 3 characters
                String priceoftrade = tradescurrentline.substring(6, tradescurrentline.indexOf('-')); // price of trade = next characters before hyphen
                String amounttraded = tradescurrentline.substring(tradescurrentline.indexOf('-') + 1, tradescurrentline.length() - 1); // amount traded = next characters before final character
                String reverseddenotation = tradescurrentline.substring(tradescurrentline.length() - 1); // reversed denotation = final character

// Fix any lowercase
                String originatingcurrencyfinal = originatingcurrency.toUpperCase();
                String destinationcurrencyfinal = destinationcurrency.toUpperCase();
                String reverseddenotationfinal = reverseddenotation.toUpperCase();

// Define output
                String tradescsvprint = (originatingcurrencyfinal + "," + destinationcurrencyfinal + "," + priceoftrade + "," + amounttraded + "," + reverseddenotationfinal);
                String tradescsvoutput = (tradescsvprint + "\n");

// More granular errors
                if (originatingcurrency.equalsIgnoreCase(destinationcurrency)) {
                    System.out.println("Input: \"" + tradescurrentline + "\". No output. The originating and destination currencies cannot be the same. Please input two different currencies in this position.");
                }
                else if (priceoftrade.startsWith(".") || priceoftrade.endsWith(".")) {
                    System.out.println("Input: \"" + tradescurrentline + "\". No output. While decimals are supported, a decimal point must neither begin nor close a number. Please correct the number.");
                }
                else if (amounttraded.startsWith(".") || amounttraded.endsWith(".")) {
                    System.out.println("Input: \"" + tradescurrentline + "\". No output. While decimals are supported, a decimal point must neither begin nor close a number. Please correct the number.");
                }
                else if (amounttraded.startsWith(".") || amounttraded.endsWith(".")) {
                    System.out.println("Input: \"" + tradescurrentline + "\". No output. While decimals are supported, a decimal point must neither begin nor close a number. Please correct the number.");
                }

// Otherwise, write values to csv file and repeat
                else {
                    FileWriter writeTradesCsv = new FileWriter("C:\\Users\\celeb\\Desktop\\POOA\\trades.csv", true); // For celebs
//                  FileWriter writeTradesCsv = new FileWriter("C:\\Users\\User\\Desktop\\trades.csv", true); // For testing
                    writeTradesCsv.write(tradescsvoutput);
                    writeTradesCsv.close();
                    System.out.println("Input: \"" + tradescurrentline + "\". Output: \"" + tradescsvprint + "\". Processing next line.");
                    }
                }

// Closure
                readTradesTxt.close();
                System.out.println("---\nAll valid lines have been appended to trades.csv.\nHave a wonderful day.");
            }

// Try-catch general exception #2
        catch (Exception e) {
            System.out.println("A general error has occurred. Please ensure a valid text file was provided.");
        }
    }
}