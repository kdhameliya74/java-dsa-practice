package Arrays;

import java.util.Arrays;
/*
 Problem: Range Sum Query – Immutable
 Link: https://leetcode.com/problems/range-sum-query-immutable/
 Difficulty: Easy

 Approach:
 - Prefix sum means “Sum of everything before this index”
 - Use Prefix Sum
 - prefix[i] stores sum of elements from index 0 to i-1
 - Range sum from left to right = prefix[right + 1] - prefix[left]

 Time Complexity: O(n)
 Space Complexity: O(n)
*/

/*
    Refer: https://profound.academy/algorithms-data-structures/prefix-sum-Ccj2qt1MCtTjOTF97hlB

    indx = {  0,  1,  2,  3, 4,  5 }
    arr =  { -2,  0,  3, -5, 2, -1 }
    
    0 = a[0] = -2
    1 = a[0] + a[1] = -2
    2 = a[0] + a[1] + a[2] = 1
    ..
    so on, every increased element common sum is used 
    for index 2, sum of index 0 and 1 is already present just we have to add current index.

    prefix = {0, -2, -2, 1, -4, -2, -3} here at index 0 one zero is always kept to handle previous sum for range 0 to 2

*/

public class RangeSumQueryImmutable {
    public static String optimalSolution(int[] nums, int[][] queries) {

        int[] prefix = new int[nums.length + 1];
        
        for(int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[] sum = new int[queries.length];

        for(int i = 0; i< queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            sum[i] = prefix[right + 1] - prefix[left];
        }

        return Arrays.toString(sum);
    }
    public static void main(String[] args) {

        int[] nums = { -2, 0, 3, -5, 2, -1 };
        int[][] queries = {
                { 0, 2 },
                { 2, 5 },
                { 0, 5 }
        };
        System.out.println("[1. optimalSolution] -> " + optimalSolution(nums, queries));
    }
}
