class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<>();

        pairs.put('[', ']');
        pairs.put('{', '}');
        pairs.put('(', ')');

        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(pairs.get(c));
            } else if (stack.peek() != c) {
                stack.push(pairs.get(c));
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
