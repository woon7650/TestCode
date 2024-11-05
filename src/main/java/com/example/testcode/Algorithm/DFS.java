package com.example.testcode.Algorithm;
import java.util.*;

public class DFS {

    public static Map<Integer, List<Integer>> graph = new HashMap<>();

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
        System.out.println("방문 탐색 : " + dfs(start));
    }


    // graph에 노드, 간선을 추가
    private static void addEdge(int u, int v) {

        //초기 노드 생성성
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());

        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static List<Integer> dfs(int start) {

        /*
        visited(Set) : node 방문 이력
        stack(Stack) : dfs stack
        */
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        List<Integer> path = new ArrayList<>();

        // start 초기화 세팅
        stack.push(start);
        visited.add(start);

        while (!stack.isEmpty()) {

            int node = stack.pop();
            path.add(node);
            /*
            방문 노드가 아닐 경우
            path : 진행 경로
            visited : node 방문 이력 추가
            */
            for (int neighborNode : graph.get(node)) {
                if (!visited.contains(neighborNode)) {
                    stack.push(neighborNode);
                    visited.add(neighborNode);
                }
            }

        }
        return path;
    }
}
