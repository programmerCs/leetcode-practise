package com.cs.algorithm;

public class MountainArray {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0};
        int index = peakIndexInMountainArray(nums);
        System.out.print(index);
    }

    public static int peakIndexInMountainArray(int[] A) {
        int end = A.length - 1;
        int index = 0;
        for (int i = 1; i < end; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int peakIndexInMountainArrayBinarySearch(int[] A) {
        int index = -1;
        int low = 0;
        int high = A.length - 1;
        int middle = (low + high) / 2;
        for (; middle > low && middle < high; ) {
            if (A[middle - 1] < A[middle] && A[middle] > A[middle + 1]) {
                index = middle;
                break;
            }
            if (A[middle - 1] < A[middle] && A[middle] < A[middle + 1]) {
                low = middle;
            } else {
                high = middle;
            }
        }
        return index;
    }
}
