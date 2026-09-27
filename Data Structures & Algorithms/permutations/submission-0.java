class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, result, new ArrayList<>(), new HashSet<>());
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> list, Set<Integer> dedup) {
        // quit
        if (list.size() >= nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        // general
        for (int i = 0; i < nums.length; i++) {
            if (dedup.contains(nums[i])) {
                continue;
            }

            list.add(nums[i]);
            dedup.add(nums[i]);
            helper(nums, result, list, dedup);
            list.remove(list.size() - 1);
            dedup.remove(nums[i]);
        }
    }
}
