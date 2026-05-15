class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
        
        ans = ""
        for j in range(len(strs[0])):  # loop over characters in first word
            curr = strs[0][j]
            for i in range(1, len(strs)):
                if j >= len(strs[i]) or strs[i][j] != curr:
                    return ans
            ans += curr
        return ans
                
                

            

        