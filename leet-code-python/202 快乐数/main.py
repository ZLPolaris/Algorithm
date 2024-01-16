class Solution:
    def isHappy(self, n: int) -> bool:
        quick = self.getNext(n)
        slow = n
        while quick != 1 and quick != slow:
            quick = self.getNext(self.getNext(quick))
            slow = self.getNext(slow)
            pass
        return quick == 1

    def getNext(self, n):
        add = 0
        while n >= 10:
            add += (n % 10) ** 2
            n //= 10
            pass
        add += n ** 2
        return add


s = Solution()
print(s.isHappy(19))
