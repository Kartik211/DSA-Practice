class Solution {
    public int removeDuplicates(int[] arr) {

        int o=2;
        int c=2;

        while(c<arr.length){
            if(arr[c] !=arr[o-2]){
                arr[o]=arr[c];
                o++;
            }
            c++;
        }
        return o;   
    }
}