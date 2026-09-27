class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result, new ArrayList<>());

        return result;
    }

    private void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> list) {
        if (index > nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, i + 1, result, list);
            list.remove(list.size() - 1);
        }

        result.add(new ArrayList<>(list));
    }
}
