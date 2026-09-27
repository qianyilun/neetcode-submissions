class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char t : tasks) {
            freq.put(t, freq.getOrDefault(t, 0) + 1);
        }

        Queue<MyClass> maxHeap = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(o -> o.freq)));

        Queue<MyClass> coolDownQueue = new ArrayDeque<>();

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            maxHeap.offer(new MyClass(entry.getValue(), 0));
        }

        int result = 0;

        while (!maxHeap.isEmpty() || !coolDownQueue.isEmpty()) {
            while (!coolDownQueue.isEmpty()
                    && coolDownQueue.peek().nextAllowedTime <= result) {
                maxHeap.offer(coolDownQueue.poll());
            }

            if (!maxHeap.isEmpty()) {
                MyClass next = maxHeap.poll();

                next.freq--;
                next.nextAllowedTime = result + n + 1;

                if (next.freq > 0) {
                    coolDownQueue.offer(next);
                }
            }

            result++;
        }

        return result;
    }

    private class MyClass {
        int freq;
        int nextAllowedTime;

        public MyClass(int freq, int nextAllowedTime) {
            this.freq = freq;
            this.nextAllowedTime = nextAllowedTime;
        }
    }
}
