import collections
from typing import List


# 有问题 写的不行
class UnionFind:

    def __init__(self):
        self.root = {}
        self.message = {}
        pass

    def find(self, node):
        father = self.root[node]
        if father != node:
            self.root[node] = self.find(father)
        return self.root[node]

    def add(self, node):
        if node not in self.root:
            self.root[node] = node
            return None
        else:
            return self.find(node)

    def union(self, node1, node2):
        f1 = self.find(node1)
        f2 = self.find(node2)
        if f1 == f2:
            return
        self.root[f2] = f1
        pass

    def addMessage(self, node, name):
        self.message[node] = name


class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        uf = UnionFind()
        for account in accounts:
            name = account[0]
            father = uf.add(account[1])
            for i in range(2, len(account)):
                tmp = uf.add(account[i])
                if tmp is not None and tmp != account[1]:
                    father = tmp
                else:
                    uf.union(account[1], account[i])
            if father is None:
                uf.addMessage(account[1], name)
            else:
                uf.union(father, account[1])

        root_mail = uf.message
        mail_set = collections.defaultdict(list)
        for mail in uf.root:
            f = uf.find(mail)
            mail_set[f].append(mail)
        ans = []
        print(uf.root)
        for mail in mail_set:
            mail_set[mail].sort()
            mail_set[mail].insert(0, root_mail[mail])
            ans.append(mail_set[mail])
        return ans


s = Solution()
print(s.accountsMerge(
   [["David","David0@m.co","David1@m.co"],["David","David3@m.co","David4@m.co"],["David","David4@m.co","David5@m.co"],["David","David2@m.co","David3@m.co"],["David","David1@m.co","David2@m.co"]]))
