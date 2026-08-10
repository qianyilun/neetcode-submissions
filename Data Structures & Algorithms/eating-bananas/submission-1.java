class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = Arrays.stream(piles).max().getAsInt();

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (spendHours(mid, piles) <= h) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private int spendHours(int rate, int[] piles) {
        int total = 0;
        for (int p : piles) {
            total += Math.ceil((double) p / rate);
        }
        return total;
    }
}
