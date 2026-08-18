class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stoneWeight : stones){
            maxHeap.add(stoneWeight);
        }

        while(!maxHeap.isEmpty()){
            int y = maxHeap.poll();
            if(maxHeap.isEmpty()){
                return y;
            }
            int x = maxHeap.poll();

            if(x != y){
                int diff = Math.abs(y - x);

                maxHeap.add(diff);
            }
        }

        return 0;
    }
}