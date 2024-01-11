from typing import List


class Solution:
    def containsCycle(self, grid: List[List[str]]) -> bool:
        m = len(grid)
        n = len(grid[0])
        father = [[(-1, -1)] * n for _ in range(m)]

        def dfs(u):
            for k, l in [(u[0] - 1, u[1]), (u[0] + 1, u[1]), (u[0], u[1] - 1), (u[0], u[1] + 1)]:
                if 0 <= k < m and 0 <= l < n and grid[k][l] == grid[u[0]][u[1]]:
                    if father[k][l] == (-1, -1):
                        father[k][l] = u
                        if not dfs((k, l)):
                            return False
                    else:
                        if father[u[0]][u[1]] != (k, l):
                            return False
            return True

        for i in range(m):
            for j in range(n):
                if father[i][j] == (-1, -1):
                    father[i][j] = (i, j)
                    if not dfs((i, j)):
                        return True
        return False
        pass
