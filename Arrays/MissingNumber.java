package Arrays;

/*
 Problem: Missing Number
 Link: https://leetcode.com/problems/missing-number
 Difficulty: Easy

 Approach:
 - Use formula n * (n + 1)/2
 - Find total sum of each element.
 - Substract (formula - total sum) will result missing number.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class MissingNumber {
    public static boolean includes(int[] nums, int target) {
        boolean hasTargetMatch = false;
        for(int number: nums) {
            if(number == target) {
                hasTargetMatch = true;
            }
        }
        return hasTargetMatch;
    }

    /*
    * Time Complexity: O(n^2)
    * Space Complexity: O(1)
    */
    public static int nonOptimalSolution(int[] nums) {
        int missing = -1;
        for(int i=0; i <= nums.length; i++) {
            if(!includes(nums, i)) {
                missing = i;
            }
        }
        return missing;
    }
    public static int optimalSolution(int[] nums) {
        int sum = nums.length * (nums.length + 1)/2;
        int totalSum = 0;
        for(int number: nums) {
            totalSum += number;
        }
        return sum - totalSum;
    }
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println("[1. nonOptimalSolution] Missing Elememt-> " + nonOptimalSolution(nums));
        System.out.println("[2. optimalSolution] Missing Elememt-> " + optimalSolution(nums));
    }
}
