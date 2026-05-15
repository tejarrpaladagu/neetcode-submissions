class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        out = []
        def helper(i,partial):
            if i == len(nums):
                out.append(list(partial))
                return
            else:
                num = nums[i]
                partial.append(num)
                helper(i+1,partial)
                partial.pop()
                helper(i+1,partial)
        helper(0,[])
        return out
        