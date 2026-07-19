import java.util.ArrayList;

class Solution {
    public int[] sortedSquares(int[] nums) {


        ArrayList<Integer> arrA = new ArrayList<>();
        ArrayList<Integer> arrB = new ArrayList<>();

        int k = 0;

        while(k < nums.length){
            if(nums[k] >= 0){
                arrB.add(nums[k]);
            }else if(nums[k] < 0) {
                arrA.add(nums[k]);
            }

            k++;
        }

        if(arrA.size() == 0){
            int arr[] = new int[nums.length];

            for(int a = 0; a < arrB.size(); a++){
                arr[a] = arrB.get(a) * arrB.get(a);
            }
            return arr;
        }

        if(arrB.size() == 0 ){
            int size = nums.length;
            int arr[] = new int[size];

            for(int a = 0; a < arrA.size(); a++){
                arr[a] = arrA.get(a) * arrA.get(a);
            }

            int i = 0;
            int j = size-1;

        while( i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

            return arr;
        }
        
        k = 0;
        while( k < arrA.size()){
            arrA.set(k, arrA.get(k) * arrA.get(k));
            k++;
        }

        k = 0;

        while( k < arrB.size()){
            arrB.set(k, arrB.get(k) * arrB.get(k));
            k++;
        }

        int i = 0;
        int j = arrA.size()-1;

        while( i < j){
            int temp = arrA.get(i);
            arrA.set(i, arrA.get(j));
            arrA.set(j, temp);
            i++;
            j--;
        }

        int arr[] = new int[arrA.size() + arrB.size()];

        i = 0;
        j = 0;
        k = 0;

        while((i < arrA.size()) && (j < arrB.size())){
            if(arrA.get(i) <= arrB.get(j)){
                arr[k] = arrA.get(i);
                i++;
            } else{
                arr[k] = arrB.get(j);
                j++;
            }

            k++;
        }

        while( i < arrA.size()){
            arr[k] = arrA.get(i);
            i++;
            k++;
        }

        while( j < arrB.size()){
            arr[k] = arrB.get(j);
            j++;
            k++;
        }

        return arr;

    }
}