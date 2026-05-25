class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        hashmap = {}
        ans = []
        for interval in intervals:
                left,right = interval
                gap = right - left + 1
                curr = left
                while curr <= right:
                    if curr not in hashmap:
                        hashmap[curr] = gap

                    else:
                        hashmap[curr] = min(gap,hashmap[curr])

                    curr += 1

        for query in queries:
            if query in hashmap:
                ans.append(hashmap[query])

            else:
                ans.append(-1)

        return ans
            

                        