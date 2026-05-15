class Solution {
    public int[] getConcatenation(int[] nums) {
        
        int i = 0;
        int r = nums.length;
        int [] ans = new int[2*r];
        while(i< r){
            ans[i] = nums[i];
            ans[i+r] = nums[i];
             i += 1;
        }
        return ans;
        
        
    }
}