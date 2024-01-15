from typing import List


class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])

        def dfs(source):
            count = 1
            grid[source[0]][source[1]] = 2
            s = [source]
            while s:
                tail = s.pop()
                for l, k in [(tail[0] - 1, tail[1]), (tail[0] + 1, tail[1]), (tail[0], tail[1] - 1),
                             (tail[0], tail[1] + 1)]:
                    if 0 <= l < m and 0 <= k < n and grid[l][k] == 1:
                        count += 1
                        grid[l][k] = 2
                        s.append((l, k))
            return count

        area = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    area = max(area, dfs((i, j)))
        return area
