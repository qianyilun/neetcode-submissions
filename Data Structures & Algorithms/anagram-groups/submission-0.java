class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();

        for (String s : strs) {
            Map<Character, Integer> m = new HashMap<>();

            for (char c : s.toCharArray()) {
                m.put(c, m.getOrDefault(c, 0) + 1);
            }

            if (map.containsKey(m)) {
                map.get(m).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(m, new ArrayList<>(list));
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Map<Character, Integer>, List<String>> entry : map.entrySet()) {
            result.add(new ArrayList<>(entry.getValue()));
        }

        return result;
    }

}
