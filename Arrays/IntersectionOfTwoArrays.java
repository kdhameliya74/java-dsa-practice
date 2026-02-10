package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 Problem: Intersection of Two Arrays
 Link: https://leetcode.com/problems/intersection-of-two-arrays
 Difficulty: Easy

 Approach:
 - We use a Hash-based data structure to track unique elements.
 - Store all elements of nums1 in a HashMap (or HashSet).
 - Traverse nums2 and check if the element exists in the map.
 - To avoid duplicates in the result, add an element only once and mark it as visited.
 - Collect all such elements in a list as the intersection.

 Time Complexity: O(n + m) ->  where n =  length of nums1, m =  length of nums2
 Space Complexity: O(n) -> for storing elements of nums1.
*/

public class IntersectionOfTwoArrays {
    public static String optimalSolution(int[] nums1, int[] nums2) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            seen.add(num);
        }

        for (int num : nums2) {
            if (seen.contains(num)) {
                list.add(num);
                seen.remove(num);
            }
        }
        return list.toString();
    }

    public static String nonOptimalSolution(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, 0);
        }

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) == 0) {
                map.put(num, map.get(num) + 1);
                list.add(num);
            }
        }
        return list.toString();
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        System.out.println("[1. optimalSolution] -> " + optimalSolution(nums1, nums2));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(nums1, nums2));
    }

}
