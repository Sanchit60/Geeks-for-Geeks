class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int lo = 0;
        int hi = stalls[stalls.length - 1];
        int ans = Integer.MIN_VALUE;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(cowsAdjust(stalls, k, mid) == true){
                ans = Math.max(ans, mid);
                lo = mid + 1;
            } else{
                hi = mid - 1;
            }
            
        }
        return ans;
      
    }
    
    public static boolean cowsAdjust(int[] stalls, int cows, int minDistance){
        int lastCowIdx = 0;
        int countCows = 1;
        for(int  i = 0; i < stalls.length; i++){
            int distance = stalls[i] - stalls[lastCowIdx];
            if(distance >= minDistance){
                countCows++;
                lastCowIdx = i;
            }
        }
        return countCows >= cows;
    } 
    
    
}
