class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (isTrue(nums, mid, lo, hi)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }



        return nums[lo];
    }

    private boolean isTrue(int[] nums, int mid, int lo, int hi) {
        return nums[mid] <= nums[hi];
    }
}
