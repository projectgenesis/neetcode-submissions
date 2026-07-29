class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];
        results[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            results[i] = results[i - 1] * nums[i - 1];
        }
        int postfix = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            results[j] *= postfix;
            postfix *= nums[j];
        }

        return results;
    }
}  
