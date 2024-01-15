import collections
from typing import List


class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        remain_board = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if board[i][j] == "X":
                    remain_board[i][j] = 2

        def bfs(source):
            q = collections.deque()
            remain_board[source[0]][source[1]] = 1
            q.append(source)
            while q:
                l, k = q.popleft()
                print(l,k)
                if l > 0 and remain_board[l - 1][k] == 0:
                    q.append((l - 1, k))
                    remain_board[l - 1][k] = 1
                if l < m - 1 and remain_board[l + 1][k] == 0:
                    q.append((l + 1, k))
                    remain_board[l + 1][k] = 1
                if k > 0 and remain_board[l][k - 1] == 0:
                    q.append((l, k - 1))
                    remain_board[l][k - 1] = 1
                if k < n - 1 and remain_board[l][k + 1] == 0:
                    q.append((l, k + 1))
                    remain_board[l][k + 1] = 1

        for i in range(m):
            for j in range(n):
                if remain_board[i][j] == 0 and (i == 0 or i == m - 1 or j == 0 or j == n - 1):
                    bfs((i, j))
        print(remain_board)
        for i in range(m):
            for j in range(n):
                if remain_board[i][j] == 0:
                    board[i][j] = "X"
