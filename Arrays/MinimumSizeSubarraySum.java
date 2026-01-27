package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
 Problem: Minimum Size Subarray Sum
 Link: https://leetcode.com/problems/minimum-size-subarray-sum/
 Difficulty: Medium

 Approach:
 - 

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class MinimumSizeSubarraySum {

    public static int nonOptimalSolution(int[] nums, int target) {
        int sum = 0;
        List<Integer> elements = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                elements.add(nums[i]);
                break;
            } else {

                for (int j = i + 1; j < nums.length; j++) {
                    elements.clear();
                    sum = nums[i] + nums[j];
                    if (target < sum) {
                        sum = 0;
                        elements.clear();
                        break;
                    }
                    if (target > sum) {
                        elements.add(nums[j]);
                    }
                    if (target == sum) {
                        elements.add(nums[i]);
                        elements.add(nums[j]);
                    }
                }
            }

        }
        // System.out.println(elements.toString());
        return elements.size();
    }

    public static int optimalSolution(int[] nums, int target) {
        int sum = 0;
        List<Integer> elements = new ArrayList<>();
        // 2,3,1,2,4,3
        // left[0] = 2 right[1] = 3

        int left = 0;
        int right = 0;

        while (left <= right) {
            sum += nums[right];
            if(nums[left] == target) {
                elements.add(nums[left]);
                elements.add(nums[right]);
                break;
            }
            
            if(sum < target) {
                right++;
            } else {
                left++;
            }
        }


        // for (int right = 0; right < nums.length; right++) {
        //     sum += nums[right];
        //     int count = right;
        //     while (count < nums.length) {
        //         if(target == sum) {
        //             elements.add(nums[count], nums[right]);
        //         } else if(target > sum) {
        //             count++;
        //         } else if(target < sum) {
        //             count = right;
        //             sum = 0;
        //         }
        //     }
        // }

        return elements.size();
    }

    public static void main(String[] args) {
        // target = 7, nums = [2,3,1,2,4,3]

        int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1 };
        System.out.println("[1. optimalSolution] -> " + optimalSolution(new int[] { 2, 3, 1, 2, 4, 3 }, 7));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(nums, 11));
    }
}