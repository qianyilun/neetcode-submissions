class Solution {
    public int maxProfit(int[] prices) {
        int[] rightMax = new int[prices.length];

        int max = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            int n = prices[i];
            max = Math.max(n, max);
            rightMax[i] = max;
        }
        
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            int profile = rightMax[i] - prices[i];
            
            if (profile > 0) {
                result = Math.max(profile, result);
            }
        }
        return result;
    }
}
