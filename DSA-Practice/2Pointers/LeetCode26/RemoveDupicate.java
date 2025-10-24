class Solution {
    public int removeDuplicates(int[] arr) {

        int o=0;
        int k=1;
        int c=1;

        while(c<arr.length){
            if(arr[c] != arr[o]){
                o++;
                k++;
                arr[o]=arr[c];
            }
            c++;
        }
        return k;  
    }
}