class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        
        int low = 0;
        int high = k - 1;
        
        int sum = 0;
        int res = Integer.MIN_VALUE;
        
        // Step 1: Calculate the sum of the first window of size k
        for (int i = low; i <= high; i++) {
            sum = sum + arr[i];
        }
        
        // Step 2: Slide the window
        while (high < n) {
            res = Math.max(res, sum);

            // Move the window forward
            low++;
            high++;

            if (high == n) { 
                break;
            }

            // Remove the element leaving the window and add the new one
            sum = sum - arr[low - 1];
            sum = sum + arr[high];
        }
        
        return res;
    }
}