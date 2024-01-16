class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        m = len(s)
        n = len(t)
        first = m - 1
        second = n - 1
        while first >= 0 or second >= 0:
            first = self.getCompareIndex(s, first)
            second = self.getCompareIndex(t, second)
            print(first, second)
            if first >= 0 and second >= 0:
                if s[first] != t[second]:
                    return False
                else:
                    first -= 1
                    second -= 1
                pass
            elif first >= 0 or  second>=0:
                return False
            pass
        return second < 0 and first < 0
        pass

    def getCompareIndex(self, s: str, i: int) -> int:
        count = 0
        while i >= 0 and (s[i] == "#" or count > 0):
            if s[i] == "#":
                count += 1
                pass
            else:
                count -= 1
                pass
            i -= 1
            pass
        return i
