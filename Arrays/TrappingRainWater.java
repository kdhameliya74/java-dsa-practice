package Arrays;

/*
 Problem: Trapping Rain Water
 Link: https://leetcode.com/problems/trapping-rain-water/
 Difficulty: Hard

 Approach:
 - Water trapped at any index depends on the minimum of:
    max height to its left and max height to its right.
    water = min(leftMax, rightMax) - height[i]

 - Instead of using extra arrays for leftMax and rightMax,
     we use two pointers starting from both ends.

 - Maintain:
    leftMax  → maximum height encountered from the left
    rightMax → maximum height encountered from the right

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class TrappingRainWater {
    public static int optimalSolution(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int water = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }
        return water;
    }

    public static int nonOptimalSolution(int[] height) {
        int len = height.length;
        int water = 0;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = height[0];
        right[len - 1] = height[len - 1];

        // fill max left to right
        for(int i = 1; i < len; i++) { // i = 1, 0-index has no boundary
            left[i] = Math.max(left[i-1], height[i]);
        }
        
        for(int i = len-2; i >= 0; i--) { // last element has no right boundary
            right[i] = Math.max(right[i+1], height[i]);
        }

        for(int i= 0; i < len; i++) {
            int minHeight = Math.min(left[i], right[i]);
            water += minHeight - height[i];
        }

        return water;
    }

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        System.out.println("[1. optimalSolution] -> " + optimalSolution(height));
        System.out.println("[2. nonOptimalSolution] -> " + nonOptimalSolution(height));

    }
}
