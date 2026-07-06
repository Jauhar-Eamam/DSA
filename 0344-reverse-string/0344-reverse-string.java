

class Solution {
    public void reverseString(char[] s) {
        

        // char str[] = new char[s.length];

        int j = s.length-1;

        for(int i = 0; i <= j; i++){
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;

            j--;
        }

        // return str;

    }
}