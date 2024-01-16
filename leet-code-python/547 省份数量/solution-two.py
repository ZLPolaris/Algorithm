from typing import List


class UnionFind:
    parent = {}
    size = {}
    count = 0

    def __init__(self, datas=None):
        if datas is None:
            datas = []
        for data in datas:
            self.parent[data] = data
            self.size[data] = 1
        self.count += len(datas)

    def find(self, node):
        if node not in self.parent:
            return None
        father = self.parent[node]
        if node != father and father != self.parent[father]:
            self.size[father] -= 1
            self.parent[node] = self.find(father)
        return self.parent[node]

    def union(self, node1, node2):
        if node1 not in self.parent or node2 not in self.parent:
            return
        f1 = self.find(node1)
        f2 = self.find(node2)
        if f1 == f2:
            return
        s1 = self.size[f1]
        s2 = self.size[f2]
        if s1 >= s2:
            self.parent[f2] = f1
            self.size[f1] = s1 + s2
        else:
            self.parent[f1] = f2
            self.size[f2] = s1 + s2
        self.count -= 1

    def getCount(self):
        return self.count


class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        uf = UnionFind(range(n))
        for i in range(n):
            for j in range(n):
                if isConnected[i][j] == 1:
                    uf.union(i, j)
        return uf.getCount()
