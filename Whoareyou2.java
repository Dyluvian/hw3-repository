package whoareyou2;

import java.util.Scanner;

// @author DTG

public class Whoareyou2 {
    public static void main(String[] args) {
        Scanner askUserName = new Scanner(System.in);
        System.out.println("What is your name?"); //ask name
        String name = askUserName.nextLine(); //define user feedback
        System.out.println("Oh, that is a very nice name, " + name);  //output text plus user feedback
    }
}
