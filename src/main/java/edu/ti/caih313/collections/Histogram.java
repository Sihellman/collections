package edu.ti.caih313.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Map<Double, Integer> frequencies = new HashMap<>();
        double entry = 0;
        while(true){
            System.out.println("enter number, or a negative number to stop");
            entry = keyboard.nextDouble();
            if(entry < 0){
                break;
            }
            if (frequencies.containsKey(entry)){
                frequencies.put(entry, frequencies.get(entry)+1);
            }
            else{
                frequencies.put(entry, 1);
            }
        }
        for (double key : frequencies.keySet()) {
            System.out.println("the number " + key + " occurs " + frequencies.get(key) + " times");
        }
        System.out.println();
    }
}
