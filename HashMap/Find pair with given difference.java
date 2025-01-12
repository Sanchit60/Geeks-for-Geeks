class Solution {
    public boolean findPair(int[] arr, int x) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        for(int  i = 0; i < arr.length; i++){
            int j1 = arr[i] - x;
            int j2 = x + arr[i];
            if(set.contains(j1) || set.contains(j2)){
                return true;
            }
            set.add(arr[i]);
            
        }
        return false;
    }
}
