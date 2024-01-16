# class Solution:
#     def countBinarySubstrings(self, s: str) -> int:
#         i = 0
#         j = 0
#         tmp = 0
#         n = len(s)
#         res = 0
#         while i < n:
#             while j < n and s[j] == s[i]:
#                 j += 1
#                 pass
#             tmp = j
#             while j < n and j - tmp < tmp - i and s[j] != s[i]:
#                 j += 1
#                 pass
#             res += j - tmp
#             i = tmp
#         return res
class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        i = 0
        n = len(s)
        last = 0
        res = 0
        while i < n:
            tmp = s[i]
            count = 0
            while i < n and s[i] == tmp:
                i += 1
                count += 1
                pass
            res += min(last, count)
            last = count
            pass
        return res

