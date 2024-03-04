package com.learn.LC207;

import java.util.ArrayList;

public class SolutionOne {
    private int[] colors;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }
        colors = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(colors[i] == 0 && !dfs(adjList,i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> adjList, int u) {
        colors[u] = 1;
        ArrayList<Integer> adj = adjList.get(u);
        for (Integer v : adj) {
            if (colors[v] == 0) {
                colors[v] = 1;
                if (!dfs(adjList, v)) {
                    return false;
                }
            } else if (colors[v] == 1) {
                return false;
            }
        }
        colors[u] = 2;
        return true;
    }
}
