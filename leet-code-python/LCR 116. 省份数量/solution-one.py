from typing import List


# 使用dfs
class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        colors = [0] * n

        def dfs(u):
            colors[u] = 1
            for i in range(n):
                if isConnected[u][i] and colors[i] == 0:
                    dfs(i)
        res = 0
        for i in range(n):
            if colors[i] == 0:
                dfs(i)
                res += 1

        return res