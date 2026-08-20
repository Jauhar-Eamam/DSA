class Solution {
    public int leastInterval(char[] tasks, int n) {

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
                (a, b) -> {
                    if (a.freq != b.freq) {
                        return b.freq - a.freq;
                    } else {
                        return a.key - b.key;
                    }
                });

        HashMap<Character, Integer> freeSet = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            freeSet.put(tasks[i], freeSet.getOrDefault(tasks[i], 0) + 1);
        }


        HashMap<Character, Integer> storage = new HashMap<>();

        for (char key : freeSet.keySet()) {
            storage.put(key, 1);

            maxHeap.add(new Pair(key, freeSet.get(key)));
        }

        freeSet.clear();
        int intervals = 1;

        while (!maxHeap.isEmpty()) {

            while (!maxHeap.isEmpty()) {
                Pair pq = maxHeap.poll();

                if (intervals < storage.get(pq.key)) {
                    freeSet.put(pq.key, pq.freq);
                } else {
                    pq.freq--;
                    if (pq.freq > 0) {
                        maxHeap.add(new Pair(pq.key, pq.freq));
                    }

                    storage.put(pq.key, intervals + n + 1);

                    break;
                }
            }

            for (char key : freeSet.keySet()) {
                maxHeap.add(new Pair(key, freeSet.get(key)));
            }

            intervals++;
            freeSet.clear();
        }

        return intervals-1;

    }
}

class Pair {
    char key;
    int freq;

    Pair(char key, int freq) {
        this.key = key;
        this.freq = freq;
    }
}