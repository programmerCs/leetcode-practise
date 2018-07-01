package com.cs.algorithm;

public class LemonadeChange {

    public static void main(String[] args) {
        int[] bills = new int[]{5, 5, 10, 10, 20};
        boolean result = lemonadeChange(bills);
        System.out.println(result);
    }

    public static boolean lemonadeChange(int[] bills) {
        int fiveRemain = 0;
        int tenRemain = 0;
        int twentyRemain = 0;

        int totalRemain = 0;

        for (int i = 0, length = bills.length; i < length; i++) {
            int change = bills[i] - 5;
            if (change > totalRemain) {
                return false;
            }
            if (change == 0) {
                fiveRemain = fiveRemain + 5;
                totalRemain = totalRemain + 5;
                continue;
            }
            if (change == 5) {
                if (fiveRemain < 5) {
                    return false;
                }
                fiveRemain = fiveRemain - 5;
                tenRemain = tenRemain + 10;
                totalRemain = totalRemain + 5;
                continue;
            }
            if (change == 15) {
                if (fiveRemain < 5) {
                    return false;
                }
                if (tenRemain > 0) {
                    fiveRemain = fiveRemain - 5;
                    tenRemain = tenRemain - 10;
                    twentyRemain = twentyRemain + 20;
                    totalRemain = totalRemain + 5;
                    continue;
                } else {
                    if (fiveRemain < 15) {
                        return false;
                    }
                    fiveRemain = fiveRemain - 15;
                    twentyRemain = twentyRemain + 20;
                    totalRemain = totalRemain + 5;
                }
            }
        }
        return true;
    }

}
