class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n, result, new StringBuilder(), 0, 0);

        return result;
    }

    private void helper(int n, List<String> result, StringBuilder sb, int numOfOpen, int numOfClose) {
        if (numOfOpen >= n && numOfClose >= n) {
            result.add(sb.toString());
            return;
        }

        // 可以继续放 (
        if (numOfOpen < n) {
            sb.append("(");
            helper(n, result, sb, numOfOpen + 1, numOfClose);
            sb.deleteCharAt(sb.length() - 1);
        }

        // 可以继续放 )
        if (numOfClose < numOfOpen) {
            sb.append(")");
            helper(n, result, sb, numOfOpen, numOfClose + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
