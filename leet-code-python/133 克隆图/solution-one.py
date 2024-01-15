from typing import Optional


class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        visited = set()

        def BFS(node1: Optional['Node']) -> int:
            if node1 is None:
                return 0
            q = [node1]
            count = 1
            while q:
                ele = q.pop(0)
                visited.add(ele.val)
                if ele.val > count:
                    count = ele.val
                for neighbor in ele.neighbors:
                    if neighbor.val not in visited:
                        q.append(neighbor)
                        pass
                    pass
                pass
            return count

        number = BFS(node)

        if number == 0:
            return None

        nodeList = [Node(i + 1) for i in range(number)]
        visited = set()

        def DFS1(node1: Optional['Node']):
            if node1 is None:
                return
            s = [node1]
            while s:
                ele = s.pop()
                visited.add(ele.val)
                nodeList[ele.val - 1].neighbors = []
                print(ele.val)
                for neighbor in ele.neighbors:
                    print("-----")
                    print(neighbor.val)
                    nodeList[ele.val - 1].neighbors.append(nodeList[neighbor.val - 1])
                    if neighbor.val not in visited:
                        s.append(neighbor)
                        pass
                    pass
                pass
            pass

        DFS1(node)
        return nodeList[0]
        pass
