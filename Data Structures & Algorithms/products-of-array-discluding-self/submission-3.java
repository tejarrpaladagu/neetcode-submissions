class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        
        // 1. Left-to-Right Pass (Prefix)
        int prefix = 1; // Start with a base product of 1
        for (int i = 0; i < nums.length; i++) {
            output[i] = prefix;       // Store the product of everything to the left
            prefix = prefix * nums[i]; // Update prefix to include current number for the NEXT iteration
        }

        // 2. Right-to-Left Pass (Suffix)
        int suffix = 1; // Start with a base product of 1
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] = output[i] * suffix; // Multiply the existing prefix by the incoming suffix
            suffix = suffix * nums[i];      // Update suffix to include current number for the NEXT iteration
        }

        return output; // Return the correct array!
    }
}
