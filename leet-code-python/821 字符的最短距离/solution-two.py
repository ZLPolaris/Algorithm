from typing import List


class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        n = len(s)
        left = -n
        i = 0
        res = [0] * n
        while i < n:
            if s[i] != c:
                res[i] = i - left
                pass
            else:
                res[i] = 0
                left = i
            i += 1
            pass
        right = 2 * n
        i = n - 1
        while i >= 0:
            if s[i] != c:
                res[i] = min(right - i, res[i])
                pass
            else:
                right = i
                pass
            i -= 1
            pass
        return res

    pass


s = Solution()
print(s.shortestToChar("loveleetcode", "e"))
