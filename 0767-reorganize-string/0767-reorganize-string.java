class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        StringBuilder str = new StringBuilder();

        PriorityQueue<Pair> heap = new PriorityQueue<> (
            (a, b) -> {
                if(a.freq != b.freq) {
                    return b.freq - a.freq;
                }else {
                    return b.character.compareTo(a.character);
                }
            }
        );

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int seat = 0;

        for(char ch : map.keySet()) {
            heap.add(new Pair(ch, map.get(ch)));
        }

        while(!heap.isEmpty()) {
            Pair pq = heap.poll();

            if(seat == 0 || str.charAt(seat - 1) != pq.character){
                str.append(pq.character);
                pq.freq--;
                seat++;
                if(pq.freq > 0) {
                heap.add(new Pair(pq.character, pq.freq));
                }
            }else {
                if(heap.isEmpty()) {
                    return "";
                }else {
                    Pair pq2 = heap.poll();
                    str.append(pq2.character);
                    pq2.freq--;
                    seat++;

                    if(pq.freq > 0){
                    heap.add(new Pair(pq.character, pq.freq));

                    }

                    if(pq2.freq > 0 ) {
                    heap.add(new Pair(pq2.character, pq2.freq));
                    }
                }
            }
        }

        return str.toString();
    }
}

class Pair {
    Character character;
    int freq;

    Pair(char ch, int f) {
        character = ch;
        freq = f;
    }
}