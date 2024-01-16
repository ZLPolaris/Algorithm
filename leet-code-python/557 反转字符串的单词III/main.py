class Solution:
    def reverseWords(self, s: str) -> str:
        res = ""
        j = 0
        n = len(s)
        while j < n:
            start = j
            while j < n and s[j] != " ":
                j += 1
                pass
            print(j)
            for i in range(j - 1, start - 1, -1):
                res += s[i]
                pass
            if j < n:
                res += " "
            j += 1
            pass
        return res
    pass


s = Solution()
print(s.reverseWords("Let's take LeetCode contest"))
