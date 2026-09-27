/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return 0;
        }

        intervals.sort(Comparator.comparingInt(i -> i.start));

        Queue<Integer> minHeap = new PriorityQueue<>();
        for (Interval interval : intervals) {
            if (minHeap.isEmpty()) {
                minHeap.offer(interval.end);
            } else {
                int earliestEnd = minHeap.peek();
                if (interval.start >= earliestEnd) {
                    minHeap.poll();
                    minHeap.offer(interval.end);
                } else {
                    minHeap.offer(interval.end);
                }
            }
        }
        
        return minHeap.size();
    }
}
