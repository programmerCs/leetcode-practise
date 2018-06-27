package com.cs.algorithm;

import java.util.*;

/**
 * three num add equesl0<br/>
 * leetcode 15
 */
public class ThreeNumberSumCode {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 0, 0};  //0 0 ,0
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);

        Set<String> sssssaasset=new HashSet<String>();

    }

    //0 0 0

    //[-1, 0, 1, 2, -1, -4],
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int twoSum = nums[low] + nums[high];
                int num = nums[i] + twoSum;
                if (num < 0) {
                    low++;
                } else if (num > 0) {
                    high--;
                } else {
                    List<Integer> list = Arrays.asList(new Integer[]{nums[i], nums[low], nums[high]});
                    result.add(list);
                    while (low+1<nums.length && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    while (high-1>=0 &&nums[high] == nums[high - 1]) {
                        high--;
                    }
                    low++;
                    high--;
                }
            }
            while (i+1<nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }


}
