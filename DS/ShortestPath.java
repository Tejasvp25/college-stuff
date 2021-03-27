import java.util.Scanner;

class ShortestPath {
    static int COST_OF_ROAD_PER_KM = 100000;
    static final int V = 7;

    int minDistance(int dist[], Boolean sptSet[]) {

        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    void printSolution(int dist[], int src) {
        System.out.println(
                "Source \t\t Destination \t\t Distance from Source \t\t Cost of Road Construction from Vertex(Geo. Location) to Destination(Geo. Location");
        for (int i = 1; i < V; i++)
            System.out.println(
                    src + " \t\t " + i + " \t\t\t " + dist[i] + " km \t\t\t\t Rs. " + dist[i] * COST_OF_ROAD_PER_KM);
    }

    void dijkstra(int graph[][], int src) {
        int dist[] = new int[V];

        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < V; v++)
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
        printSolution(dist, src);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int graph[][] = new int[ShortestPath.V][ShortestPath.V];
        System.out.println("Enter Graph vertices : ");
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                graph[i][j] = s.nextInt();
            }
        }

        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
        s.close();
    }
}
