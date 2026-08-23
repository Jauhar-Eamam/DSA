class Solution {
    boolean isPalindrome(String s) {
        // code here
         int indx = 0;
         
          return palindrom(s, indx);
    }
    
    boolean palindrom(String s, int indx) {
        
        if(indx > s.length() - 1 - indx){
            return true;
        }
        
        if(s.charAt(indx) !=  s.charAt(s.length() - 1 - indx)){
            return false;
        }
        
       return  palindrom(s, indx+1);
        
      
    }
}