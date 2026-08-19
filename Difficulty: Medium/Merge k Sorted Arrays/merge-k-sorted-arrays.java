class Solution {
	public ArrayList<Integer> mergeArrays(int[][] mat) {
		// Code here
		
		PriorityQueue<Pair> minHeap = new PriorityQueue<> (
		
		(a, b) -> {
			return a.value - b.value;
		}
		);
		
		ArrayList<Integer> sortedArr = new ArrayList<> ();
		
		int row = mat.length;
		int col = 0;
		
		
		for(int i = 0; i < mat.length; i++) {
		    minHeap.add(new Pair(mat[i][0], i, 0));
		}
		int count = 0;
		
		while(count < mat.length * mat[0].length) {
		    
		    count++;
		    Pair pq = minHeap.poll();
		    
		    sortedArr.add(pq.value);
		    
		    pq.col++;
		    
		    col = pq.col;
		    row = pq.row + 1;
		    
		    if(pq.col == mat[0].length){
		        continue;
		    }
		    
		    
		    minHeap.add(new Pair(mat[pq.row][pq.col], pq.row, pq.col));
		    
		}
		
		while(!minHeap.isEmpty()){
		sortedArr.add(minHeap.poll().value);
		}
		
		return sortedArr;
		
	}
}

class Pair {
	int value;
	int row;
	int col;
	
	Pair(int value, int row, int col) {
		this.value = value;
		this.row = row;
		this.col = col;
	}
}
