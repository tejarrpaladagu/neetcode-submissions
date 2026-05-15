class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l = r = 0
        from collections import defaultdict
        windowCounts = defaultdict(int)
        curmax = 0
        while r< len(s):
            windowCounts[s[r]] += 1
            #windowMax = max(windowMax,windowCounts[r])
            most_freq_cnt = max((cnt,k) for k,cnt in windowCounts.items())[0]
            toreplace = (r-l+1) - most_freq_cnt
            if toreplace <= k:
                curmax = max(curmax,r-l+1)
                r += 1
            else:
                while l<=r and toreplace > k:
                    windowCounts[s[l]] -= 1
                    l += 1
                    most_freq_cnt = max((cnt,k) for k,cnt in windowCounts.items())[0]
                    toreplace = (r-l+1) - most_freq_cnt
                r += 1
        return curmax


            





        