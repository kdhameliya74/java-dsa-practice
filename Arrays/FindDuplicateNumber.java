package Arrays;

/*
 Problem: Majority Element II
 Link: https://leetcode.com/problems/find-the-duplicate-number
 Difficulty: Medium

 Approach:(Floyd’s Cycle Detection - Tortoise & Hare)
 - Since the array contains n+1 integers where each integer is in the range [1, n],
 we can treat the array like a linked list:

     index → nums[index]

 Because there are n+1 indices but only n possible values,
 at least one value must repeat (Pigeonhole Principle).
 This repetition creates a cycle in the "linked list".

 Phase 1: Detect the cycle
 - Use two pointers:
     slow moves 1 step at a time  → slow = nums[slow]
     fast moves 2 steps at a time → fast = nums[nums[fast]]
 - They will eventually meet inside the cycle.

 Phase 2: Find the entry point of the cycle
 - Reset one pointer to the start of the array.
 - Move both pointers one step at a time.
 - The point where they meet again is the duplicate number.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class FindDuplicateNumber {
    public static int optimalSolution(int[] nums) {
        int slow = nums[nums[0]];
        int fast = nums[nums[nums[0]]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            System.out.println(fast + " -> "+ slow);
        }

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 3, 4, 2 };
        System.out.println("[1. optimalSolution] -> " + optimalSolution(nums));
    }
}
