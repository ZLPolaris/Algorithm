from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])

        def dfs(l, k):
            grid[l][k] = "2"
            if l > 0:
                if grid[l - 1][k] == "1":
                    dfs(l - 1, k)
            if l < m - 1:
                if grid[l + 1][k] == "1":
                    dfs(l + 1, k)
            if k > 0:
                if grid[l][k - 1] == "1":
                    dfs(l, k - 1)
            if k < n - 1:
                if grid[l][k + 1] == "1":
                    dfs(l, k + 1)

        ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    dfs(i, j)
                    ans += 1
        return ans
