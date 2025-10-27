class Solution {
    long countTriplets(int n, int sum, long arr[]) {
        
        Arrays.sort(arr);
        n=arr.length;
        long res = 0;
        
        for(int i=0;i<n-2;i++){
            int left=i+1;
            int right=n-1;
            
            while(left<right){
                long s=arr[i]+arr[left]+arr[right];
                if(s>=sum){
                    right--;
                }
                else{
                    res=res+(right-left);
                    left++;
                }
            }
        }
        return res;
    }
}