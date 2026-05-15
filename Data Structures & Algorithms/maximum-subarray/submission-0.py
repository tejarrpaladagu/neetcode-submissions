class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        import math
        max_sm = nums[0] 
        max_end = -1*math.inf
        for ele in nums:
            max_end = max(max_end+ele,ele)
            max_sm = max(max_sm,max_end)
        return max_sm


        