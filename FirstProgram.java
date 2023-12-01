package firstprogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// @author DTG
 
public class FirstProgram {

    public static void main(String[] args) throws IOException {
        System.out.println("What is your name?");

        BufferedReader askUserName = new BufferedReader(new InputStreamReader(System.in));
        String name = askUserName.readLine();
        System.out.print("Oh, that is a very nice name, " + name);
    }

}
