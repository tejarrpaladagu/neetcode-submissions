class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        lookup = set()
        ans = 0
        def dfs(r,c,curr):
            if r < 0 or r >= len(grid) or c < 0 or c >= len(grid[0]) or (r,c) in lookup:
                return curr

            if grid[r][c] == 0:
                return curr

            lookup.add((r,c))

            curr = curr+1

            curr = dfs(r+1,c,curr)
            curr = dfs(r-1,c,curr)
            curr = dfs(r,c+1,curr)
            curr = dfs(r,c-1,curr)

            return curr

            

        for i in range(0,len(grid)):
            for j in range(0,len(grid[0])):
                if grid[i][j] == 1 and (i,j) not in lookup:
                    a = dfs(i,j,0)
                    ans = max(ans,a)

        return ans
        