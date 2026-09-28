class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int n : nums) {
            set.add(n);
        }
        
        int maxSize = Integer.MIN_VALUE;
        for (int n : nums) {
            int size = 1;

            while (set.contains(n + 1)) {
                size++;
                n = n + 1;
            }

            maxSize = Math.max(maxSize, size);
        }
        
        return maxSize;
    }
}
