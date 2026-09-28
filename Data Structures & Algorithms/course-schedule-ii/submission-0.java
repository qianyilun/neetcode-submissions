class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> indegrees = new HashMap<>();
        Map<Integer, Set<Integer>> courseToNext = new HashMap<>();

        for(int[] prereq : prerequisites) {
            int curr = prereq[0];
            int prev = prereq[1];

            indegrees.put(curr, indegrees.getOrDefault(curr, 0) + 1);

            Set<Integer> nexts = courseToNext.getOrDefault(prev, new HashSet<>());
            nexts.add(curr);
            courseToNext.put(prev, nexts);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int course = 0; course < numCourses; course++) {
            if (indegrees.getOrDefault(course, 0) == 0) {
                queue.offer(course);
            }
        }


        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result.add(course);
            
            Set<Integer> nexts = courseToNext.getOrDefault(course, new HashSet<>());
            for (int next : nexts) {
                int indegree = indegrees.getOrDefault(next, 0);
                indegree--;
                
                if (indegree == 0) {
                    queue.offer(next);
                } else {
                    indegrees.put(next, indegree);
                }
            }
        }

        int[] realResult = new int[result.size()];
        for (int i = 0; i < realResult.length; i++) {
            realResult[i] = result.get(i);
        }

        return realResult;
    }
}
