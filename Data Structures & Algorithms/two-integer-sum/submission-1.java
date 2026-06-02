//import java.util.HashMap;
//import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapper = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (mapper.containsKey(complement)) {
                return new int[]{mapper.get(complement), i};
            }
            mapper.put(nums[i], i);
        }
        return new int[]{}; // if no solution is found
    }
}

