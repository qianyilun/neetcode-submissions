class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        Collections.addAll(list, intervals);
        list.add(newInterval);

        list.sort(Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();

        result.add(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            int[] curr = list.get(i);
            int[] prev = result.get(result.size() - 1);

            // curr.start > prev.end
            if (curr[0] > prev[1]) {
                result.add(curr);
            } else {
                int newEnd = Math.max(prev[1], curr[1]);
                result.set(result.size() - 1, new int[]{prev[0], newEnd});
            }
        }
        
        int[][] real = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            real[i] = result.get(i);
        }

        return real;
    }
}