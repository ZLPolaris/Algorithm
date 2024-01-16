from typing import List


class UnionFind:

    def __init__(self):
        self.root = {}
        self.size = {}

    def find(self, node):
        if node in self.root:
            father = self.root[node]
            if node != father and father != self.root[father]:
                self.size[father] -= 1
                self.root[node] = self.find(father)
            return self.root[node]
        else:
            self.root[node] = node
            self.size[node] = 1

            return node

    def union(self, node1, node2):
        father1 = self.find(node1)
        father2 = self.find(node2)
        if father1 == father2:
            return
        s1 = self.size[father1]
        s2 = self.size[father2]
        if s1 >= s2:
            self.root[father2] = father1
            self.size[father1] = s1 + s2
        else:
            self.root[father1] = father2
            self.size[father2] = s1 + s2

    def getSingleNumber(self):
        ans = 0
        tmp = set()
        for data in self.root:
            f = self.find(data)
            if f not in tmp:
                if self.size[f] == 2:
                    ans += 1
                tmp.add(f)
        return ans


class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dot_number = 0
        uf = UnionFind()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    dot_number += 1
                    uf.union(~i, j)
        return dot_number - uf.getSingleNumber()