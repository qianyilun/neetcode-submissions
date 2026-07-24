class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        // maintains the window without dups
        int left = 0, right = 1;

        Set<Character> dedups = new HashSet<>(); // dedups within a window
        dedups.add(s.charAt(left));

        int result = 1;

        while (right < s.length()) {
            if (!dedups.contains(s.charAt(right))) {
                dedups.add(s.charAt(right));
                result = Math.max(result, (right - left + 1));

                right++;
            } else {
                while (dedups.contains(s.charAt(right))) {
                    dedups.remove(s.charAt(left));
                    left++;
                }
            }
        }

        return result;
    }
}
