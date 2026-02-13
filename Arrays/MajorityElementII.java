package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public static String nonOptimalSolution(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> elements = new ArrayList<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int num : map.keySet()) {
            if (map.get(num) > n / 3) {
                elements.add(num);
            }
        }
        return elements.toString();
    }

    public static String optimalSolution(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> elements = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > n / 3) {
                elements.add(num);
            }
        }
        return elements.toString();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 2, 4, 1, 4 };
        System.out.println("[1. optimalSolution] -> " + optimalSolution(nums));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(nums));
    }
}
