package Algorithms;

import java.util.ArrayList;

public class BellmanFordSAlgo {
    static class Edge{
        int source;
        int distance;
        int weight;
        public Edge(int source, int distance, int weight){
            this.source = source;
            this.distance = distance;
            this.weight = weight;
        }
    }
    private static void CreateGraph ( ArrayList< Edge>[] graph ) {
        for( int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));
        graph[1].add(new Edge(1,2,-4));
        graph[2].add(new Edge(2,3,2));
        graph[3].add(new Edge(3,4,4));
        graph[4].add(new Edge(4,1,-1));
    }
    public static void bellmanFord(ArrayList<Edge> graph[], int V, int source){
        int distance[] = new int[V];  // create distance matrix

//        create loop to define infinity value over all the Vertexes if it's not 0
//        base cases
        for (int i = 0; i < V; i++){
            if(i != source){
                distance[i] = Integer.MAX_VALUE;  // define Infinity value at initial state of distance
            }
        }
//        Outer loop runs always V-1 in bellman Fords Algorithm because the longest path can be possible V-1 nodes
        for(int k=0; k < V-1; k++){   //O(V) time complexity for this outer loop
//            now i need to find edges
            for(int i =0; i < V; i++){  // O(E) time complexity
                for(int j =0; j  <graph[i].size(); j++) {   //find neighbors of current V
                    Edge edge = graph[i].get(j);  //find out edges by traversing each node of i
//                    need to define u and v for reelection
                    int u = edge.source;
                    int v = edge.distance;
//                    in below relation logic, I need to add one more condition that u from distance matrix should not be infinity
                    if(distance[u] != Integer.MAX_VALUE  && distance[u] + edge.weight < distance[v]){
                        distance[v] = distance[u]+ edge.weight;
                    }
                }
            }
        }
//        print all distance matrix
        for(int i =0; i < distance.length; i++){
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }

    public static void main ( String[] args ) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph);
        bellmanFord(graph,V, 0);
    }


}
