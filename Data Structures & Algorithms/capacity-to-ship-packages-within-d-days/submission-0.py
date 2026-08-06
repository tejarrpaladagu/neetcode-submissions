class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        l = max(weights)
        r = sum(weights)
        ans = r

        while l <= r:
            mid = (l + r) // 2

            curr = 0
            day = 1

            for weight in weights:
                if curr + weight > mid:
                    day += 1
                    curr = weight
                else:
                    curr += weight

            if day > days:
                l = mid + 1
            else:
                ans = min(ans, mid)
                r = mid - 1

        return ans

        