class Solution:

    def reverseVowels(self, s: str) -> str:
        res = list(s)
        left = 0
        n = len(s)
        right = n - 1
        while left < right:
            while not self.isVowel(res[left]) and left < right:
                left += 1
                pass
            while not self.isVowel(res[right]) and left < right:
                right -= 1
                pass
            if left < right:
                res[left], res[right] = res[right], res[left]
                left += 1
                right -= 1
                pass
            pass
        return "".join(res)
        pass

    def isVowel(self, s: str) -> bool:
        return s in "aeiouAEIOU"
    pass


solution = Solution()
print(solution.reverseVowels("leetcode"))
