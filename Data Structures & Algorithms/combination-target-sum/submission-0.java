class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        helper(result, nums, target, 0, new ArrayList<>());

        return result;
    }

    private void helper(List<List<Integer>> result, int[] nums, int target, int index, List<Integer> list) {
        if (index > nums.length || target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            int remain = target - nums[i];

            list.add(nums[i]);
            helper(result, nums, remain, i, list);
            list.remove(list.size() - 1);
        }
    }
}
