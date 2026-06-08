class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while(fast != slow){
            slow = nums[slow];
            fast = nums[nums[fast]];

        }

        int slow1 = 0;

        while (slow!=slow1){
            slow = nums[slow];
            slow1 = nums[slow1];
        }

        return slow;
        
    }
}
