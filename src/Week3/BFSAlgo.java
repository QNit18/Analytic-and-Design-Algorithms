package Week3;

import java.util.LinkedList;
import java.util.Queue;

public class BFSAlgo {

    public static void BFS(int[][] graph, int start, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = 1;
        queue.add(start); // add Node root

        while (!queue.isEmpty()) {
            int current = queue.poll(); // Dequeue
            System.out.print(current + " ");

            for (int neighbor : graph[current]) {
                if (visited[neighbor] == 0) {
                    visited[neighbor] = 1; // Mark neighbor as visited
                    queue.add(neighbor); // Enqueue the neighbor
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2, 3},
                {0, 4, 5},
                {0, 6, 7},
                {0, 7},
                {1},
                {1},
                {2},
                {2, 3}
        };
        int n = 8;
        int[] visited = new int[n];

        BFS(graph, 0, visited); // Perform BFS starting from node 0
    }
}
