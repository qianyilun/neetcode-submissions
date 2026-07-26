class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (String s : tokens) {
            if (isOps(s)) {
                // calculate
                int b = nums.pop();
                int a = nums.pop();
                int result = calculate(a, b, s);
                nums.push(result);
            } else {
                nums.push(Integer.parseInt(s));
            }
        }

        return nums.peek();
    }

    private boolean isOps(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int calculate(int a, int b, String s) {
        if (s.equals("+")) {
            return a + b;
        }
        if (s.equals("-")) {
            return a - b;
        }
        if (s.equals("*")) {
            return a * b;
        }
        if (s.equals("/")) {
            return a / b;
        }

        return 0;
    }
}
