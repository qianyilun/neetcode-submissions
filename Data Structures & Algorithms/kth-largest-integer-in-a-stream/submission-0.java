class KthLargest {

    Queue<Integer> heap = new PriorityQueue<>();
    int k = 0;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            if (heap.size() < k) {
                heap.offer(n);
            } else {
                if (!heap.isEmpty() && heap.peek() < k) {
                    heap.offer(n);
                    heap.poll();
                }
            }
        }
    }

    public int add(int val) {
        if (heap.isEmpty()) {
            heap.offer(val);
            return heap.peek();
        }
        
        if (heap.peek() < val && heap.size() >= k) {
            heap.poll();
            heap.offer(val);
            return heap.peek();
        }
        
        heap.offer(val);
        return heap.peek();
    }
}
