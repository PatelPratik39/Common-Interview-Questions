package Graph;

import java.util.ArrayList;

public class CycleDetection2 {
    static class Edge{
        int source;
        int destination;
        public Edge(int source, int destination){
            this.source = source;
            this.destination = destination;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
//        // Initialize each vertex's adjacency list
        for(int i =0;  i< graph.length; i++){
            graph[i] = new ArrayList <Edge>();
        }
        // Adding edges to the graph
        graph[0].add(new Edge(0, 2)); // Edge from vertex 0 to vertex 2
        graph[1].add(new Edge(1, 0)); // Edge from vertex 1 to vertex 0
        graph[2].add(new Edge(2, 3)); // Edge from vertex 2 to vertex 3
        graph[3].add(new Edge(3, 0)); // Edge from vertex 3 to vertex 0
    }

    //        to check cycleDirection, I need to provide parameter like graph[], visited[], recursionStack[], currentNode
    public static boolean isCycleDirected( ArrayList< Edge > graph[], boolean visited[], int currentNode, boolean recursionStack[]) {
        visited[currentNode] = true;    //if any lev el we reached visited Array should be true
        recursionStack[currentNode] = true;

//            to find neighbors of current node i need to iterate over loop
        for (int i = 0; i < graph[currentNode].size(); i++) {
            Edge edge = graph[currentNode].get(i);
            if (recursionStack[edge.destination]) {
                return true;
            } else if (!visited[edge.destination]) {
                if(isCycleDirected(graph, visited, edge.destination, recursionStack)) {
                    return true;
                }
            }
        }
        recursionStack[currentNode] = false;
        return false;
    }


    public static void main ( String[] args ) {
        int V = 4;
        ArrayList< Edge > graph[] = new ArrayList[V];
        createGraph(graph);


//            if we have more than one component of cycle, i need to use below code
        boolean visited[] = new boolean[V];
        boolean recursionStack[] = new boolean[V];
        for(int i=0; i < V; i++){
            if(!visited[i]){
                boolean isCycle = isCycleDirected(graph,visited,0,recursionStack);
                if (isCycle){
                    System.out.println(isCycle);
                    break;
                }
            }
        }
//            System.out.println(isCycleDirected(graph, new boolean[V],0, new boolean[V]));
    }
}
