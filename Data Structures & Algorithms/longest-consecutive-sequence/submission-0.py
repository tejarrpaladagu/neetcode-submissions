class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        lookup = set(nums)
        start = []
        for num in nums:
            if num - 1 not in lookup:
                start.append(num)

        answer = 0
        for x in start:
            long = 0

            while x in lookup:
                long += 1
                answer = max(answer,long)
                x += 1
        return answer
        