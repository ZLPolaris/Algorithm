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

        s1 = self.size[f1]
        s2 = self.size[f2]
        if s1 >= s2:
            self.root[f2] = f1
            self.size[f1] = s1 + s2
        else:
            self.root[f1] = f2
            self.size[f2] = s1 + s2

    def isSame(self, node1, node2):
        return self.find(node1) == self.find(node2)


class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        point_number = len(points)
        edges = []
        for i in range(point_number):
            for j in range(i + 1, point_number):
                edges.append((i, j, abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1])))
        edges.sort(key=lambda x: x[2])
        uf = UnionFind(point_number)
        all_distance = 0
        for edge in edges:
            if not uf.isSame(edge[0], edge[1]):
                uf.union(edge[0], edge[1])
                all_distance += edge[2]
        return all_distance
