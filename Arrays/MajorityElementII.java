package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
 Problem: Majority Element II
 Link: https://leetcode.com/problems/majority-element-ii/
 Difficulty: Medium

 Approach:
 - 

 Time Complexity: O(n)
 Space Complexity: O(n)
*/

public class MajorityElementII {
    public static int nonOptimalSolution(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int majorElement = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int num : map.keySet()) {
            if (map.get(num) > n / 3) {
                majorElement = num;
            }
        }
        return majorElement;
    }

    public static int optimalSolution(int[] nums) {
        // Boyer–Moore Code
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }

        return candidate;

        // int n = nums.length;
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int num : nums) {
        // map.put(num, map.getOrDefault(num, 0) + 1);

        // if (map.get(num) > n / 3) {
        // return num;
        // }
        // }
        // return 0;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };
        System.out.println("[1. optimalSolution] -> " + optimalSolution(nums));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(nums));
    }
}
