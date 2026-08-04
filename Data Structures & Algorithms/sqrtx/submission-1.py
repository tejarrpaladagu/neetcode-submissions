class Solution:
    def mySqrt(self, x: int) -> int:
        l = 0
        r = x

        while(l < r):
            mid = (l+r)//2
            if mid * mid > x:
                r = mid - 1

            elif mid * mid < x:
                if (mid + 1) * (mid+1) > x:
                    return mid
                l = mid + 1

            else:
                return mid

        return l


        