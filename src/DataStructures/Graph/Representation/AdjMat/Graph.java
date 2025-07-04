package DataStructures.Graph.Representation.AdjMat;

public class Graph {
    int V;
    int[][] adjMatrix;

    Graph(int vertices){
        this.V = vertices;
        adjMatrix = new int[V][V];
    }

    void addEdges(int u, int v){
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }

    void printAdjMatrix(){
        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class DriverCode{
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdges(0,1);
        g.addEdges(0,4);
        g.addEdges(0,5);
        g.addEdges(5,4);
        g.addEdges(4,3);
        g.addEdges(4,1);
        g.addEdges(1,3);
        g.addEdges(1,2);
        g.addEdges(3,2);

        g.printAdjMatrix();
    }
}
