package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 Problem: Contain Duplicate
 Link: https://leetcode.com/problems/contains-duplicate/
 Difficulty: Easy

 Approach:
 - Use HashMap to store value → index
 - For each element, check if (HashMap has value) if exists return true
 - For each element, check if (HashSet has value) if exists return true

 Time Complexity: O(n)
 Space Complexity: O(n)
*/

public class ContainDuplicate {
    public static boolean nonOptimalSolution(int[] nums) { 
        // non optimal because we are storing index that we dont need
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            int current = nums[i];
            if(map.containsKey(current)) {
                return true;
            } else {
                map.put(current, i);
            }
        }
        return false;
    }
    public static boolean optimalSolution(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int num: nums) {
            if(!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] duplicates = {1,2,3,1};
        int[] uniques = {1,3,4,5,6,7,2};
        
        System.out.println("[1. nonOptimalSolution] duplicate -> " + nonOptimalSolution(duplicates));
        System.out.println("[2. optimalSolution] duplicate -> " + optimalSolution(duplicates));
        System.out.println("==================================");
        System.out.println("[3. nonOptimalSolution] no duplicate -> " + nonOptimalSolution(uniques));
        System.out.println("[4. optimalSolution] no duplicate -> " + optimalSolution(uniques));
    }
}
