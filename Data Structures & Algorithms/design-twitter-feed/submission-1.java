class Twitter {

    private Map<Integer, Set<Integer>> friend = new HashMap<>();
    private Map<Integer, LinkedList<MyTweet>> feed = new HashMap<>();

    private int topK = 10;
    private int time = 0;

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        time++;

        LinkedList<MyTweet> temp = feed.getOrDefault(userId, new LinkedList<>());

        MyTweet myTweet = new MyTweet(time, tweetId);

        if (temp.size() < topK) {
            temp.addFirst(myTweet);
        }

        feed.put(userId, temp);
    }

    public List<Integer> getNewsFeed(int userId) {
        Queue<MyTweet> heap = new PriorityQueue<>((m1, m2) -> m2.time - m1.time);

        Set<Integer> friends = friend.getOrDefault(userId, new HashSet<>());

        friends.add(userId);

        for (int f : friends) {
            LinkedList<MyTweet> posts = feed.getOrDefault(f, new LinkedList<>());

            for (MyTweet t : posts) {
                heap.offer(t);
            }
        }

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < topK; i++) {
            if (!heap.isEmpty()) {
                result.add(heap.poll().id);
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> temp = friend.getOrDefault(followerId, new HashSet<>());

        temp.add(followeeId);

        friend.put(followerId, temp);

    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> temp = friend.getOrDefault(followerId, new HashSet<>());

        temp.remove(followeeId);

        friend.put(followerId, temp);
    }

    private class MyTweet {
        int time;
        int id;

        public MyTweet(int time, int id) {
            this.time = time;
            this.id = id;
        }
    }
}
