class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        
        // init
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        
        // general
        for (int i = 0; i < nums.length; i++) {
            int max = 1;
            
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(dp[j] + 1, max);
                }
            }
            
            dp[i] = max;
        }
        
        return Arrays.stream(dp).max().getAsInt();
    }
}
