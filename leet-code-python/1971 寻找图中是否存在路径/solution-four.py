from typing import List


class UnionFind:
    parent = {}
    size_set = {}

    def __init__(self, n):
        for i in range(n):
            self.parent[i] = i
            self.size_set[i] = 1

    def find(self, node):
        if node not in self.parent:
            return None
        if node != self.parent[node]:
            father = self.find(self.parent[node])
            if father != self.parent[node]:
                self.size_set[self.parent[node]] -= 1
                self.parent[node] = father
        return self.parent[node]

    def union(self, node1, node2):
        if node1 not in self.parent or node2 not in self.parent:
            return None
        f1 = self.find(node1)
        f2 = self.find(node2)
        if f1 == f2:
            return
        s1 = self.size_set[f1]
        s2 = self.size_set[f2]
        if s1 >= s2:
            self.parent[f2] = f1
            self.size_set[f1] = s1 + s2
        else:
            self.parent[f1] = f2
            self.size_set[f2] = s1 + s2


class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        uf = UnionFind(n)
        for edge in edges:
            uf.union(edge[0], edge[1])
        return uf.find(source) == uf.find(destination)
