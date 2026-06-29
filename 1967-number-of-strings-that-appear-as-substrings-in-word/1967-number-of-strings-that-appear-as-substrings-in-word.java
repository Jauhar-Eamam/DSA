class Solution {
    public int numOfStrings(String[] patterns, String word) {
        

        int result = 0;

        for(int i = 0; i < patterns.length; i++){
            String a = patterns[i];
            if(word.contains(a)){
                result++;
            }
        }

        return result;
    }
}