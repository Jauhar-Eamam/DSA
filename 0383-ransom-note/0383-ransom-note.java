import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i < magazine.length(); i++) {
            map1.put(magazine.charAt(i), map1.getOrDefault(magazine.charAt(i), 0) +1);
        }

        for(int i = 0 ; i < ransomNote.length(); i++){
            map2.put(ransomNote.charAt(i), map2.getOrDefault(ransomNote.charAt(i), 0) +1);
        }

        for(int i = 0; i < ransomNote.length(); i++){
            int ransomNotes = map2.get(ransomNote.charAt(i));
            int magazines = map1.getOrDefault(ransomNote.charAt(i), 0);
            if( (ransomNotes != magazines)){
                if(ransomNotes > magazines){
                 return false;
                }
            }
        }

        return true;

    }
}