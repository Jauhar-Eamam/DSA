class Solution {
    public List<String> letterCombinations(String digits) {

        ArrayList<String> str = new ArrayList<>();

        if(digits.length() == 0) {
            return str;
        }
        
        String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        StringBuilder tempStr = new StringBuilder("");

        findComb(arr, str, digits, 0, digits.length(), tempStr);

        return str;
    }

    public static void findComb(String[] arr, ArrayList<String> str, String digits, int indx, int n, StringBuilder tempStr ){

        if(indx == n) {
            str.add(tempStr.toString());
            return;
        }

        char terms = digits.charAt(indx);
        String choice = arr[terms - '0'];

        for(int i = 0; i<choice.length(); i++) {
            tempStr.append(choice.charAt(i));
            findComb(arr, str, digits, indx+1, n, tempStr);
            tempStr.deleteCharAt(tempStr.length() - 1);
        }

        return;
    }
}