from typing import List


class UnionFind:
    def __init__(self, n):
        self.root = [i for i in range(n)]
        self.size = [1] * n
        self.count = n

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
        self.count -= 1
        s1 = self.size[f1]
        s2 = self.size[f2]
        if s1 >= s2:
            self.root[f2] = f1
            self.size[f1] = s1 + s2
        else:
            self.root[f1] = f2
            self.size[f2] = s1 + s2


class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        n = len(strs)
        uf = UnionFind(n)
        for i in range(n):
            for j in range(i, n):
                if self.sameStr(strs[i], strs[j]):
                    uf.union(i, j)
        return uf.count

    def sameStr(self, str1, str2):
        m = len(str1)
        count = 0
        for i in range(m):
            if str1[i] != str2[i]:
                count += 1
        return count <= 2
