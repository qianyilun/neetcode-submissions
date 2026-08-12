class Solution {
    public int search(int[] nums, int target) {

        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // now is on the left partial
            if (nums[lo] <= nums[mid]) {
                // target is still on the left part of left part
                if (nums[lo] <= target && target <= nums[mid]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            } else { // on the right partial
                // target is still on the right part of right part
                if (nums[mid] <= target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
        }

        if (nums[lo] == target){
            return lo;
        }
        if (nums[hi] == target) {
            return hi;
        }

        return -1;
    }
}
