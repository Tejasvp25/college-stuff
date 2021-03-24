
/*
    Name - Tejas Vijay Patil
    Gr No - xxxxxxxx
    Roll No - xxxxxx
    Dib - xxxx

*/
import java.util.*;

class PGraph {

    static int COST_OF_ROAD_PER_KM = 10000;

    public void Prim(int G[][], int V) {
        int INF = 9999999;
        int no_edge;
        boolean[] selected = new boolean[V];
        Arrays.fill(selected, false);
        no_edge = 0;
        selected[0] = true;
        System.out.println("Edge (X) : Weight (Y) : Cost of Building a Road from X to Y");

        while (no_edge < V - 1) {
            int min = INF;
            int x = 0;
            int y = 0;

            for (int i = 0; i < V; i++) {
                if (selected[i] == true) {
                    for (int j = 0; j < V; j++) {

                        if (!selected[j] && G[i][j] != 0) {
                            if (min > G[i][j]) {
                                min = G[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.println(x + " - " + y + " :  " + G[x][y] + " : Rs. " + G[x][y] * COST_OF_ROAD_PER_KM);
            selected[y] = true;
            no_edge++;
        }
    }
}

class Graph {
    static int COST_OF_ROAD_PER_KM = 10000;

    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    };

    class subset {
        int parent, rank;
    };

    int vertices, edges;
    Edge edge[];

    Graph(int v, int e) {
        vertices = v;
        edges = e;
        edge = new Edge[edges];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    int find(subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void KruskalAlgo() {
        Edge result[] = new Edge[vertices];
        int e = 0;
        int i = 0;
        for (i = 0; i < vertices; ++i)
            result[i] = new Edge();

        Arrays.sort(edge);
        subset subsets[] = new subset[vertices];
        for (i = 0; i < vertices; ++i)
            subsets[i] = new subset();

        for (int v = 0; v < vertices; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i = 0;
        System.out.println("Edge (X) : Weight (Y) : Cost of Building a Road from X to Y");
        while (e < vertices - 1) {
            Edge next_edge = new Edge();
            next_edge = edge[i++];
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " - " + result[i].dest + ": " + result[i].weight + " : Rs. "
                    + result[i].weight * COST_OF_ROAD_PER_KM);
    }

    void setEdge(int index, int src, int dest, int weight) {
        this.edge[index].src = src;
        this.edge[index].dest = dest;
        this.edge[index].weight = weight;

    }
}

class MstAlgo {
    public static void main(String[] args) {
        System.out.println("Prim's Algo : ");
        PGraph pg = new PGraph();
        int V = 5;
        int[][] Gr = { { 0, 9, 75, 0, 0 }, { 9, 0, 95, 19, 42 }, { 75, 95, 0, 51, 66 }, { 0, 19, 51, 0, 31 },
                { 0, 42, 66, 31, 0 } };
        pg.Prim(Gr, V);

        System.out.println("Kruskal's Algo : ");
        int vertices = 6;
        int edges = 8;
        Graph G = new Graph(vertices, edges);

        G.setEdge(0, 0, 1, 4);
        G.setEdge(1, 0, 2, 4);
        G.setEdge(2, 1, 2, 2);
        G.setEdge(3, 2, 3, 3);
        G.setEdge(4, 2, 5, 2);
        G.setEdge(5, 2, 4, 4);
        G.setEdge(6, 3, 4, 3);
        G.setEdge(7, 5, 4, 3);
        G.KruskalAlgo();
    }
}