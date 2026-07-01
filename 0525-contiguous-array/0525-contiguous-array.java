import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        int result = 0;

        int zero = 0;
        int one = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zero++;
            }else {
                one++;
            }

            int diff = one - zero;

            if(diff == 0){
                result = Math.max(result, i + 1);
                continue;
            }

            int outcomes = map.getOrDefault(diff, -1);

            if(outcomes == -1){
                map.put(diff, i);
                continue;
            }

            result = Math.max(result, i-outcomes);
        }

        return (nums.length != 0 ? result : 0);

    }
}