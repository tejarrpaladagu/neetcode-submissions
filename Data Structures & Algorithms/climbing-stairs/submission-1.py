class Solution:
    def climbStairs(self, n: int) -> int:
        # The memo dictionary to cache results: { step: total_ways_from_here }
        memo = {}
        
        def ways(a):
            # 1. Base Cases
            if a > n:
                return 0
            if a == n:
                return 1

            # 2. Check the cache
            if a in memo:
                return memo[a]
                
            # 3. Core DP Relation: Sum up the choices, and save it to the memo
            memo[a] = ways(a + 1) + ways(a + 2)
            print(memo)
            
            # 4. Return the calculated result
            return memo[a]

        # Start from step 0
        return ways(0)
    


