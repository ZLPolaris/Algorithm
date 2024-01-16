from typing import List


class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        n = len(rooms)
        visited = [False] * n
        q = [0]
        visited[0] = True
        count = 0
        while q:
            cur = q.pop(0)
            count += 1
            for i in rooms[cur]:
                if not visited[i]:
                    visited[i] = True
                    q.append(i)
                    pass
                pass
            pass
        return count == n
