class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        int l = 0;
        // FIX 1: Set 'r' to the last valid index (length - 1)
        int r = heights.length - 1; 

        while (l < r) {
            // FIX 2: Changed 'height' to 'heights' to match the method parameter
            int curr = (r - l) * Math.min(heights[l], heights[r]);
            result = Math.max(result, curr);
            
            if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }
        return result;
    }
}
