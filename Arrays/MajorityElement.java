package Arrays;

import java.util.HashMap;
import java.util.Map;
/*
 Problem: Majority Element
 Link: https://leetcode.com/problems/majority-element
 Difficulty: Easy

 Approach:

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        Map<Integer, Integer> map = new HashMap<>();
        int majorElement = 0;
        int majorValue = 0;
        for(int num: nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }

        System.out.println(map.toString());
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > majorValue) {
                majorValue = entry.getValue();
                majorElement = entry.getKey();
            }
        }
        System.out.println(majorElement);
    }
}
