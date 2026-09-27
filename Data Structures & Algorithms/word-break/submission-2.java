class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        Map<String, Boolean> visited = new HashMap<>();

        return dfs(s, set, visited);
    }

    private boolean dfs(String s, Set<String> dict, Map<String, Boolean> visited) {
        if (s.length() == 0 || dict.contains(s)) {
            return true;
        }

        if (visited.containsKey(s)) {
            return visited.get(s);
        }

        // general
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i);
            if (dict.contains(sub)) {
                if (dfs(s.substring(i), dict, visited)) {
                    visited.put(s.substring(i), true);
                    return true;
                }
            }
        }

        visited.put(s, false);
        return false;
    }
}
