from typing import List


class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        remain_board = [[0] * n for _ in range(m)]

        def dfs(l, s):
            if remain_board[l][s] != 0:
                return
            remain_board[l][s] = 1
            if l > 0:
                dfs(l - 1, s)
            if l < m - 1:
                dfs(l + 1, s)
            if s > 0:
                dfs(l, s - 1)
            if s < n - 1:
                dfs(l, s + 1)

            pass

        for i in range(m):
            for j in range(n):
                if board[i][j] == "X":
                    remain_board[i][j] = 2
        for i in range(m):
            for j in range(n):
                if remain_board[i][j] == 0 and (i == 0 or i == m - 1 or j == 0 or j == n - 1):
                    dfs(i, j)
        print(remain_board)
        for i in range(m):
            for j in range(n):
                if remain_board[i][j] == 0:
                    board[i][j] = "X"
