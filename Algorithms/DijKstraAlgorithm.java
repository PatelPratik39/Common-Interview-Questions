package Algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijKstraAlgorithm {
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

//    create Graph
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i =0; i < graph.length; i++){
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

//    dijkstra's function

//    first time I need to create a Pair class for dijkstras algorithm because Pair class will contain a pair of sourceNode and destination

    /*
    NOTE: in Pair class i need to implement Comparable class with Pair because i want to get a pair with the shortest distance,
            so, Priority queue needs to know that pair should be stored as the shortest pair first based on "DISTANCE"
            so i need to compare p2 with p1 and return current pair distance  - p2 paired distance. " return  this.distance - p2.distance
     */

    public static class Pair implements Comparable<Pair>{
        int node;
        int distance;

        public Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo ( Pair pair2 ) {
            return this.distance - pair2.distance;   // this will return based on ascending order
//            return pair2.distance - this.distance;  // this will return based on Descending order
        }
    }

    /*
    Time Complexity of Dijkstra's algorithm => O(E + E logV)
    where, E logV comes from priority queue because it keeps performing sorting and
    E comes from traveling all the Vertexes
     */


    public static void dijkstra(ArrayList<Edge> graph[], int source, int V){
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();   //storing whole Pair from Pair class as Priority Queue
        int distance[] = new int [V];    //distance[] matrix that contains all the Vertexes
        for(int i =0; i < V; i++){
            if(i != source){
                distance[i] = Integer.MAX_VALUE;     //setting up distance i value  to infinity, so in java i need to use Integer.MAX_VALUE
            }
        }
        boolean visited[] = new boolean[V];
//        add new priority Pair for a source that is ) here, and it has 0 and distance is also ) at initial level
        priorityQueue.add(new Pair(0,0));

//        using bfs
//        while loop will run until my priorityQueue gets empty
        while(!priorityQueue.isEmpty()){
            Pair currentPair = priorityQueue.remove();  //the shortest pair needs to be removed from the priorityQueue

            //if condition checks if currentPair of Node is not visited, then make it visited true first of all the thing,
//            then find out neighbors of the current node and update them
            if(!visited[currentPair.node]){
                visited[currentPair.node] = true;

//                find out the neighbor of currentPair nodes and iterate over the size of Neighbors
                for(int i = 0; i < graph[currentPair.node].size(); i++){
                    Edge edge = graph[currentPair.node].get(i);   // get the Edge of currentPair Node
                    // now, I need to set integer type u to an edge source and integer type of v to-edge destination.
                    int u = edge.source;
                    int v = edge.destination;
//                    Relexation code logic goes here
                    if(distance[u] + edge.weight < distance[v] ){
                        distance[v] = distance[u]+ edge.weight;  //update the distance of v
//                        now add the updated distance to priorityQueue
                        priorityQueue.add(new Pair(v, distance[v]));
                    }
                }
            }
        }

//        now I want to print the shortest distance, so I am iterating over V
        for(int i=0; i < V; i++){
            System.out.print(distance[i]+ " ");
        }
        System.out.println();

    }


    public static void main ( String[] args ) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);  //calling createGraph method
        dijkstra(graph,0, V);  //calling dijkstraS function logic
    }
}
