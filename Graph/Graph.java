package Graph;

import java.util.*;


public class Graph {
//    first create Edge class with source and destination
    static class Edge{
        int src;
        int dest;
//        int wt;
    public Edge(int src, int dest){
        this.src = src;
        this.dest = dest;

    }

//        public Edge(int src, int dest, int w){
//            this.src = src;
//            this.dest = dest;
//            this.wt = w;
//        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
//        first of all, I need to convert a null list to an empty list
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList <Edge>();
        }
//      add source and edges into graph
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

//        graph[0].add(new Edge(0,2, 2));
//
//        graph[1].add(new Edge(1,2,10));
//        graph[1].add(new Edge(1,3,0));
//
//        graph[2].add(new Edge(2,0, 2 ));
//        graph[2].add(new Edge(2,1,10));
//        graph[2].add(new Edge(2, 3, -1));
//
//        graph[3].add(new Edge(3,1,0));
//        graph[3].add(new Edge(3,2, -1));

    }

    public static void bfs( ArrayList<Edge> graph[], int V){
        Queue<Integer> queue = new LinkedList <>();   //created queue of linked lists
        boolean visited[] = new boolean[V];            //created a new array of a visited Array boolean type
        queue.add(0); //define a starting point of queue

//        set a condition that my loop will run until my queue gets empty.
        while(!queue.isEmpty()){
            int currentNode = queue.remove();
            if(visited[currentNode] == false){
                System.out.print(currentNode + " - ");
                visited[currentNode] = true;

//                iterate over the queue size so I can find all the edges
                for(int i=0; i <graph[currentNode].size(); i++){
                    Edge edge = graph[currentNode].get(i);
                    queue.add(edge.dest);
                }
            }
        }
    }

//    Time Complexity of Graph BFS = O(V+E)

    public static void main ( String[] args ) {
        int V = 7;   //I need to define how many vertexes

        ArrayList < Edge > graph[] = new ArrayList[V];
        createGraph(graph);
        bfs(graph, V);
        System.out.println();

//        print neighbors of 2
//        for (int i = 0; i < graph[4].size(); i++) {
//            Edge e = graph[4].get(i);
//            System.out.println(e.dest );
////            System.out.println(e.dest + " , " +  e.wt);
//        }
    }
}
