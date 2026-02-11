package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 Problem: Intersection of Two Arrays II
 Link: https://leetcode.com/problems/intersection-of-two-arrays-ii/
 Difficulty: Easy

 Approach:
 - We use a HashMap to store the frequency of elements in nums1.
    1. Traverse nums1 and count occurrences of each element.
    2. Traverse nums2:
        - If an element exists in the map and its frequency > 0, add it to the result.
        - Decrement its frequency in the map to handle duplicates correctly.
    3. Return the collected intersection elements.

 Time Complexity: O(n + m)
 Space Complexity: O(n)
*/

public class IntersectionOfTwoArraysII {
    public static String optimalSolution(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num: nums2) {
            if(map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        return list.toString();
    }
    public static void main(String[] args) {
        System.out.println("[1. optimalSolution] -> " + optimalSolution(new int[]{1, 2, 2, 1 }, new int[]{2, 2 }));
        System.out.println("[1. optimalSolution] -> " + optimalSolution(new int[]{4,9,5 }, new int[]{9,4,9,8,4 }));

    }

}
