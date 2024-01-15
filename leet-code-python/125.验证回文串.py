class Solution:
    def isPalindrome(self, s: str) -> bool:
        n = len(s)
        left = 0
        right = n - 1
        while left < right:
            if not s[left].isalpha() and not s[left].isdigit():
                left += 1
                continue
                pass
            if not s[right].isalpha() and not s[right].isdigit():
                right -= 1
                continue
                pass
            if s[left] == s[right] or (
                    s[left].isalpha() and s[right].isalpha() and abs(ord(s[left]) - ord(s[right])) == 32):
                left += 1
                right -= 1
                pass
            else:
                return False
            pass
        return True


s = Solution()
print(s.isPalindrome("0P"))
