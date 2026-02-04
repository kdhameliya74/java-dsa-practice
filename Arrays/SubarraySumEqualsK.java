package Arrays;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;
        int count = 0;
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        for(int i = 0; i < prefix.length; i++) {
            if(prefix[i] == k) {
                count = i + 1;
                break;
            }
        }
        System.out.println(count);
    }
}
