class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            if (i1[0] == i2[0]) {
                return i1[1] - i2[1];
            }

            return i1[0] - i2[0];
        });

        List<int[]> copyIntervals = new ArrayList<>(Arrays.asList(intervals));

        for (int i = 1; i < copyIntervals.size();) {
            int[] before = copyIntervals.get(i - 1);
            int[] after = copyIntervals.get(i);

            if (!(before[1] >= after[0])) {
                return 0;
            }

            if (before[1] > after[0]) {
                if (after[1] > before[1]) {
                    copyIntervals.remove(i);
                } else {
                    copyIntervals.remove(i - 1);
                }
            } else {
                i++;
            }
        }

        return intervals.length - copyIntervals.size();
    }
}
