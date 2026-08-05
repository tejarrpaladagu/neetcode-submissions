class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l = 1
        r = max(piles)
        ans = r

        while(l <= r):
            mid = (l+r)//2
            curr = 0

            for pile in piles:
                curr += math.ceil(pile/mid)

            

            if curr <= h:
                ans = min(ans,mid)
                r = mid - 1

            else:
                l = mid + 1

        return ans

        