package com.samprakash.practice.evalution;

import java.io.*;
import java.util.*;

public class CSVFile {
    public static void main(String[] args) {
        
        writeCSVFile();
        readOneCSVFileAndWriteIntoAnotherCSVFile();
    }

    private static void readOneCSVFileAndWriteIntoAnotherCSVFile() {

        Map<String,Integer> stocks = new HashMap<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("input.csv"));
            String line;
            while((line = bufferedReader.readLine()) != null) {
                String [] currStocks = line.split(",");

                stocks.put(currStocks[0],Integer.valueOf(currStocks[1]));
            }
            bufferedReader.close();

        }
        catch (IOException io) {
            System.out.println("Errors in File");
        }
        List<Map.Entry<String,Integer>> entrySet =  new ArrayList<>(stocks.entrySet());
        Collections.sort(entrySet,Map.Entry.comparingByValue(Collections.reverseOrder()));

        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter("output.csv"));
            for(Map.Entry<String,Integer> entry : entrySet) {
                printWriter.println(entry.getKey()+","+entry.getValue());
            }
            printWriter.flush();

        }
        catch (IOException io) {
            System.out.println("Errors in File : ");
        }
        finally {
            printWriter.close();
        }

    }

    private static void writeCSVFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Number of Stocks Count : ");
        int stocksCount = sc.nextInt();
        sc.nextLine();
        Map<String,Integer> stocks = new HashMap<>();
        for(int i = 1 ; i <= stocksCount ; i++) {
            System.out.println("Enter Name of Stock : "+i);
            String stockName = sc.nextLine();
            System.out.println("Enter a price of "+stockName);
            int price = sc.nextInt();
            sc.nextLine();
            stocks.put(stockName,price);
        }
       Set <Map.Entry<String,Integer>> entrySet =  stocks.entrySet();
        PrintWriter printWriter = null;
        try {
             printWriter = new PrintWriter(new FileWriter("input.csv"));
            for(Map.Entry<String,Integer> entry : entrySet) {
                printWriter.println(entry.getKey()+","+entry.getValue());
            }
           printWriter.flush();

        }
        catch (IOException io) {
           System.out.println("Errors in File : ");
        }
        finally {
            printWriter.close();
        }
    }
}
