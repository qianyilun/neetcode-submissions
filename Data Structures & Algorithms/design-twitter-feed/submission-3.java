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
        temp.addFirst(myTweet);

        if (temp.size() > topK) {
            temp.pollLast();
        }

        feed.put(userId, temp);
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> friends = new HashSet<>(friend.getOrDefault(userId, new HashSet<>()));

        // add self
        friends.add(userId);

        return mergeKSortedList(friends);
    }

    private List<Integer> mergeKSortedList(Set<Integer> friends) {
        Queue<HeapNode> heap = new PriorityQueue<>((n1, n2) -> n2.myTweet.time - n1.myTweet.time);
        
        List<Integer> result = new ArrayList<>();
        
        // 初始化，将所有的头结点加入
        for (int f : friends) {
            LinkedList<MyTweet> tweets = feed.getOrDefault(f, new LinkedList<>());

            Iterator<MyTweet> iterator = tweets.iterator();
            
            if (iterator.hasNext()) {
                heap.offer(new HeapNode(iterator.next(), iterator));
            }

            if (heap.size() > topK) {
                heap.poll();
            }
        }

        // 不一定能满，所以还要继续补齐
        while (!heap.isEmpty() && result.size() < topK) {
            HeapNode node = heap.poll();
            
            result.add(node.myTweet.id);
            
            Iterator<MyTweet> iterator = node.iterator;
            
            // 继续下一轮的竞争
            if (iterator.hasNext()) {
                heap.offer(new HeapNode(iterator.next(), iterator));
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

    private class HeapNode {
        MyTweet myTweet;
        Iterator<MyTweet> iterator;

        public HeapNode(MyTweet myTweet, Iterator<MyTweet> iterator) {
            this.myTweet = myTweet;
            this.iterator = iterator;
        }
    }
}
