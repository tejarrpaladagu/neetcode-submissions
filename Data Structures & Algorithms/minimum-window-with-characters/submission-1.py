from collections import Counter

class Solution:
    def minWindow(self, s: str, t: str) -> str:

        temp = [0] * 128
        ref = Counter(t)

        need = len(t)
        have = 0

        l = 0

        ans = float("inf")
        output = ""

        for r in range(len(s)):

            ch = s[r]

            if ch in ref:

                idx = ord(ch)

                # count useful chars only
                if temp[idx] < ref[ch]:
                    have += 1

                temp[idx] += 1

            # valid window
            while have == need:

                # update answer
                if (r - l + 1) < ans:
                    ans = r - l + 1
                    output = s[l:r+1]

                # remove left char
                left = s[l]

                if left in ref:

                    temp[ord(left)] -= 1

                    # window becomes invalid
                    if temp[ord(left)] < ref[left]:
                        have -= 1

                l += 1

        return output