class Solution {
	public int findKRotation(int arr[]) {
		
		int result = Integer.MAX_VALUE;
		
		int low = 0;
		int high = arr.length - 1;
		
		int mid = (int) (low + high) / 2;
		
		boolean isRotated = false;
		
		int start = arr[0];
		
		if (arr[0] > arr[arr.length - 1]) {
			isRotated = true;
		} else {
			return 0;
		}
		
		while (low <= high) {
			
			if (arr[mid] >= start) {
				low = mid + 1;
			} else {
				result = Math.min(result, mid);
				high = mid - 1;
			}
			
			mid = (int) (low + high) / 2;
			
		}
		
		return result;
	}
}
