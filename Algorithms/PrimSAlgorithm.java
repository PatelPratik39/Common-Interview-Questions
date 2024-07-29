package Algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimSAlgorithm {
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

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
    }
//    Prims Algorithm implementation

    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;

        public Pair ( int node, int cost ) {
            this.node = node;
            this.cost = cost;
        }

//        comparing based on cost so priority queue can sort based on the lowest cost
        @Override
        public int compareTo ( Pair pair2 ) {
            return this.cost - pair2.cost;   //ascending order
        }
    }

//    Time Complexity of Prims Algorithm is : O(E log E)

    public static void primsAlgo(ArrayList<Edge> graph[], int V){
        PriorityQueue<Pair> priorityQueue = new PriorityQueue <>();  // non mst
        boolean visited[] = new boolean[V];
        priorityQueue.add(new Pair(0,0));

        int mstCost = 0;   //initialize a mstcaost as 0

        while(!priorityQueue.isEmpty()){
            Pair currentPair = priorityQueue.remove();

            if(!visited[currentPair.node]){
                visited[currentPair.node] = true;
                mstCost += currentPair.cost;

                for (int i=0; i <graph[currentPair.node].size(); i++){
                    Edge edge = graph[currentPair.node].get(i);
                    if(!visited[edge.destination]){
                        priorityQueue.add(new Pair(edge.destination, edge.weight));
                    }
                }
            }
        }
        System.out.println("Minimum Cost of MST = " + mstCost);

    }


    public static void main ( String[] args ) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        primsAlgo(graph, V);
    }
}
