

class Solution {
    public int longestConsecutive(int[] nums) {
        // Fix 1: Base case to prevent issues with empty inputs
        if (nums == null || nums.length == 0) return 0;

        // Fix 2: Corrected capitalization to 'HashSet'
        // For primitive int[], we manually add elements to box them correctly
        Set<Integer> lookup = new HashSet<>();
        for (int num : nums) {
            lookup.add(num);
        }

        // Fix 3: Initialized local variable 'result' to 0
        int result = 0; 
        
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int output = 1;
            
            // Fix 4: Check for the NEXT consecutive number (curr + 1)
            // This prevents an infinite loop and accurately tracks the streak length
            while (lookup.contains(curr + 1)) {
                output++;
                result = Math.max(result, output);
                curr++;
            }
            
            // Handle single-element sequences if the while loop never runs
            result = Math.max(result, output);
        }
        return result;
    }
}
