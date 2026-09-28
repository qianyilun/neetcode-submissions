class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<MyPair> list = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            list.add(new MyPair(position[i], speed[i]));
        }

        // sort and reverse
        list.sort((m1, m2) -> m2.position - m1.position);

        //
        Stack<Double> stack = new Stack<>();
        double firstItem = (double) (target - list.get(0).position) / list.get(0).speed;
        stack.push(firstItem);

        for (int i = 1; i < list.size(); i++) {
            double time = (double) (target - list.get(i).position) / list.get(i).speed;
            while (!stack.isEmpty() && stack.peek() >= time) {
                stack.pop();
            }
            stack.push(time);
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
