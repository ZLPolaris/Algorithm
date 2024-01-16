import collections


def traverse():
    # 邻接表
    adj_list = collections.defaultdict(list)
    n = len(adj_list)
    # 颜色数组 0 表示白色，1表示灰色，2表示黑色
    colors = [0] * n
    # 表示生成的广度优先搜索树的父亲节点
    father = [-1] * n

    time = 0
    find_time = [-1] * n
    end_time = [-1] * n

    def dfs(u):
        nonlocal time
        colors[u] = 1
        find_time[u] = time
        time += 1
        for v in adj_list[u]:
            if colors[v] == 0:
                father[v] = u
                dfs(v)
        colors[u] = 2
        end_time[u] = time
        time += 1

    for i in range(n):
        if colors[i] == 0:
            dfs(i)
