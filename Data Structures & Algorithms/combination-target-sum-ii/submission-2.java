class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> list) {
        if (index > candidates.length || target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            list.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, result, list);
            list.remove(list.size() - 1);
        } 
    }
}
