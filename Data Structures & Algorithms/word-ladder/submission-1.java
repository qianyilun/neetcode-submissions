class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String s : wordList) {
            if (isValidDistance(beginWord, s)) {
                Set<String> visited = new HashSet<>();
                Queue<String> queue = new LinkedList<>();

                visited.add(s);
                queue.offer(s);

                bfs(queue, visited, wordList, endWord);
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    int result = Integer.MAX_VALUE;

    private void bfs(Queue<String> queue, Set<String> visited, List<String> wordList, String endWord) {
        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;


            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (endWord.equals(curr)) {
                    result = Math.min(result, steps);
                    return;
                }

                for (String next : wordList) {
                    if (isValidDistance(curr, next) && !visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }

        }

        return;
    }

    private boolean isValidDistance(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }

            if (diff > 1) {
                return false;
            }
        }

        return true;
    }
}
