import java.util.*;

public class shortestpath {

    public static int[] shortestPath(int V, int[][] edges, int source) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        dist[source] = 0;
        q.offer(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neigh : adj.get(node)) {
                if (!visited[neigh]) {
                    dist[neigh] = dist[node] + 1;
                    visited[neigh] = true;
                    q.offer(neigh);
                }
            }
        }


        return dist;

    }

    public static void main(String[] args) {

        int V = 6;

        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 3},
            {2, 3},
            {3, 4},
            {4, 5}
        };

        int source = 0;

        int[] ans = shortestPath(V, edges, source);

        System.out.println(Arrays.toString(ans));
    }
}