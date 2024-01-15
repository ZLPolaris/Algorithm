from typing import List
from queue import PriorityQueue


class UnionFind:

    def __init__(self, datas):
        if datas is None:
            datas = []
        self.parent = {}
        self.size = {}
        self.root = set()
        for data in datas:
            self.parent[data] = data
            self.size[data] = 1
            self.root.add(data)

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
            self.root.remove(f2)
        else:
            self.parent[f1] = f2
            self.size[f2] = s1 + s2
            self.root.remove(f1)
        return True

    def getRoot(self):
        return self.root


class Solution:
    def smallestStringWithSwaps(self, s: str, pairs: List[List[int]]) -> str:
        n = len(s)
        uf = UnionFind(range(n))
        for pair in pairs:
            uf.union(pair[0], pair[1])
        ans = ""
        pq = dict()
        for ele in uf.getRoot():
            pq[ele] = PriorityQueue()
        for i in range(n):
            f = uf.find(i)
            pq[f].put(s[i])
        for i in range(n):
            f = uf.find(i)
            ans += pq[f].get()

        return ans
