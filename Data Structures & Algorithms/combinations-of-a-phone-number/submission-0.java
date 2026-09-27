class Solution {
    Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }

        List<char[]> chars = new ArrayList<>();

        for (char c : digits.toCharArray()) {
            chars.add(map.get(c).toCharArray());
        }

        List<String> result = new ArrayList<>();
        helper(chars, 0, result, new StringBuilder());
        return result;
    }

    private void helper(List<char[]> chars, int index, List<String> result, StringBuilder sb) {
        if (sb.length() >= chars.size()) {
            result.add(sb.toString());
            return;
        }

        // general
        char[] curr = chars.get(index);
        for (int i = 0; i < curr.length; i++) {
            sb.append(curr[i]);
            helper(chars, index + 1, result, sb);
            sb = sb.deleteCharAt(sb.length() - 1);
        }
    }
}
