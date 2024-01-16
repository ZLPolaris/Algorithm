from typing import List


class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        n = len(s)
        res = [0] * n
        left = -n
        i = 0
        while i < n:
            while i < n and s[i] != c:
                res[i] = i - left
                i += 1
                pass
            right = i
            if right < n:
                mid = left + (right - left) / 2
                j = right - 1
                while j > mid and j>=0:
                    res[j] = right - j
                    j -= 1
                    pass
                pass
            left = right
            i = left + 1
            pass
        return res
    pass


s = Solution()
print(s.shortestToChar("loveleetcode", "e"))
