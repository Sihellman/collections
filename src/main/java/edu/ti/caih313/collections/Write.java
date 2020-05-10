package edu.ti.caih313.collections;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Write {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter file name");
        String fileName = keyboard.next();
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(fileName);

            System.out.println("enter text, and press enter, -1 when finished");
            boolean boo = false;
            while (!boo) {
                String line = keyboard.nextLine();
                if (line.equals("-1")) {
                    boo = true;
                } else {
                    outputStream.println(line);
                }
            }
            outputStream.close();
            System.out.println("Those lines were written to " +
                    fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + fileName);
            //System.exit(0);
        }
    }
}
