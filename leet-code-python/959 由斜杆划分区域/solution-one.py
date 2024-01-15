from typing import List


class UnionFind:

    def __init__(self, datas=None):
        if datas is None:
            datas = []
        self.parent = {}
        self.size = {}
        for data in datas:
            self.parent[data] = data
            self.size[data] = 1

    def find(self, node):
        if node not in self.parent:
            return None
        direct_father = self.parent[node]
        if node != direct_father and direct_father != self.parent[direct_father]:
            self.size[direct_father] -= 1
            self.parent[node] = self.find(direct_father)
        return self.parent[node]

    def union(self, node1, node2):
        if node1 not in self.parent or node2 not in self.parent:
            return False
        f1 = self.find(node1)
        f2 = self.find(node2)
        if f1 == f2:
            return False
        s1 = self.size[f1]
        s2 = self.size[f2]
        if s1 >= s2:
            self.parent[f2] = f1
            self.size[f1] = s1 + s2
        else:
            self.parent[f1] = f2
            self.size[f2] = s1 + s2
        return True


class Solution:
    def regionsBySlashes(self, grid: List[str]) -> int:
        n = len(grid) + 1
        uf = UnionFind([i for i in range(n * n)])
        for i in range(1, n):
            uf.union(0, i)
        for i in range(1, n):
            uf.union(0, i * n)
        for i in range(1, n):
            uf.union(0, n * n - n + i)
        for i in range(1, n):
            uf.union(0, i * n + n - 1)
        count = 1
        for i in range(n - 1):
            for j in range(n - 1):
                print(grid[i][j])
                if grid[i][j] == "/":
                    if not uf.union(i * n + j + 1, (i + 1) * n + j):
                        count += 1
                elif grid[i][j] == "\\":
                    if not uf.union(i * n + j, (i + 1) * n + j + 1):
                        count += 1

        return count
