class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            // predictive: contains and only contains, so it's ok to find the first element, 
            // a[i] >= x or a[i] > x? ==> find the first left element, so it's >=
            if (nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        // if cannot find, the lo will be at len(arr) index position or now lo is where it should be inserted
        // so, lo < nums.length cannot be skippped. 
        if (lo < nums.length && nums[lo] == target) {
            return lo;
        }

        return -1;
    }
}
