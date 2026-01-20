package Arrays;

/*
 Problem: Valid Mountain Array
 Link: https://leetcode.com/problems/valid-mountain-array/
 Difficulty: Easy

 Approach:
 - A mountain array must strictly increase to a peak
   and then strictly decrease.
 - First, move forward while elements are increasing.
 - The peak cannot be at index 0 or last index.
 - Then, move forward while elements are decreasing.
 - If we reach the end successfully, it is a valid mountain.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class ValidMountainArray {
    public static boolean optimalSolution(int[] arr) {
        int arrayLength = arr.length;
    
        if (arrayLength < 3) {
            return false;
        }
      
        int leftPointer = 0;
        int rightPointer = arrayLength - 1;
        // The condition leftPointer + 1 < arrayLength - 1 ensures that the peak cannot be at the last position.
        while (leftPointer + 1 < arrayLength - 1 && arr[leftPointer] < arr[leftPointer + 1]) {
            leftPointer++;
        }
      
        // The condition rightPointer - 1 > 0 ensures that the peak cannot be at the first position
        while (rightPointer - 1 > 0 && arr[rightPointer - 1] > arr[rightPointer]) {
            rightPointer--;
        }
      
        // For a valid mountain array, both pointers should meet at the same peak
        return leftPointer == rightPointer;
    }
    public static void main(String[] args) {
        int[] nums = {0,3,2,1 };
        System.out.println("[1. optimalSolution] -> " + optimalSolution(nums));
    }
}
