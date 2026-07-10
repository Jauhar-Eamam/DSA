import java.util.HashMap;

class Solution {
    public int maxNumberOfBalloons(String text) {
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        int minResult = Integer.MAX_VALUE;

        String s = "balloon";

        for(int i = 0; i < s.length(); i++){
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) +1);
        }

        for(int i = 0 ; i < text.length(); i++) {
            map2.put(text.charAt(i), map2.getOrDefault(text.charAt(i), 0) +1);
        }

        for(char key : map1.keySet()){
            int need_freq = map1.get(key);
            int have_freq = map2.getOrDefault(key, 0);

            int output = have_freq / need_freq;

            minResult = Math.min(minResult, output);

            if(minResult == 0){
                return 0;
            }
        }

        return minResult;
    }
}