package Arrays;

import java.util.HashMap;

/*
 Problem:  Subarray Sum Equals K
 Link: https://leetcode.com/problems/subarray-sum-equals-k
 Difficulty: Medium

 Approach:
 - Use a prefix sum to keep track of the cumulative sum up to the current index.
 - Use a HashMap to store how many times each prefix sum has appeared.
 - At each index, check if (currentSum - k) exists in the map.
 - If it does, it means there is a subarray ending at the current index whose sum equals k.
 - Add the frequency of (currentSum - k) to the result.
 - Update the map with the current prefix sum.
 - Initialize the map with (0 -> 1) to handle subarrays that start from index 0.

 Time Complexity: O(n)
 Space Complexity: O(n) // In the worst case, the HashMap stores all distinct prefix sums.
*/

public class SubarraySumEqualsK {
    public static int nonOptimalSolution(int[] nums, int k) {
        int count = 0;
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = 0; i < prefix.length; i++) {
            if (prefix[i] == k) {
                count = i + 1;
                break;
            }
        }
        return count;
    }

    public static int optimalSolution(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // nums = [3]
        // prefixSum = 3
        // PrefixSum - k = 0;
        // 0 is not count So at index 0, subarray occurs once.

        map.put(0, 1); // Before we start, the prefix sum 0 has occured once.
        int prefixSum = 0;
        int count = 0;
        for (int num : nums) {
            prefixSum += num;
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int k = 3;
        System.out.println("[1. optimalSolution] -> " + optimalSolution(nums, k));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(nums, k));
    }
}
