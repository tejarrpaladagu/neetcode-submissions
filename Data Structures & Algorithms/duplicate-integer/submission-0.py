class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        hashmap = {}
        for i in range(0,len(nums)):
             if nums[i] in hashmap:
                return True
             hashmap[nums[i]] = 1
        return False
        