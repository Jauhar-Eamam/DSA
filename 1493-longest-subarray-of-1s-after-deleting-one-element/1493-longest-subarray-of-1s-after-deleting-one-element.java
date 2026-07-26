import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] nums) {

        HashMap<Integer, Integer> list = new HashMap <>();

        int low = 0;

        int max = Integer.MIN_VALUE;

        for( int high = 0 ; high < nums.length; high++){
            int num = nums[high];
            list.put(num, list.getOrDefault(num, 0) +1);

            int diff = (high -low +1) - (list.getOrDefault(1, 0));

            while (diff > 1){
                num = nums[low];
                list.put(num, list.getOrDefault(num, 0) -1);

                low++;

                diff = (high-low +1) - (list.getOrDefault(1, 0));
            }

            max = Math.max(max, high-low +1);

        }

        return (nums.length > 0 ? max-1 : 0);
        
    }
}