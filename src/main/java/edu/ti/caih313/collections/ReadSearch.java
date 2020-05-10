package edu.ti.caih313.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReadSearch {

    public static void main(String[] args) {
        List<List<String>> sentences = new LinkedList<>();
        List<String> oneSentenceOfWords = new LinkedList<>();
        System.out.println("enter file name");
        Scanner keyboard = new Scanner(System.in);
        String fileName = keyboard.next();
        Scanner inputStream = null;

        try {
            File file = new File(fileName);
            inputStream = new Scanner(file);
            String line = "";
            if (inputStream.hasNextLine()) {
                line = inputStream.nextLine();
            }

            String word = "";
            while (inputStream.hasNextLine()) {
                line = inputStream.nextLine();
                char[] array = new char[line.length()];
                for (int i = 0; i < array.length; i++) {
                    array[i] = line.charAt(i);
                }

                for (int i = 0; i < array.length; i++) {

                    if ((i == 0) && (word != "")) {
                        oneSentenceOfWords.add(word);
                        word = "";
                    }

                    if ((array[i] != ' ') && (array[i] != '.') && (array[i] != '?') && (array[i] != '!')){
                        word += array[i];
                    }
                    if (i != array.length - 1){
                        if((array[i] == '.') && (array[i + 1] != ' ')){
                            word += array[i];
                        }
                    }


                    if (((array[i] == ' ') && (i != 0)) || (i == array.length - 1)) {

                        if (((array[i - 1] != '.') || (array[i - 1] != '?') || (array[i - 1] != '!')) && (array[i - 1] != ' ')) {
                            oneSentenceOfWords.add(word);
                            word = "";

                        }
                    }

                    if (((array[i] == '.') && ((i == array.length - 1) || (array[i + 1] == ' '))) || (array[i] == '?') || (array[i] == '!')){
                        oneSentenceOfWords.add(word);
                        sentences.add(oneSentenceOfWords);
                        oneSentenceOfWords = new LinkedList<>();
                        word = "";
                    }
                }
            }



            try {
                int sentenceNum;
                int wordNum;
                while (true) {

                    System.out.println("enter sentence number");
                    sentenceNum = keyboard.nextInt();
                    if ((sentenceNum > sentences.size()) || (sentenceNum < 1)) {
                        System.out.println("invalid, " + sentences.size() + " sentence(s)");
                    } else {
                        break;
                    }
                }
                oneSentenceOfWords = sentences.get(sentenceNum-1);
                while (true) {

                    System.out.println("enter word number");
                    wordNum = keyboard.nextInt();
                    if ((wordNum >= oneSentenceOfWords.size()) || (wordNum < 1)) {
                        System.out.println("invalid, " + (oneSentenceOfWords.size()-1) + " word(s)");
                    } else {
                        break;
                    }
                }
               /* for (int i = 0; i < sentences.size(); i++){
                    System.out.println(sentences.get(i));
                }*/
                System.out.println(oneSentenceOfWords.get(wordNum-1));
                System.exit(0);
            } catch (InputMismatchException ime) {
                System.out.println("input mismatch exception");
                System.exit(0);
                //System.out.println(ime.getMessage());

            }
            catch (NumberFormatException nfe) {
                System.out.println("number format exception");
                System.exit(0);
                //System.out.println(nfe.getMessage());

            }
        }


        catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + fileName);
        }

        finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }



    }

}
