class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int result = 1;
            int next = i + 1;
            int prev = Math.max(i - 1, 0);

            if (results[prev] != 0 && i < nums.length - 1) {
                results[i] = results[prev] * nums[prev] / nums[i];
            } else {
                for (int j = 0; j < nums.length; j++) {
                    if (j != i) {
                        result *= nums[j];
                    }
                    if (result == 0) break;
                }
                results[i] = result;
            }
        }
        return results;
    }
}  
