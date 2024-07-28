package Graph;

import java.util.ArrayList;

public class CycleDitection3 {

    static class Edge {
        int source;
        int destination;

        public Edge ( int source, int destination ) {
            this.source = source;
            this.destination = destination;
        }
    }
    //        create a simple graph
    public static void createGraph( ArrayList <Edge > graph[] ){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge >();
        }

        graph[0].add(new Edge(0,1));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4,2));
    }

    public static boolean isCycleDirected(ArrayList<Edge> graph[], int currentNode, boolean visited[], boolean recursionStack[]){
        visited[currentNode] = true;
        recursionStack[currentNode] = true;

        for(int i = 0; i < graph[currentNode].size(); i++){
            Edge edge = graph[currentNode].get(i);
            if(recursionStack[edge.destination]){
                return  true;
            } else if(!visited[edge.destination] && isCycleDirected(graph, edge.destination,visited,recursionStack)){
                return true;
            }
        }
        recursionStack[currentNode] = false;
        return false;
    }

    public static void main ( String[] args ) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        //            if we have more than one part of cycle, i need to use below code
        boolean visited[] = new boolean[V];
        boolean recursionStack[] = new boolean[V];
        boolean isCycle = false;
        // Check for cycles in each disconnected component
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCycleDirected(graph, i, visited, recursionStack)) {
                    isCycle = true;
                    break;
                }
            }
        }
        System.out.println("Cycle detected: " + isCycle);
//            System.out.println(isCycleDirected(graph, new boolean[V],0, new boolean[V]));
    }
}
