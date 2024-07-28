package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AllPossiblePath {

    static class Edge {
        int source;
        int destination;

        public Edge ( int source, int destination ) {
            this.source = source;
            this.destination = destination;
        }
    }


    public static void createGraph( ArrayList < Edge > graph[]){

        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList < Edge >();
        }
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
    }

    //Breadth-First Search

    public static void bfs( ArrayList< Edge > graph[], int V, boolean visited[], int start){
        Queue <Integer> queue = new LinkedList <>();
//        boolean visited[] = new boolean[V];  //create a visited array
//        queue.add(0);  // define starting point from an array
        queue.add(start);  // define the starting point from an array if we have sub graphs

//        iterate over loop
        while(!queue.isEmpty()){
            int currentNode = queue.remove();
            if( visited[currentNode] == false){
                System.out.print(currentNode + " - ");
                visited[currentNode] = true;

//                find neighbors of the current node
                for(int i = 0; i < graph[currentNode].size(); i++){
                    Edge edge = graph[currentNode].get(i);
                    queue.add(edge.destination);
                }
            }
        }
    }

//    Depth-First Search

    public static void dfs( ArrayList< Edge > graph[], int currentNode, boolean visited[]){     //Time Complexity O(V+E)
        System.out.print(currentNode + " - ");
        visited[currentNode] = true;

        for(int i = 0; i < graph[currentNode].size(); i++){
            Edge edge = graph[currentNode].get(i);
            if(visited[edge.destination] == false){
                dfs(graph,edge.destination,visited);
            }
        }
    }

//    Find All Possible Paths   => Time complexity will be worst O(V^V)
    public static void printAllPath(ArrayList<Edge> graph[], boolean visited[], int currentNode, String path, int target){
//        base case
        if(currentNode == target){
            System.out.println(path);
            return;
        }
        for(int i =0; i < graph[currentNode].size(); i++){
            Edge edge = graph[currentNode].get(i);
            if(!visited[edge.destination]){
                visited[currentNode] = true;
                printAllPath(graph, visited, edge.destination, path+ edge.destination, target);
                visited[currentNode] = false;
            }
        }
    }

    public static void main ( String[] args ) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        int source = 0, target = 5;
        printAllPath(graph,new boolean[V], source, "0", 5);
    }
}
