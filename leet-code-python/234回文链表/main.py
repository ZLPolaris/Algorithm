from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        nums = []
        p = head
        while p:
            nums.append(p.val)
            p = p.next
            pass
        left = 0
        right = len(nums) - 1
        while left < right:
            if nums[left] == nums[right]:
                left += 1
                right -= 1
                pass
            else:
                return False
            pass
        return True
