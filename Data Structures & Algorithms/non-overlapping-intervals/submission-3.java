class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            if (i1[0] == i2[0]) {
                return i1[1] - i2[1];
            }

            return i1[0] - i2[0];
        });

        int result = 0;
        int[] before = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            if (before[1] > curr[0]) {
                result++;
                if (before[1] > curr[1]) {
                    before = curr;
                }
            } else {
                before = curr;
            }
        }

        return result;
    }
}
