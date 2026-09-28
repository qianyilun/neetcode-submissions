class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int remain = target - n;

            if (map.containsKey(remain)) {
                return new int[]{i, map.get(remain)};
            }
        }

        return new int[]{0, 0};
    }
}
