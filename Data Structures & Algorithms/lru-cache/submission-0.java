class LRUCache {

    int size;
    int capacity;
    Map<Integer, DNode> map = new HashMap<>();
    DNode head = new DNode(-1, -1), tail = new DNode(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        // exist
        // get and move to head
        DNode node = map.get(key);

        // move to head
        detachAndMoveToHead(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DNode curr = map.get(key);
            curr.val = value; // update value directly
            detachAndMoveToHead(curr);
            
            return;
        } else {
            DNode n = new DNode(key, value);
            
            if (size < capacity) { // 还可以继续放
                moveToHead(n);
                map.put(key, n);

                size++;
                return;
            }

            // 放不下，要动手术
            // 删掉末尾的
            // remove map & tail
            map.remove(tail.prev.key);
            size--;

            DNode last = tail.prev;
            DNode prevLast = last.prev;
            prevLast.next = tail;
            tail.prev = prevLast;

            last.prev = null;
            last.next = null;

            // add to head;
            moveToHead(n);
            size++;

            map.put(key, n);
        } 

    }

    private void moveToHead(DNode n) {
        DNode next = head.next;

        head.next = n;
        n.prev = head;
        
        n.next = next;
        next.prev = n;
    }

    private void detachAndMoveToHead(DNode n) {
        DNode prev = n.prev;
        DNode next = n.next;

        prev.next = next;
        next.prev = prev;

        moveToHead(n);
    }

    private class DNode {
        int key;
        int val;
        DNode prev = null, next = null;

        public DNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
