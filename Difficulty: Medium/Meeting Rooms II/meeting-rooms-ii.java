import java.util.Arrays;

class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int result = Integer.MIN_VALUE;
        
        int i = 0; 
        int j = 0;
        
        int room = 0;
        
        while(i < start.length && j < end.length){
            
            if(start[i] < end[j]){
                room++;
                i++;
            }else if(start[i] > end[j]){
                room--;
                j++;
            }else{
                i++;
                j++;
            }
            
            result = Math.max(result, room);
        }
        
        return (start.length == 0 ? 0 : result);
        
    }
}
