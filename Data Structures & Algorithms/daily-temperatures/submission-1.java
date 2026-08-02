class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        
        Stack<Integer> minstack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            // keep popping and calculating
            while (!minstack.isEmpty() && temperatures[minstack.peek()] < temperatures[i]) {
                int index = minstack.pop();
                result[index] = i - index;
            }
            
            minstack.push(i);
        }
        
        return result;
    }
}
