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
        List<Integer> elements = new ArrayList<>();


        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            
            if(target == nums[left] + nums[right]) {
                elements.add(nums[left]);
                elements.add(nums[right]);
            }
            if (target > nums[left] + nums[right]) {
                right--;
            }
            if(left < right) {
                left++;
            }
            if(nums[left] == target || nums[right] == target) {
                elements.add(1);
                break;
            }
        }

        return elements.size();
    }

    public static void main(String[] args) {
        System.out.println("[1. optimalSolution] -> " + optimalSolution(new int[] { 2,3,1,2,4,3 }, 7));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }, 11));
    }
}