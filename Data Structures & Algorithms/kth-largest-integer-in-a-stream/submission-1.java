class KthLargest {

    Queue<Integer> heap = new PriorityQueue<>();
    int k = 0;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            if (heap.size() < k) {
                heap.offer(n);
                continue;
            }

            if (heap.peek() <= n) {
                heap.poll();
                heap.offer(n);
            }
        }
    }

    public int add(int val) {
        if (heap.size() < k) {
            heap.offer(val);
            return heap.peek();
        }
        
        // size >= k
        if (heap.peek() <= val) {
            heap.poll();
            heap.offer(val);
        } 
        return heap.peek();
    }
}
