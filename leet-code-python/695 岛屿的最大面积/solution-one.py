from typing import List


class UnionFind:
    def __init__(self):
        self.root = {}
        self.size = {}
        self.max_size = 0

    def find(self, node):
        father = self.root[node]
        if node != father and father != self.root[father]:
            self.size[father] -= 1
            self.root[node] = self.find(father)
        return self.root[node]

    def union(self, node1, node2):
        if node1 not in self.root or node2 not in self.root:
            return
        f1 = self.find(node1)
        f2 = self.find(node2)
        if f1 == f2:
            return
        s1 = self.size[f1]
        s2 = self.size[f2]
        sums = s1 + s2
        if s1 >= s2:
            self.root[f2] = f1
            self.size[f1] = sums
        else:
            self.root[f1] = f2
            self.size[f2] = sums
        if sums > self.max_size:
            self.max_size = sums
            pass

    def add(self, node):
        self.root[node] = node
        self.size[node] = 1
        if self.max_size == 0:
            self.max_size = 1


class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        uf = UnionFind()
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    uf.add(i * n + j)
                    if j > 0:
                        uf.union(i * n + j, i * n + j - 1)
                    if i > 0:
                        uf.union(i * n + j, (i - 1) * n + j)

        return uf.max_size
