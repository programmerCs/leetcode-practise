package com.cs.algorithm;

import java.util.HashMap;
import java.util.Map;


public class BuddyStrings {


    public static void main(String[] args) {
        String a = "aba";
        String b = "aba";
        //abab
        //abab

        boolean result = buddyStrings(a, b);
        System.out.println(result);
    }


    public static boolean buddyStrings(String A, String B) {
        if (A.isEmpty() || B.isEmpty()) {
            return false;
        }
        if (A.length() != B.length()) {
            return false;
        }
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();

        //用数组代替hashmap
        boolean result = false;
        int firstNotEqual = -1;
        int secondNotEqual = -1;

        int[] counts = new int[26];
        int index = 0;
        for (int i = 0, length = charsA.length; i < length; i++) {
            index = charsA[i] - 'a';
            counts[index] = counts[index] + 1;

            if (charsA[i] == charsB[i]) {
                continue;
            }
            if (result == true) {
                return false;
            }
            if (-1 == firstNotEqual) {
                firstNotEqual = i;
            }
            if (-1 == secondNotEqual && i != firstNotEqual) {
                secondNotEqual = i;
            }

            if (-1 == firstNotEqual || -1 == secondNotEqual) {
                continue;
            }
            if (charsA[firstNotEqual] != charsB[secondNotEqual] || charsA[secondNotEqual] != charsB[firstNotEqual]) {
                return false;
            } else {
                result = true;
            }
        }
        if (false == result) {
            for (int count : counts) {
                if (count >= 2) {
                    return true;
                }
            }
        }
        return result;
    }
}
