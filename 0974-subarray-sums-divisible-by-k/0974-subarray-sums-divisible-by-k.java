import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;

        int freq = 0;

        int result = 0;


        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            int ans = sum % k;

            if(ans < 0){
                ans += k;
            }

           freq = map.getOrDefault(ans, 0);
           map.put(ans, map.getOrDefault(ans, 0)+1);
        
            result += freq;

        }

        return (nums.length == 0 ? 0 : result);

    }
}