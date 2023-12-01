package whoareyou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// @author DTG

public class WhoAreYou {
    public static void main(String[] args) throws IOException {
        System.out.println("What is your name?"); //ask name
        BufferedReader askUserName = new BufferedReader(new InputStreamReader(System.in)); //set up reader
        String name = askUserName.readLine(); //define user feedback
        System.out.print("Oh, that is a very nice name, " + name); //output text plus user feedback
    }
}