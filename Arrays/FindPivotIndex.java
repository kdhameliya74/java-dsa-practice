package Arrays;


/*
 Problem: Find Pivot Index
 Link: https://leetcode.com/problems/find-pivot-index/
 Difficulty: Easy

 Approach:
 - Get total sum of all element
 - Check each element's right sum by removing leftsum and current elemement.
 - where left and right sum are equal that index is our pivot index.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class FindPivotIndex {
    public static int optimalSolution(int[] nums) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (rightSum == leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("[1. optimalSolution] -> " + optimalSolution(new int[]{2,1,-1}));
        System.out.println("[1. optimalSolution] -> " + optimalSolution(new int[]{1,7,3,6,5,6}));

    }
}
