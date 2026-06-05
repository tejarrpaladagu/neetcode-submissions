class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        result = []
        nums.sort()

        for i in range(len(nums)):
            # 1. Skip duplicate values for the first number
            if i > 0 and nums[i] == nums[i-1]:
                continue

            # FIX 1: Shifted indentation out of the 'if' block
            l = i + 1
            r = len(nums) - 1
            
            while l < r:
                curr = nums[i] + nums[l] + nums[r]
                
                if curr > 0:
                    r -= 1
                elif curr < 0:
                    l += 1
                else:
                    result.append([nums[i], nums[l], nums[r]])
                    
                    # FIX 2: Skip duplicates for 'l' pointer
                    while l < r and nums[l] == nums[l+1]:
                        l += 1

                    # FIX 4: Must physically move pointers inwards after finding a match
                    l += 1
                    r -= 1
                   
                        
                    

        return result


                
        