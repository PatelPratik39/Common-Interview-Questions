package Algorithms;

import java.util.*;


public class PrimSAlgorithem {

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

    public static void createGraph(ArrayList<Edge>graph[]){
        for(int i = 0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
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

//    Prim's Algorithm implementation

    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo ( Pair pair2 ) {
            return this.cost - pair2.cost;   //ascending order
        }
    }

    public static void primSAlgo(ArrayList<Edge> graph[], int V){
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        boolean visited[] = new boolean[V];
//        add an initial pair into priorityQueue
        priorityQueue.add(new Pair(0,0));

//        I need to find the lowest cost of the MST
        int mstCost = 0;   //initialize a mstcost as 0

        while (!priorityQueue.isEmpty()){
            Pair currentPair = priorityQueue.poll();

            if(!visited[currentPair.node]){
                visited[currentPair.node] = true;
                mstCost += currentPair.cost;

                for(int i = 0; i < graph[currentPair.node].size(); i++){
                    Edge edge = graph[currentPair.node].get(i);
                    if (!visited[edge.destination]){
                        priorityQueue.add(new Pair(edge.destination, edge.weight));
                    }
                }
            }
        }

        System.out.println("Find the Minimum COST of MSt : " + mstCost);

    }

    public static void main ( String[] args ) {
        int V = 4;
        ArrayList<Edge > graph[] = new ArrayList[V];
        createGraph(graph);
        primSAlgo(graph,V);
    }
}


