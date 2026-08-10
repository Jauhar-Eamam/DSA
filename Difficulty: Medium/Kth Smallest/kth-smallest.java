

class Solution {
    public int kthSmallest(int[] arr, int k) {
        
        PriorityQueue <Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < arr.length; i++){
            if( i < k) {
                heap.add(arr[i]);
                continue;
            }
            
            if(heap.peek() <= arr[i]) {
                continue;
            }else{
                heap.poll();
                heap.add(arr[i]);
            }
        }
        
        return heap.peek();
        
    }
}
