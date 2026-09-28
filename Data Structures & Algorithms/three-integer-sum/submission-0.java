class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 快进到一个值不一样的地方开始
            if (i > 0 && i < nums.length && nums[i] == nums[i - 1]) {
                continue;
            }

            twoSum(i, nums, result);
        }

        return result;
    }

    private static void twoSum(int i, int[] nums, List<List<Integer>> result) {
        int left = i + 1, right = nums.length - 1;
        int target = -nums[i];

        while (left < right) {
            while (left < right && left < nums.length && nums[left] == nums[left + 1]) {
                left++;
            }

            while (left < right && right >= 0 && nums[right] == nums[right - 1]) {
                right--;
            }

            while (left < right && nums[left] + nums[right] > target) {
                right--;
            }

            while (left < right && nums[left] + nums[right] < target) {
                left++;
            }

            if (left < right && nums[left] + nums[right] == target) {
                List<Integer> item = new ArrayList<>();

                item.add(nums[i]);
                item.add(nums[left]);
                item.add(nums[right]);

                result.add(item);

                left++;
                right--;
            }
        }
    }
}
