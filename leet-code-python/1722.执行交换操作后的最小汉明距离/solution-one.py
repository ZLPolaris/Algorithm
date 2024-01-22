import collections
from typing import List


class UnionFind:
    def __init__(self, n):
        self.root = [i for i in range(n)]
        self.size = [1] * n

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


class Solution:
    def minimumHammingDistance(self, source: List[int], target: List[int], allowedSwaps: List[List[int]]) -> int:
        n = len(source)
        used = [False] * n
        data_map = collections.defaultdict(list)
        for key, value in enumerate(source):
            data_map[value].append(key)
        uf = UnionFind(n)
        for swap in allowedSwaps:
            uf.union(swap[0], swap[1])
        distance = n
        for index, value in enumerate(target):
            for j in data_map[value]:
                if not used[j] and uf.find(j) == uf.find(index):
                    used[j] = True
                    distance -= 1
                    break
        return distance
