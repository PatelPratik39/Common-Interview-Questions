package Graph;

import java.util.ArrayList;

public class Graph {
//    first create Edge class with source and destination
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int w){
            this.src = src;
            this.dest = dest;
            this.wt = w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
//        first of all, I need to convert a null list to an empty list
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList <Edge>();
        }


        graph[0].add(new Edge(0,2, 2));

        graph[1].add(new Edge(1,2,10));
        graph[1].add(new Edge(1,3,0));

        graph[2].add(new Edge(2,0, 2 ));
        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3,1,0));
        graph[3].add(new Edge(3,2, -1));

    }

    public static void main ( String[] args ) {
        int V = 4;   //I need to define how many vertexes

        ArrayList < Edge > graph[] = new ArrayList[V];
        createGraph(graph);

//        print neighbors of 2
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.dest + " , " +  e.wt);
        }
    }
}
