class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> arr= new ArrayList<>();
        StringBuilder str = new StringBuilder();

         findcombinationOfParenthesis( arr, 0, 0, n, str);

         return arr;
    }

    public static void findcombinationOfParenthesis(ArrayList<String> arr, int open, int close, int n, StringBuilder str){

        if(open == n && close == n) {
            arr.add(str.toString());
            return;
        }
        if(open < n){
            str.append("(");
            findcombinationOfParenthesis(arr, open+1, close, n, str);
            str.deleteCharAt(str.length() - 1);
        }

        if(close < open) {
            str.append(")");
            findcombinationOfParenthesis(arr, open, close+1, n, str);
            str.deleteCharAt(str.length() - 1);
        }

        return;
    }
}