class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0; // window
        Map<Character, Integer> freq = new HashMap<>(); // of a window

        int result = 1;
        while (right < s.length()) {
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);

            // window valid check: length - maxFreq <= k
            while (!isValidWindow(s, k, freq, left, right)) {
                // shrink the window, pop the left char from map
                freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
                left++;
            }

            int length = right - left + 1;
            result = Math.max(result, length);
            // update the map and make the window larger
            right++;
        }

        return result;
    }

    private boolean isValidWindow(String s, int k, Map<Character, Integer> freq, int left, int right) {
        int maxFreq = getMaxFreqOfWindow(freq);
        int length = right - left + 1;

        return length - maxFreq <= k;
    }

    private int getMaxFreqOfWindow(Map<Character, Integer> freq) {
        int max = 0;

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            max = Math.max(max, entry.getValue());
        }

        return max;
    }
}
