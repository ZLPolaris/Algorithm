class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        m = len(word1)
        n = len(word2)
        first = 0
        second = 0
        res = []
        while first < m and second < n:
            res.append(word1[first])
            res.append(word2[second])
            first += 1
            second += 1
            pass
        result = "".join(res)
        result += word1[first:m]
        result += word2[second:n]
        return result

    pass


s = Solution()
print(s.mergeAlternately("ab", "pqrs"))
