package edu.ti.caih313.collections;

import java.util.LinkedList;
import java.util.List;

public class Ledger {

        public static List<Double> sales;
        public Ledger(){
            sales = new LinkedList<>();
        }
        public List<Double> addSales(Double d){
            sales.add(d);
            return sales;
        }
        public int getNumberOfSales(){
            return sales.size();
        }
        public double getTotalSales(){
            double total = 0;
            for(int i = 0; i < sales.size(); i++){
                total += sales.get(i);
            }
            return total;
        }
        public double getAverageSale(){
            return getTotalSales()/sales.size();
        }
        public int getCountAbove(double v){
            int count = 0;
            for(int i = 0; i < sales.size(); i++){
                if(sales.get(i) > v){
                    count++;
                }
            }
            return count;
        }


}
