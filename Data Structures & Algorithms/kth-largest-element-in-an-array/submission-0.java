class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();

        for (int n : nums) {
            if (heap.size() < k) {
                heap.offer(n);
            } else {
                if (heap.peek() < n) {
                    heap.poll();
                    heap.offer(n);
                }
            }
        }

        return heap.peek();
    }
}
