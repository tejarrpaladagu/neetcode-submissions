from typing import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0

        # Using a set of tuples instead of lists
        lookup = set()
        islands = 0
        
        def dfs(r, c):
            # 1. Corrected the bounds checking (>= instead of >)
            # 2. Corrected the column upper bound check (>= instead of <)
            if r < 0 or r >= len(grid) or c < 0 or c >= len(grid[0]) or (r, c) in lookup:
                return

            # 3. Changed grid indexing to grid[r][c] and checked for string "0"
            if grid[r][c] == "0":
                return

            # 4. Adding a tuple to the set
            lookup.add((r, c))
            
            # Explore all 4 directions
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                # 5. Matching string "1" and checking tuple in lookup
                if grid[i][j] == "1" and (i, j) not in lookup:
                    dfs(i, j)
                    islands += 1
                    
        return islands