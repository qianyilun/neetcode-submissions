class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> list) {
        if (index > nums.length) {
            return;
        }

        result.add(new ArrayList<>(list));
        
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            helper(nums, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
}
