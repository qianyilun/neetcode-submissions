class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        for (int n : nums) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }

        Queue<Pair> q = new PriorityQueue<>(nums.length, (p1, p2) -> {
            if (p1.freq != p2.freq) {
                return p2.freq - p1.freq;
            }

            return p1.freq;
        });

        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            q.offer(new Pair(e.getKey(), e.getValue()));
        }
        
        int[] result = new int[k];
        
        for (int i = 0; i < k; i++) {
            result[i] = q.poll().n;
        }
        
        return result;
    }
    
    static class Pair {
        int n;
        int freq;
        
        Pair(int n, int freq) {
            this.n = n;
            this.freq = freq;
        }
    }
}
