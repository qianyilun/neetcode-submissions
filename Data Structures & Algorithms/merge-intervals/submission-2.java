class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Collections.addAll(list, intervals);
        list.sort(Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] prev = intervals[i - 1];

            // curr.start > prev.end
            if (curr[0] > prev[1]) {
                result.add(curr);
            } else {
                // curr.start < prev.start
                int newEnd = Math.max(curr[1], prev[1]);
                result.set(result.size() - 1,  new int[]{prev[0], newEnd});
            }
        }

        int[][] finalResult = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }

        return finalResult;
    }
}
