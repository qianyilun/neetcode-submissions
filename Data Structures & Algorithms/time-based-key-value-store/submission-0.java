class TimeMap {
        Map<String, List<MyPair>> map = new HashMap<>();

        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            List<MyPair> list;
            if (!map.containsKey(key)) {
                list = new ArrayList<>();
            } else {
                list = map.get(key);
            }
            list.add(new MyPair(timestamp, value));
            map.put(key, list);
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }

            List<MyPair> list = map.get(key);
            int lo = 0, hi = list.size();
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                
                if (list.get(mid).timestamp > timestamp) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            
            if (lo == 0 && list.get(lo).timestamp != timestamp) {
                return "";
            }
            
            if (lo > 0) {
                return list.get(lo - 1).value;
            } else {
                return "";
            }
        }
    }

    class MyPair {
        int timestamp;
        String value;

        public MyPair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }