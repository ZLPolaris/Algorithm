# 并查集解决二分图
from typing import List


class UnionFind:

    def __init__(self, n):
        self.root = [i for i in range(n)]
        self.size = [1] * n
        pass

    def find(self, node):
        father = self.root[node]
        if node != father and father != self.root[father]:
            self.size[father] -= 1
            self.root[node] = self.find(father)
        return self.root[node]

    def union(self, node1, node2):
        f1 = self.find(node1)
        f2 = self.find(node2)
        if f1 == f2:
            return
        s1 = self.size[f1]
        s2 = self.size[f2]
        if s1 >= s2:
            self.root[f2] = f1
            self.size[f1] = s1 + s2
        else:
            self.root[f1] = f2
            self.size[f2] = s1 + s2

    def inOneSet(self, node1, node2):
        return self.find(node1) == self.find(node2)


class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        n = len(graph)
        uf = UnionFind(n)
        for adj in graph:
            for i in range(1, len(adj)):
                uf.union(adj[0], adj[i])
        for i in range(n):
            if len(graph[i]) > 0 and uf.find(i) == uf.find(graph[i][0]):
                return False
        return True
