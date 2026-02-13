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
 - Observation: In an array of size n, at most 2 elements can appear more than ⌊n/3⌋ times.
 - Use the generalized Boyer–Moore Voting Algorithm.
 - Maintain two candidates (candidate1, candidate2) and their counts (count1, count2).
 - First Pass (Voting Phase):
     • If current element matches candidate1 → increment count1.
     • Else if it matches candidate2 → increment count2.
     • Else if count1 == 0 → assign current element to candidate1 and set count1 = 1.
     • Else if count2 == 0 → assign current element to candidate2 and set count2 = 1.
     • Else → decrement both count1 and count2 (triple cancellation).
 - Second Pass (Verification Phase):
     • Reset counts to 0.
     • Count actual occurrences of candidate1 and candidate2.
     • Add those whose frequency is greater than ⌊n/3⌋ to the result.
 - Return the result list.

 Time Complexity: O(n)
 Space Complexity: O(1)
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
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if(num == candidate1) {
                count1++;
            }
            else if(num == candidate2) {
                count2++;
            } else if(count1 ==0) {
                candidate1 = num;
                count1 = 1;
            }
            else if(count2 ==0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }
        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);
        return result.toString();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 2, 4, 1, 4 };
        System.out.println("[1. optimalSolution] -> " + optimalSolution(nums));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(nums));
    }
}
