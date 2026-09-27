class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> cache = new HashMap<>();
        int result = needAdditionalSteps(coins, amount, cache);
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int needAdditionalSteps(int[] coins, int amount, Map<Integer, Integer> cache) {
        if (amount == 0) {
            return 0;
        }

        // general
        if (cache.containsKey(amount)) {
            return cache.get(amount);
        }

        int minSteps = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int remain = amount - coins[i];

            if (remain >= 0) {
                int step = needAdditionalSteps(coins, remain, cache);
                
                if (step != Integer.MAX_VALUE) {
                    minSteps = Math.min(step + 1, minSteps);
                }
            }
        }

        cache.put(amount, minSteps);

        return minSteps;
    }
}
