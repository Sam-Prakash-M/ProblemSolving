package com.samprakash.practice.evalution;

import java.util.Scanner;

public class DateDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter day 1 : ");
        int day1 = scanner.nextInt();
        System.out.print("Enter Month 1 : ");
        int mon1 = scanner.nextInt();
        System.out.print("Enter year 1 : ");
        int year1 = scanner.nextInt();
        System.out.print("Enter day 2 : ");
        int day2 = scanner.nextInt();
        System.out.print("Enter month 2 : ");
        int mon2 = scanner.nextInt();
        System.out.print("Enter year 2 : ");
        int year2 = scanner.nextInt();
        findDateDiffference(day1,mon1,year1,day2,mon2,year2);
    }

    private static void findDateDiffference(int day1, int mon1, int year1, int day2, int mon2, int year2) {

        int currYear1 = day1 , currYear2 = day2 ;

        int [] months = {31,28,31,30,31,30,31,31,30,31,30,31};

        for(int i = 0 ; i < mon1 - 1 ; i++) {
            currYear1 += months[i];
        }
        for(int i = 0 ; i < mon2 - 1 ; i++) {
            currYear2 += months[i];
        }
        year1--;
        year2--;
        currYear1 += year1*365 + leapDays(year1);
        currYear2 += year2*365 + leapDays(year2);
        System.out.println("Days Difference is : "+Math.abs(currYear2 - currYear1));
    }

    private static int leapDays(int year) {

        return year/4 + year/400 - year/100;
    }
}
