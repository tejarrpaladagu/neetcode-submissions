class Solution:
    def canJump(self, nums: List[int]) -> bool:
        mx_reach = 0
        for i in range(len(nums)):
            mx_reach = max(mx_reach,nums[i]+i)
            if mx_reach <= i and i != len(nums)-1:
                return False
        return True
        