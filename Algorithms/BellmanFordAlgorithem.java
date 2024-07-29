package Algorithms;

import java.util.ArrayList;

public class BellmanFordAlgorithem {
    static class Edge{
        int source;
        int destination;
        int weight;

        public Edge ( int source, int destination, int weight ) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void createGraph( ArrayList<Edge> graph[] ){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList <>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));
        graph[1].add(new Edge(1,2,-4));
        graph[2].add(new Edge(2,3,2));
        graph[3].add(new Edge(3,4,4));
        graph[4].add(new Edge(4,1,-1));
    }
// bellmanFord Algorithm logic

    /*
    BellmanFord Algorithm does not work for Negative Weight Cycles
     */


    public static void bellmanFord(ArrayList<Edge> graph[], int source, int V){
        int distance[] = new int[V]; // create distance matrix
//        initialize distance matrix with infinity value
        for(int i = 0; i < V; i++){
            if( i != source){
                distance[i] = Integer.MAX_VALUE;
            }
        }

//        outer loop
        for(int k = 0; k < V-1; k++){   //O(V)
//            inner loop on Edges so i can get edges = O(E)
            for(int i = 0; i < V; i++){
//                get all the neighbors
                for(int j = 0;  j < graph[i].size(); j++){
                    Edge edge = graph[i].get(j);

                    int u = edge.source;
                    int v = edge.destination;
//                  if we add any value into Infinity value!! the distance will get minus in JAVA thats why i need to using a condition to avoid error
                    if(distance[u] != Integer.MAX_VALUE  && distance[u] + edge.weight < distance[v]){
                        distance[v] = distance[u] + edge.weight;
                    }
                }
            }
        }
//        print distance matrix
        for(int i=0; i < V; i++){
            System.out.print("( " + distance[i] + " ) " + " -> ");
        }
        System.out.println();
    }
    public static void main ( String[] args ) {
        int V = 5;
        ArrayList<Edge> graph[]  = new ArrayList[V];
        createGraph(graph);
        bellmanFord(graph,0, V);
    }
}
