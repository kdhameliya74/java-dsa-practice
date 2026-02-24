package Arrays;

import java.util.Arrays;

/*
 Problem: Sort colors
 Link: https://leetcode.com/problems/sort-colors/
 Difficulty: Medium

 Approach: Dutch National Flag Algorithm
 - Use three pointers: left, mid, right
 - left tracks boundary of 0s
 - mid scans the array
 - right tracks boundary of 2s
 - Swap elements to move 0s to left and 2s to right
 - 1s automatically settle in the middle


 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class SortColors {
    public static String optimalSolution(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high) {

            // 2,0,2,1,1,0
            //0 -> 0,0,2,1,1,2 high--, high = 1, mid = 0
            // low = 0, mid = 0 so low++, mid++

            if(nums[mid] == 0) {
                // swap low, Med
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++; 
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                //2
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }

        return Arrays.toString(nums);
    }

    public static String nonOptimalSolution(int[] nums) {
        // 2,0,2,1,1,0
        // 0,0,2,1,1,2 right = 1
        // may failed for many test cases
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] < nums[right]) {
                left++;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }
        }

        return Arrays.toString(nums);
    }

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        System.out.println("[1. optimalSolution] -> " + optimalSolution(nums));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(nums));
    }
}
