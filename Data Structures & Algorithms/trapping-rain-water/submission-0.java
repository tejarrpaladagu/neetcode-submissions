class Solution {
    public int trap(int[] height) {
        int total = 0;
        int maxL = height[0];
        int maxR = height[height.length - 1];
        int l = 0;
        int r = height.length - 1;

        while(l<r){
            if(maxL < maxR){
                l++;
                maxL = Math.max(maxL,height[l]);
                total += maxL - height[l];
            }
            else{
                r--;
                maxR = Math.max(maxR,height[r]);
                total += maxR - height[r];
            }

        }

        return total;

        
    }
}
