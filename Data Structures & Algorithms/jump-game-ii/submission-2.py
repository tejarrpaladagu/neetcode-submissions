class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums)<=1:
            return 0
        i = 0
        windowrange = maxr = 0+nums[i]
        jumps_needed = 1 
        while i<=windowrange and windowrange<len(nums)-1:
            maxr = max(nums[i]+i,maxr)
            if i == windowrange:
                windowrange = maxr
                jumps_needed += 1
            i += 1
            
        return jumps_needed
            

        