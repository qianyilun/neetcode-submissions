class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] nums1 = new int[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            nums1[i] = nums[i];
        }

        int[] nums2 = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            nums2[i - 1] = nums[i];
        }

        int try1 = findMax(nums1);
        int try2 = findMax(nums2);

        return Math.max(try1, try2);
    }

    private int findMax(int[] nums) {
        int[] dp = new int[nums.length + 1];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }
}
