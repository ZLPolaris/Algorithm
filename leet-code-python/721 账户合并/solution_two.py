import collections
from typing import List


class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))

    def union(self, index1: int, index2: int):
        self.parent[self.find(index2)] = self.find(index1)

    def find(self, index: int) -> int:
        if self.parent[index] != index:
            self.parent[index] = self.find(self.parent[index])
        return self.parent[index]


class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        emailToIndex = {}
        emailToName = {}
        for account in accounts:
            name = account[0]
            for mail in account[1:]:
                if mail not in emailToIndex:
                    emailToIndex[mail] = len(emailToIndex)
                    emailToName[mail] = name
        uf = UnionFind(len(emailToIndex))
        for account in accounts:
            first = emailToIndex[account[1]]
            for mail in account[2:]:
                uf.union(first, emailToIndex[mail])
        indexToEmail = collections.defaultdict(list)
        for email, index in emailToIndex.items():
            root = uf.find(index)
            indexToEmail[root].append(email)
        ans = []
        for mail_set in indexToEmail.values():
            ans.append([emailToName[mail_set[0]]] + sorted(mail_set))
        return ans
