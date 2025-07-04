package DataStructures.Graph.Traversal.BFS;

import java.util.*;

public class GraphBFS {
    int V;

    GraphBFS(int v){
        this.V = v;
    }

    List<Integer> bfsTraversal(List<List<Integer>> adjList){
        boolean[] visted = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visted[0] = true;
        while(!q.isEmpty()){
            int front = q.poll();
            ans.add(front);
            for(int neighbour : adjList.get(front)){
                if(!visted[neighbour]){
                    visted[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        return ans;
    }
}

class DriverCode{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Vertices and Edges: ");
        int v = sc.nextInt();
        int e = sc.nextInt();

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<v; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=1; i<=e; i++){
            System.out.println("Enter the Edges: ");
            int u = sc.nextInt();
            int vertices = sc.nextInt();
            adjList.get(u).add(vertices);
        }

        GraphBFS g = new GraphBFS(v);
        List<Integer> result = g.bfsTraversal(adjList);
        for(int i: result){
            System.out.print(i + " ");
        }
        sc.close();
    }
}
