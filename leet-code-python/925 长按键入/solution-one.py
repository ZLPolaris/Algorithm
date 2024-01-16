class Solution:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        m = len(name)
        n = len(typed)
        first = second = 0
        while first < m and second < n:
            if name[first] == typed[second]:
                first += 1
                second += 1
                pass
            elif first > 0 and typed[second] == name[first - 1]:
                second += 1
                pass
            else:
                return False
            pass

        if first < m:
            return False
        while second < n:
            if typed[second] == name[m - 1]:
                second += 1
                pass
            else:
                return False
            pass
        return True

