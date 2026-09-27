class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<MyClass> heap = new PriorityQueue<>((m1, m2) -> Double.compare(m2.dis, m1.dis));

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            double dis = Math.sqrt(x * x + y * y);

            if (heap.size() < k) {
                heap.offer(new MyClass(points[i], dis));
            } else {
                if (heap.peek().dis > dis) {
                    heap.poll();
                    heap.offer(new MyClass(points[i], dis));
                }
            }
        }

        int[][] result = new int[heap.size()][2];

        for (int i = 0; i < result.length; i++) {
            result[i] = heap.poll().point;
        }
        
        return result;
    }

    private class MyClass {
        int[] point;
        double dis;

        public MyClass(int[] point, double dis) {
            this.point = point;
            this.dis = dis;
        }
    }
}
  