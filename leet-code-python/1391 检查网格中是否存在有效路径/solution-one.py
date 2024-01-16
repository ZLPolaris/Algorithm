from typing import List


class UnionFind:
    def __init__(self, n):
        self.root = [i for i in range(n)]
        self.size = [1] * n

    def find(self, node):
        father = self.root[node]
        if father != node and self.root[father] != father:
            self.size[father] -= 1
            self.root[node] = self.find(father)
        return self.root[node]

    def union(self, node1, node2):
        father1 = self.root[node1]
        father2 = self.root[node2]
        if father1 == father2:
            return
        s1 = self.size[node1]
        s2 = self.size[node2]
        if s1 >= s2:
            self.root[father2] = father1
            self.size[father1] = s1 + s2
        else:
            self.root[father1] = father2
            self.size[father2] = s1 + s2


class Solution:
    def hasValidPath(self, grid: List[List[int]]) -> bool:
        m = len(grid)
        n = len(grid[0])
        uf = UnionFind(m * n)
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1 or grid[i][j] == 4 or grid[i][j] == 6:
                    if j < n - 1 and (grid[i][j + 1] == 3 or grid[i][j + 1] == 5 or grid[i][j + 1] == 1):
                        uf.union(i * n + j, i * n + j + 1)
                if grid[i][j] == 2 or grid[i][j] == 4 or grid[i][j] == grid[i][j] == 3:
                    if i < m - 1 and (grid[i + 1][j] == 2 or grid[i + 1][j] == 5 or grid[i + 1][j] == 6):
                        uf.union(i * n + j, i * n + j + n)
        return uf.find(m * n - 1) == uf.find(0)
