class Solution:
    def reverseOnlyLetters(self, s: str) -> str:
        n = len(s)
        left = 0
        right = n - 1
        chars = list(s)
        while left < right:
            while left < right and not chars[left].isalpha():
                left += 1
                pass
            while left < right and not chars[right].isalpha():
                right -= 1
                pass
            if left < right:
                chars[left], chars[right] = chars[right], chars[left]
                left += 1
                right -= 1
                pass
            pass
        return "".join(chars)

