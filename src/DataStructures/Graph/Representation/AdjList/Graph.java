package DataStructures.Graph.Representation.AdjList;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
    ArrayList<ArrayList<Integer>> adjList;

    Graph(int n){
        adjList = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
    }

    void addEdges(int u, int v, boolean direction){
        // direction = false ->Undirected
        adjList.get(u).add(v);

        if(!direction){
            adjList.get(v).add(u);
        }
    }

    void printAdjList(){
        for(int i=0; i<adjList.size(); i++){
            System.out.print(i + " -> ");
            for(int neighbour : adjList.get(i)){
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }
    }

}

class DriverCode{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter the Number of Edges: ");
        int m = sc.nextInt();

        Graph g = new Graph(n);
        System.out.println("Enter the edges u and v: ");
        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            g.addEdges(u, v, false);
        }

        g.printAdjList();
        sc.close();
    }
}
