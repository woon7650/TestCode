package com.example.testcode.Algorithm;

import java.util.*;

public class BFS {

    public static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {

        addEdge(1, 2);
        addEdge(1, 6);
        addEdge(1, 4);
        addEdge(2, 1);
        addEdge(3, 6);
        addEdge(4, 1);
        addEdge(5, 6);
        addEdge(6, 1);
        addEdge(6, 3);
        addEdge(6, 5);

        int start = 4;
        int end = 3;

        Result result = bfs(start, end);

        if (result.minPath == -1) {
            System.out.println("최단 경로를 찾을 수 없습니다.");
        } else {
            System.out.println("최단거리 : " + result.minPath);
            System.out.println("경로 : " + result.totalDistance);
        }
    }

    // graph에 노드, 간선을 추가
    private static void addEdge(int u, int v) {

        //초기 노드 생성성
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());

        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private static Result bfs(int start, int end) {

        if (start == end) {
            return new Result(0, null);
        }


        /*
        visited(Set) : 방문한 노드
        queue(Queue) : bfs queue
        distance(Map) : 최소 거리
        parentNode(Map) : 부모 노드
        */
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        Map<Integer, Integer> startToNodeDistance = new HashMap<>();
        Map<Integer, Integer> parentNode = new HashMap<>();

        // start 세팅
        visited.add(start);
        queue.add(start);
        startToNodeDistance.put(start, 0);
        parentNode.put(start, null);

        while (!queue.isEmpty()) {

            /*
            node : bfs를 실행할 queue
            nodeDistance : start ~ 해당 node 거리
            */
            int node = queue.poll();
            int nodeDistance = startToNodeDistance.getOrDefault(node, 0);

            // 이웃 노드 탐색
            for (int neighborNode : graph.get(node)) {

                /*
                방문 노드가 아닐 경우
                visited : neighborNode 방문 이력 추가
                queue : bfs를 실행할 neighborNode 추가
                distance : start부터 neighborNode까지 거리 추가
                parentNode : neighborNode, parentNode 추가
                */
                if (!visited.contains(neighborNode)) {

                    visited.add(neighborNode);
                    queue.add(neighborNode);
                    startToNodeDistance.put(neighborNode, nodeDistance + 1);
                    parentNode.put(neighborNode, node);

                    //인접 노드에 도착지가 있을 경우 Back Tracking
                    if (neighborNode == end) {
                        //minPath : end->start 경로
                        List<Integer> minPath = new ArrayList<>();
                        Integer currentParent = end;

                        //end부터 parentNode를 이용해서 Back Tracking 시작
                        while (currentParent != null) {
                            minPath.add(currentParent);
                            currentParent = parentNode.get(currentParent);
                        }

                        Collections.reverse(minPath);

                        return new Result(startToNodeDistance.get(end), minPath);
                    }
                }
            }
        }

        // end 에 안걸릴경우
        return new Result(-1, null);
    }

    public static class Result {
        int minPath;
        List<Integer> totalDistance;

        Result(int minPath, List<Integer> totalDistance) {
            this.minPath = minPath;
            this.totalDistance = totalDistance;
        }
    }
}