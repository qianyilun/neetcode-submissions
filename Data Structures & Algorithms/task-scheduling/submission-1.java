class Solution {
    int result = 0;

    public int leastInterval(char[] tasks, int n) {
        List<MyClass> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(new MyClass((char)('A' + i), 0, -1));
        }

        for (char t : tasks) {
            int index = t - 'A';
            list.get(index).freq += 1;
        }

        list.sort((m1, m2) -> Integer.compare(m2.freq, m1.freq));


        while (list.stream().anyMatch(l -> l.freq > 0)) {
            Pair<MyClass, Integer> next = findNextAndUpdate(list, n);

            if (next != null) {
                list.sort((m1, m2) -> Integer.compare(m2.freq, m1.freq));
            }

        }

        return result;
    }

    private Pair<MyClass, Integer> findNextAndUpdate(List<MyClass> list, int cool) {
        List<MyClass> valid = list.stream()
                .filter(l -> l.freq > 0)
                .collect(Collectors.toList());

        if (valid.isEmpty()) {
            return null;
        }

        for (int i = 0; i < valid.size(); i++) {
            if (valid.get(i).time < result) {
                valid.get(i).freq -= 1;
                valid.get(i).time = result + cool;

                result++;

                return new Pair<>(valid.get(i), i);
            }
        }

        result++;

        return null;
    }

    class MyClass {
        char x;
        int freq;
        // waiting time
        int time;

        public MyClass(char x, int freq, int time) {
            this.x = x;
            this.freq = freq;
            this.time = time;
        }
    }
}
