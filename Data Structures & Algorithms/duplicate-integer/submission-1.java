//import java.util.HashMap;

class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                return true;
            }
            hash.put(nums[i], true);
        }
        return false;
    }
}