class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, result, new ArrayList<>(), 0);
        return result;
    }

    private void helper(String s, List<List<String>> result, List<String> list, int index) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        // general
        for (int i = index; i < s.length(); i++) {
            String substr = s.substring(index, i + 1);
            if (isValidPalindrome(substr)) {
                list.add(substr);
                helper(s, result, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isValidPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
