package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
 Problem: Find All Numbers Disappeared in an Array
 Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 Difficulty: Easy

 Approach:
  - Each value tells us which index to mark as “visited” by making it negative; 
  - The index left positive corresponds to the missing number.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class FindAllNumbersDisappearedinanArray {

    public static List<Integer> nonOptimalSolution(Integer[] nums) { 
        // Not working properly for some case like - {1,1}
        boolean[] isAvailable = new boolean[nums.length + 1];
        List<Integer> missing = new ArrayList<>();

        for(int num: nums) {
            isAvailable[num] = true; 
        }

        for(int i = 1; i < nums.length; i++) {
            if(!isAvailable[i]) {
                missing.add(i);
            }
        }
        return missing;
    }

    public static List<Integer> optimalSolution(Integer[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };

        System.out.println("[1. nonOptimalSolution] -> " + nonOptimalSolution(nums).toString());
        System.out.println("[2. optimalSolution] -> " + optimalSolution(nums).toString());

    }
}
