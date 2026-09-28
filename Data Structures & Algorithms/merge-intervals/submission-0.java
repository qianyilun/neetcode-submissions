class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Collections.addAll(list, intervals);
        list.sort(Comparator.comparingInt(i -> i[0]));

        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        for (int[] interval : list) {
            if (minHeap.isEmpty()) {
                minHeap.offer(interval);
            } else {
                int[] curr = minHeap.peek();
                int earliestEnd = curr[1];

                // 不冲突，直接放
                if (interval[0] > earliestEnd) {
                    minHeap.offer(interval);
                } else {
                    // 冲突了，就合并
                    minHeap.poll();
                    minHeap.offer(new int[]{curr[0], interval[1]});
                }
            }
        }

        int[][] result = new int[minHeap.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
