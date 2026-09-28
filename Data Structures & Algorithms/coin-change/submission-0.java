class Solution {
    public int coinChange(int[] coins, int amount) {
        dfs(coins, amount, 0);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    int result = Integer.MAX_VALUE;

    private void dfs(int[] coins, int amount, int step) {
        if (amount == 0) {
            result = Math.min(result, step);
            return;
        }

        // general
        for (int i = 0; i < coins.length; i++) {
            int remain = amount - coins[i];

            if (remain >= 0) {
                dfs(coins, remain, step + 1);
            }
        }
    }
}
