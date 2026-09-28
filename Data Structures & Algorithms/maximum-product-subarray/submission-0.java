class Solution {
    public int maxProduct(int[] nums) {
        int[] maxDp = new int[nums.length + 1];
        int[] minDp = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            maxDp[i] = nums[i];
            minDp[i] = nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            maxDp[i] = Integer.max(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]);
            minDp[i] = Integer.min(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]);
        }

        return Arrays.stream(maxDp).max().getAsInt();
    }
}
