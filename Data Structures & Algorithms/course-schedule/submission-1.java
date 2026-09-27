class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> indegrees = new HashMap<>();
        Map<Integer, Set<Integer>> courseToNext = new HashMap<>();
        List<Integer> sortedCourses = new ArrayList<>();

        for (int[] prerequisite : prerequisites) {
            int nextCourse = prerequisite[0];
            int prevCourse = prerequisite[1];

            indegrees.put(nextCourse, indegrees.getOrDefault(nextCourse, 0) + 1);
            Set<Integer> nexts = courseToNext.getOrDefault(prevCourse, new HashSet<>());
            nexts.add(nextCourse);
            courseToNext.put(prevCourse, nexts);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int course = 0; course < numCourses; course++) {
            int indegree = indegrees.getOrDefault(course, 0);
            if (indegree == 0) {
                queue.offer(course);
                sortedCourses.add(course);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();

            Set<Integer> nexts = courseToNext.getOrDefault(course, new HashSet<>());
            for (int next : nexts) {
                int indegree = indegrees.getOrDefault(next, 0);
                indegree = indegree - 1;
                if (indegree < 0) {
                    throw new RuntimeException("boom");
                }

                if (indegree == 0) {
                    queue.offer(next);
                    sortedCourses.add(course);
                } else {
                    indegrees.put(next, indegree);
                }

            }
        }

        return sortedCourses.size() == numCourses;
    }
}
