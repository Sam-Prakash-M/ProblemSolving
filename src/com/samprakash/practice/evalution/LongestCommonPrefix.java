package com.samprakash.practice.evalution;

import java.util.Scanner;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Array Size : ");
        int size = sc.nextInt();
        sc.nextLine();
        String [] str = new String[size];
        System.out.println("Enter a Each Element : ");
        for(int i = 0 ; i < str.length;i++) {
            str[i] = sc.nextLine();
        }
        String longestCommonPrefix = findLongestCommonPrefix(str);
        System.out.println("Output is  : "+longestCommonPrefix);
    }

    private static String findLongestCommonPrefix(String[] str) {


        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < str[0].length() ; i++) {

            for(String s : str) {
                if(i >= s.length() || s.charAt(i) != str[0].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(str[0].charAt(i));
        }
        return sb.toString();
    }
}
