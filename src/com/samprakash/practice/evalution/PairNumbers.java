package com.samprakash.practice.evalution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairNumbers {
    public static void main(String[] args) {

        findLongestPair(new int[][]{{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} });
    }

    private static void findLongestPair(int[][] arr) {

        Arrays.sort(arr,(e1,e2) -> Integer.compare(e1[0],e2[0]) );


        int previous = Integer.MIN_VALUE;
        List<int[]> pairs = new ArrayList<>();

        for (int[] val : arr) {
            if (val[0] > previous) {
                pairs.add(val);
                previous = val[1];
            }
        }
        pairs.forEach((val) -> System.out.println(Arrays.toString(val)));
    }
}
