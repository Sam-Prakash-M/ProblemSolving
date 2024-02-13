package com.samprakash.practice.evalution;
import java.util.Scanner;

public class StringToHex {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Word");
        String str = scanner.nextLine();
       String result =  findHexaDecimalValue(str);

        System.out.println("Result is : "+result);
    }

    private static String findHexaDecimalValue(String str) {

        char [] hex = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char [] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : ch) {
            int asciiNo = c;
            StringBuilder currValue = new StringBuilder();
            while(asciiNo != 0) {
                int rem = asciiNo % 16;
                currValue.insert(0,hex[rem]);
                asciiNo /= 16;
            }
            sb.append(currValue);
        }
       return sb.toString();
    }
}
