from typing import List


class UnionFind:
    def __init__(self, n):
        self.root = [i for i in range(n)]
        self.size = [1] * n
        self.count = 0

    def find(self, node):
        father = self.root[node]
        if father != node and father != self.root[father]:
            self.size[father] -= 1
            self.root[node] = self.find(father)
        return self.root[node]

    def union(self, node1, node2):
        f1 = self.find(node1)
        f2 = self.find(node2)
        if f1 == f2:
            return
        self.count += 1
        s1 = self.size[f1]
        s2 = self.size[f2]
        if s1 >= s2:
            self.root[f2] = f1
            self.size[f1] = s1 + s2
        else:
            self.root[f1] = f2
            self.size[f2] = s1 + s2


class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        n = len(row) // 2
        uf = UnionFind(n)
        for i in range(n):
            uf.union(row[2 * i] // 2, row[2 * i + 1] // 2)
        return uf.count



