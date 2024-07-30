package Algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstras {

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
    public static void createGraph(ArrayList<Edge> graph[]){

        for(int i = 0; i< graph.length; i++){
            graph[i] = new ArrayList<Edge>();
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

//    implement Dijkstra's Algorithm: Time Complexity O((V+E) logV)  and space complexity O(V)

    public static class Pair implements Comparable<Pair> {
        int node;
        int distance;

        public Pair ( int node, int distance ) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo ( Pair pair ) {
            return this.distance - pair.distance;  //ascending order
        }
    }

    public static void dijkstras(ArrayList<Edge> graph[], int V, int source){
        PriorityQueue<Pair>priorityQueue = new PriorityQueue<>();
        boolean visited[] = new boolean[V];
        int distance[] = new int[V];
        for(int i =0; i < V; i++){
            if(i != source){
                distance[i] = Integer.MAX_VALUE;
            }
        }
//        now add an initial pair to the priorityQueue
        priorityQueue.add(new Pair(0,0));

//        now I need to keep check the pair until all the pairs get removed from priorityQueue
        while(!priorityQueue.isEmpty()){
            Pair currentPair = priorityQueue.remove();  //shortest

            if(!visited[currentPair.node]){
                visited[currentPair.node] = true;

//                find neighbors and edges
                for(int i = 0; i < graph[currentPair.node].size(); i++){
                    Edge edge = graph[currentPair.node].get(i);
                    int u = edge.source;
                    int v = edge.destination;

                    if(distance[u] + edge.weight < distance[v]){
                        distance[v] = distance[u] + edge.weight;  //updating edge destination[v] to new distance
//                        now i need to update priorityQue with an updated pair
                        priorityQueue.add(new Pair(v, distance[v]));
                    }
                }
            }
        }
//        now I want to print the shortest distance so I am iterating over V
        for(int i=0; i < V; i++){
            System.out.print(distance[i]+ " ");
        }
        System.out.println();
    }

    public static void main ( String[] args ) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dijkstras(graph, V,0);
//        dijkstras(graph,0, V);
    }
}
