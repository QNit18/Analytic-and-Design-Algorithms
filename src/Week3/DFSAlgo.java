package Week3;

public class DFSAlgo {

    public static void DFS(int[][] graph, int v, int[] visited){
        visited[v] = 1;
        System.out.print(v + " ");
        for (int i = 0; i < graph[v].length; i++){
            if(visited[graph[v][i]] == 0){
                DFS(graph, graph[v][i], visited);
            }
        }
    }


    public static void main(String[] args) {
        // 1 2 3 4 5
        int[][] graph = {
                {1, 2},
                {0, 3, 4},
                {0},
                {1},
                {1}
        };
        int n = 5;
        int[] visited = new int[5];

        DFS(graph, 0, visited);
    }
}
