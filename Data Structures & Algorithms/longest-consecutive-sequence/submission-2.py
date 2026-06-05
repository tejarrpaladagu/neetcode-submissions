class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        lookup = set(nums)
        tracker = 1

        result = 0
        for i in range(len(nums)):
            curr = nums[i]
            tracker = 0
            while(curr in lookup):
                tracker += 1
                curr += 1
                result = max(result,tracker)

        return result
        
        
