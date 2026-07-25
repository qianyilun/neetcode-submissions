class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<>();

        pairs.put('[', ']');
        pairs.put('{', '}');
        pairs.put('(', ')');

        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                if (pairs.containsKey(c)) {
                    stack.push(pairs.get(c));
                } else {
                    return false;
                }
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
