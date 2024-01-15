class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        i = 0
        n = len(word)
        while i < n and word[i] != ch:
            i += 1
            pass
        if i >= n:
            return word
        chars = list(word[0: i + 1])
        left = 0
        right = i
        while left < right:
            chars[left], chars[right] = chars[right], chars[left]
            left += 1
            right -= 1
            pass
        res = "".join(chars)
        res += word[i + 1: n]
        return res
