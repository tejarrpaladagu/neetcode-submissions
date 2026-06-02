//import java.util.HashSet;

class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer>lookup = new HashSet<>();
        for(int num:nums){
            if (lookup.contains(num)){
                return true;
            }
            else{
                lookup.add(num);
            }
        }
        return false;

    }
}