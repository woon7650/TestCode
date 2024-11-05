package com.example.testcode.Algorithm;

import java.util.*;

public class Recursive {

    public static Map<Integer, List<Integer>> graph = new HashMap<>();
    public static Set<Integer> visited = new HashSet<>();
    public static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {

        addEdge(1, 2);
        addEdge(1, 4);
        addEdge(1, 6);
        addEdge(2, 1);
        addEdge(3, 6);
        addEdge(4, 1);
        addEdge(5, 6);
        addEdge(6, 1);
        addEdge(6, 3);
        addEdge(6, 5);

        int start = 4;
        dfs(start);
        System.out.println("방문 탐색 : " + path);
    }

    // graph에 노드, 간선을 추가
    private static void addEdge(int u, int v) {

        //초기 노드 생성성
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());

        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private static void dfs(int node) {

        visited.add(node);
        path.add(node);

        for (int neighborNode : graph.get(node)) {
            if (!visited.contains(neighborNode)) {
                dfs(neighborNode);
            }
        }
    }
}
