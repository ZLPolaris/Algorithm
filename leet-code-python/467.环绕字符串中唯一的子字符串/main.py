class Solution:
    def findSubstringInWraproundString(self, s: str) -> int:
        n = len(s)
        is_show = [[False for i in range(0, 26)] for i in range(0, 26)]
        count = 1
        is_show[ord(s[0]) - 97][ord(s[0]) - 97] = True
        start = 1
        for i in range(1, n):
            if (ord(s[i]) - ord(s[i - 1]) + 26) % 26 == 1:
                start += 1
                pass
            else:
                start = 1
                pass
            for j in range(0, start):
                if not is_show[ord(s[i - j]) - 97][ord(s[i]) - 97]:
                    is_show[ord(s[i - j]) - 97][ord(s[i]) - 97] = True
                    count += 1
                    pass
                pass
            pass
        return count



