class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        
        for (int n : stones) {
            heap.offer(n);
        }
        
        while (heap.size() > 1) {
            int a = heap.poll();
            int b = heap.poll();
            
            if (a != b) {
                heap.offer(Math.abs(a - b));
            }
        }
        
        return heap.isEmpty() ? 0 : heap.peek();
    }
}
