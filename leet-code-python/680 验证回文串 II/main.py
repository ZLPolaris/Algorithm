class Solution:
    remainNumber = 1

    def validPalindrome(self, s: str) -> bool:
        return self.isValidPalindrome(s, 0, len(s) - 1)
        pass

    def isValidPalindrome(self, s: str, left: int, right: int) -> bool:
        if left >= right:
            return True
        while left < right:
            if s[left] == s[right]:
                left += 1
                right -= 1
                pass
            elif self.remainNumber == 1:
                self.remainNumber = 0
                return self.isValidPalindrome(s, left + 1, right) or self.isValidPalindrome(s, left, right - 1)
            else:
                return False
            pass
        return True


s = Solution()
print(s.validPalindrome("abca"))
