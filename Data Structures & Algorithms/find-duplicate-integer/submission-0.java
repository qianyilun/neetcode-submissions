class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        int start = 0;
        while (slow != start) {
            slow = nums[slow];
            start = nums[start];
        }
        
        return start;
    }
}
