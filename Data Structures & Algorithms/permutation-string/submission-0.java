class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // whether s1 > s2? what happend?

        // fixed window size: length of s1

        // s1 map ?= window map ==> found

        // else right++, left++

        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int right = s1.length() - 1;
        while (right < s2.length()) {
            int start = right + 1 - s1.length();
            // within the window
            Map<Character, Integer> map2 = new HashMap<>();

            for (int i = start; i <= right; i++) {
                map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
            }

            if (map1.equals(map2)) {
                return true;
            }

            right++;
        }

        return false;
    }
}
