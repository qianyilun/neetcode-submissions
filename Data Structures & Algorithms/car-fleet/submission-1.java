class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<MyPair> list = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            list.add(new MyPair(position[i], speed[i]));
        }

        // 从距离终点最近到距离终点最远
        list.sort((a, b) -> Integer.compare(b.position, a.position));

        Stack<Double> stack = new Stack<>();

        for (MyPair car : list) {
            double time = (double) (target - car.position) / car.speed;

            // 如果此时的车更快，都不用入栈，反之，更慢的入栈（即需要更久的到达时间的需要入栈）
            if (stack.empty() || stack.peek() < time) {
                stack.push(time);
            }
        }

        return stack.size();
    }

    private static class MyPair {
        int position;
        int speed;

        public MyPair(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
}
