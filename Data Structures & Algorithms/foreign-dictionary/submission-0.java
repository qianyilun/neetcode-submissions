class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> charToNext = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                charToNext.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String a = words[i - 1];
            String b = words[i];

            if (a.length() > b.length() && a.startsWith(b)) {
                return "";
            }

            for (int j = 0; j < a.length() && j < b.length(); j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    Set<Character> next = charToNext.getOrDefault(a.charAt(j), new HashSet<>());
                    next.add(b.charAt(j));
                    charToNext.put(a.charAt(j), next);

                    break;
                }
            }
        }
        
        for (Map.Entry<Character, Set<Character>> entry : charToNext.entrySet()) {
            for (char next : entry.getValue()) {
                indegrees.put(next, indegrees.getOrDefault(next, 0) + 1);
            }
        }

        int items = charToNext.size();

        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Set<Character>> entry : charToNext.entrySet()) {
            if (!indegrees.containsKey(entry.getKey())) {
                queue.offer(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char c = queue.poll();

                sb.append(c);

                Set<Character> neighbors = charToNext.getOrDefault(c, new HashSet<>());
                for (char next : neighbors) {
                    int indegree = indegrees.get(next);
                    indegree--;

                    if (indegree == 0) {
                        queue.offer(next);
                    }

                    indegrees.put(next, indegree);
                }
            }
        }

        if (sb.length() != items) {
            return "";
        }

        return sb.toString();
    }
}
