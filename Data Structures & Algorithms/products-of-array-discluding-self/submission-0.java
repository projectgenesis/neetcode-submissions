class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int result = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    result *= nums[j];
                }
            }
            results[i] = result;
        }
        return results;
    }
}  
