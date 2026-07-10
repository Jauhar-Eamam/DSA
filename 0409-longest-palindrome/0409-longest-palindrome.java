import java.util.HashMap;

class Solution {
    public int longestPalindrome(String s) {
        
        HashMap<Character, Integer> map =  new HashMap<>();

        int maxPalindrom = 0;

        int maxOddFreq = Integer.MIN_VALUE;

        boolean isOdd = false;

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) +1);
        }

        for(char ch : map.keySet()){
            int freq = map.get(ch);

            if(freq%2 == 0){
                maxPalindrom += freq;
            }else {
                maxPalindrom += freq-1;
                isOdd = true;
            }
        }

        if(isOdd == true){
            maxPalindrom += 1;
        }

        return (s.length() == 0 ? 0 : maxPalindrom);

    }
}