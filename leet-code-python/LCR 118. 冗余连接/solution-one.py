from typing import List


class UnionFind:
    def __init__(self):
        self.root = {}
        self.size = {}

    def add(self, node):
        if node not in self.root:
            self.root[node] = node
            self.size[node] = 1

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
        s1 = self.size[f1]
        s2 = self.size[f2]
        if s1 >= s2:
            self.root[f2] = f1
            self.size[f1] = s1 + s2
        else:
            self.root[f1] = f2
            self.size[f2] = s1 + s2
        return True


class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        uf = UnionFind()
        for edge in edges:
            if not uf.union(edge[0], edge[1]):
                return edge
