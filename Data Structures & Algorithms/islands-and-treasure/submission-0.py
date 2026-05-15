from collections import deque
from typing import List

class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        r = len(grid)
        c = len(grid[0])
        visit = set()
        q = deque()
        
        # Helper function should be defined before it's used
        def addcell(a, b):
            if a < 0 or b < 0 or a == r or b == c or (a, b) in visit or grid[a][b] == -1:
                return
            visit.add((a, b))
            q.append([a, b])
        
        # Initialize BFS with all treasure chests (0s)
        for i in range(r):
            for j in range(c):
                if grid[i][j] == 0:
                    q.append([i, j])
                    visit.add((i, j))  # Fixed: should be (i,j) not (r,c)
        
        dist = 0
        while q:
            for _ in range(len(q)):
                a, b = q.popleft()
                grid[a][b] = dist
                addcell(a + 1, b)
                addcell(a - 1, b)
                addcell(a, b + 1)
                addcell(a, b - 1)
            dist += 1