from typing import List


class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        first = 0
        second = 0
        m = len(g)
        n = len(s)
        while first < m and second < n:
            if g[first] <= s[second]:
                first += 1
                pass
            second += 1
            pass
        return first
