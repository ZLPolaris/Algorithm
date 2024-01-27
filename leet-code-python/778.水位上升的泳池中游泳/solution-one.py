from typing import List


class UnionFind:
    def __init__(self, n):
        self.root = [i for i in range(n)]
        self.size = [1] * n

    def find(self, node):
        father = self.root[node]
        if father != node and father != self.root[father]:
            self.size[father] -= 1
            self.root[node] = self.find(father)
        return self.root[node]

    def union(self, node1, node2):
        f1 = self.find(node1)
        f2 = self.find(node2)
        s1 = self.size[f1]
        s2 = self.size[f2]
        if s1 >= s2:
            self.root[f2] = f1
            self.size[f1] = s1 + s2
        else:
            self.root[f1] = f2
            self.size[f2] = s1 + s2

    def isOneSet(self, node1, node2):
        return self.find(node2) == self.find(node1)


class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        edges = []
        n = len(grid)
        if n == 1:
            return grid[0][0]
        for i in range(n):
            for j in range(n):
                for u, v in [(i + 1, j), (i, j + 1), (i - 1, j), (i, j - 1)]:
                    if 0 <= u < n and 0 <= v < n:
                        edges.append((i * n + j, u * n + v, max(grid[i][j], grid[u][v])))
        uf = UnionFind(n * n)
        edges.sort(key=lambda x: x[2])
        for edge in edges:
            if not uf.isOneSet(edge[0], edge[1]):
                uf.union(edge[0], edge[1])
                if uf.isOneSet(0, n * n - 1):
                    return edge[2]
