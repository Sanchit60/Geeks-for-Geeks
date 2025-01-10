class Solution {
    
    public static int findPages(int[] arr, int k){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        int lo = 0;
        int hi = sum;
        int ans = Integer.MAX_VALUE;
        if(k > arr.length){
            return -1;
        }
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(allocatePages(arr, k, mid) == true){
                ans = Math.min(ans, mid);
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;

        
    }
    
    public static boolean allocatePages(int[] arr, int k, int maxAllowedPages){
        int currStudent = 1;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > maxAllowedPages){
                return false;
            }
            if(sum + arr[i] <= maxAllowedPages){
                sum += arr[i];
            }else{
                currStudent++;
                sum = arr[i];
            }
        }
        return currStudent <= k;
                
    
    }
}
