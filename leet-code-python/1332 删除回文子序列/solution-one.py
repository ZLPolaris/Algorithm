class Solution:
    def removePalindromeSub(self, s: str) -> int:
        n = len(s)
        left = 0
        right = n - 1
        while left < right:
            if s[left] != s[right]:
                return 2
            left += 1
            right -= 1
            pass
        return 1
