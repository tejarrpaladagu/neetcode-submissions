class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        temp = [1] * n   # initialize with 1s

        prefix = 1
        for i in range(n):
            temp[i] = prefix
            prefix *= nums[i]

        postfix = 1
        for j in range(n-1, -1, -1):
            temp[j] *= postfix
            postfix *= nums[j]

        return temp

        
        

        

