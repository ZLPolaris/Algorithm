from typing import List


class UnionFind:

    def __init__(self):
        self.root = {}
        self.size = {}

    def find(self, node):
        father = self.root[node]
        if node != father and father != self.root[father]:
            self.size[father] -= 1
            self.root[node] = self.find(father)
        return self.root[node]

    def union(self, node1, node2):
        self.add(node1)
        self.add(node2)
        f1 = self.find(node1)
        f2 = self.find(node2)
        if f1 == f2:
            return False
        s1 = self.size[node1]
        s2 = self.size[node2]
        if s1 >= s2:
            self.root[f2] = f1
            self.size[f1] = s1 + s2
        else:
            self.root[f1] = f2
            self.size[f2] = s1 + s2
        return True

    def add(self, node):
        if node not in self.root:
            self.root[node] = node
            self.size[node] = 1


class Solution:
    def containsCycle(self, grid: List[List[str]]) -> bool:
        m = len(grid)
        n = len(grid[0])
        uf = UnionFind()
        for i in range(m):
            for j in range(n - 1):
                if grid[i][j] == grid[i][j + 1]:
                    if not uf.union(i * n + j, i * n + j + 1):
                        return True
        for i in range(m - 1):
            for j in range(n):
                if grid[i][j] == grid[i + 1][j]:
                    if not uf.union(i * n + j, i * n + j + n):
                        return True
        return False
