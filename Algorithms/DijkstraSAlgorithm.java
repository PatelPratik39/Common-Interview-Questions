package Algorithms;

import java.util.*;

public class DijkstraSAlgorithm {

    static class Edge{
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight){
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

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }

//    Pair class
    public static class Pair implements Comparable<Pair>{
        int node;
        int distance;

        public Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
        @Override
        public int compareTo(Pair p2){
            return this.distance - p2.distance;   //ascending
//            return p2.distance - this.distance;  //descending
        }
    }
// Time COmplexity O(E + E logV)
    public static void dijkstra(ArrayList<Edge> graph[], int src, int V){
            PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
            int distnace[] = new int[V];
            for(int i =0; i < V; i++){
                if(i != src){
                    distnace[i] = Integer.MAX_VALUE;
                }
            }
            boolean visited[] = new boolean[V];

            priorityQueue.add(new Pair(0,0));

            while (!priorityQueue.isEmpty()){
                Pair current = priorityQueue.remove();
                if(!visited[current.node]){
                    visited[current.node] = true;

                    for(int i = 0; i < graph[current.node].size(); i++){
                        Edge edge = graph[current.node].get(i);
                        int u = edge.source;
                        int v = edge.destination;

                        if(distnace[u] + edge.weight < distnace[v]){
                            distnace[v] = distnace[u] + edge.weight;
                            priorityQueue.add(new Pair(v, distnace[v]));
                        }
                    }
                }
            }
            for(int i = 0; i < V; i++){
                System.out.print(distnace[i] + " ");
            }
        System.out.println();
    }

    public static void main ( String[] args ) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        dijkstra(graph,0,V);

    }
}
