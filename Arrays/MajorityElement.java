package Arrays;

import java.util.HashMap;
import java.util.Map;
/*
 Problem: Majority Element
 Link: https://leetcode.com/problems/majority-element
 Difficulty: Easy

 Approach:
 - We use a frequency HashMap to count occurrences of each element.
 - While counting, if any element's frequency exceeds n/2,
 - we return that element as the majority element.

 - Alternatively, we can use Boyer–Moore Voting Algorithm
 - which solves the problem in O(n) time and O(1) space.

 Time Complexity: O(n)
 Space Complexity: O(n)
*/

public class MajorityElement {

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
            if (map.get(num) > n / 2) {
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

        // if (map.get(num) > n / 2) {
        // return num;
        // }
        // }
        // return 0;
    }

    public static void main(String[] args) {
        int[] nums = { 2,2,1,1,1,2,2 };
        System.out.println("[1. optimalSolution] -> " + optimalSolution(nums));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(nums));
    }
}
