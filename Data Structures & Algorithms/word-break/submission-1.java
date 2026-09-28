class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        Set<String> visited = new HashSet<>();

        return dfs(s, set, visited);
    }

    boolean result = false;

    private boolean dfs(String s, Set<String> dict, Set<String> visited) {
        if (s.length() == 0 || dict.contains(s)) {
            return true;
        }

        // general
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i);
            if (dict.contains(sub)) {
                if (dfs(s.substring(i), dict, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
