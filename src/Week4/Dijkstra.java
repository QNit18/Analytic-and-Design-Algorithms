package Week4;

public class Dijkstra {
    private static final Double MAXVALUE = Double.MAX_VALUE; // Max value

    public static void dijkstra(double[][] graph, int start) {
        int V = graph.length;
        double[] dist = new double[V]; // List storing distince from v 0 to other
        boolean[] visited = new boolean[V]; // List storing the v had marked

        for (int i = 0; i < V; i++) {
            dist[i] = MAXVALUE;
        }

        // Distance from v 0 to itself
        dist[start] = 0;

        // Loop all
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited); // Choice v has min distance
            visited[u] = true;

            // Cập nhật khoảng cách của các đỉnh kề với đỉnh đã chọn
            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != MAXVALUE &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Show answer
        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To node " + i + ": " + dist[i]);
        }
    }

    // Function sp: Find distance min of v was not marked.
    private static int minDistance(double[] dist, boolean[] visited) {
        double min = MAXVALUE;
        int minIndex = -1;
        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
//        int graph[][] = new int[][]{
//                {0, 4, 0, 0, 0, 0, 0, 8, 0},
//                {4, 0, 8, 0, 0, 0, 0, 11, 0},
//                {0, 8, 0, 7, 0, 4, 0, 0, 2},
//                {0, 0, 7, 0, 9, 14, 0, 0, 0},
//                {0, 0, 0, 9, 0, 10, 0, 0, 0},
//                {0, 0, 4, 14, 10, 0, 2, 0, 0},
//                {0, 0, 0, 0, 0, 2, 0, 1, 6},
//                {8, 11, 0, 0, 0, 0, 1, 0, 7},
//                {0, 0, 2, 0, 0, 0, 6, 7, 0}
//        };
        double graph[][] = new double[][]{
              // 0  1  2  3  4  5  6  7  8
                {0, 2.5, 2.0, 2.1, 0, 0, 0, 0, 0},
                {2.5, 0, 0, 0, 1, 0, 0, 0, 0},
                {2, 0, 0, 0, 0.6, 1.5, 0, 0, 0},
                {2.1, 0, 0, 0, 0, 2.5, 0, 0, 0},
                {0, 1, 0.6, 0, 0, 0, 2.3, 0, 0},
                {0, 0, 1.5, 2.5, 0, 0, 1.9, 2.0, 0},
                {0, 0, 0, 0, 2.3, 1.9, 0, 1.8, 1.7},
                {0, 0, 0, 0, 0, 2.0, 1.8, 0, 2.0},
                {0, 0, 0, 0, 0, 0, 1.7, 2.0, 0}
        };
        dijkstra(graph, 0);
    }
}
