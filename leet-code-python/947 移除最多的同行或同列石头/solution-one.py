from typing import List


#
class UnionFind:

    def __init__(self, datas=None):
        if datas is None:
            datas = []
        self.parent = {}
        self.size = {}
        self.count = 0
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
        self.count += 1
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
    def removeStones(self, stones: List[List[int]]) -> int:
        n = len(stones)
        uf = UnionFind(range(n))
        for index1, stone1 in enumerate(stones):
            for i in range(index1 + 1, n):
                if stone1[0] == stones[i][0] or stone1[1] == stones[i][1]:
                    uf.union(index1, i)
        return uf.count
