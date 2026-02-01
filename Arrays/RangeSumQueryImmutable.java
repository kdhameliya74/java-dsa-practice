package Arrays;

import java.util.Arrays;
/*
 Problem: Range Sum Query – Immutable
 Link: https://leetcode.com/problems/range-sum-query-immutable/
 Difficulty: Easy

 Approach:
 - Prefix sum means “Sum of everything before this index”

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class RangeSumQueryImmutable {
    public static void main(String[] args) {

        int[] nums = { -2, 0, 3, -5, 2, -1 };

        int[][] queries = {
                { 0, 2 },
                { 2, 5 },
                { 0, 5 }
        };

        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i + 1 + "-" + prefix[i] + " - " + nums[i]);
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[] output = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            output[i] = prefix[right + 1] - prefix[left];
        }

        // int[] output = new int[queries.length+1];
        // int count = 0;
        // for(int[] query: queries) {
        // int sum = 0;
        // for(int i = query[0]; i <= query[1]; i++) {
        // sum+= nums[i];
        // }
        // output[count] = sum;
        // count++;
        // }
        System.out.println(Arrays.toString(output));
    }
}
