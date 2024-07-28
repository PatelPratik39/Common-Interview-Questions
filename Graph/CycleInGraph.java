package Graph;

import java.util.ArrayList;

public class CycleInGraph {
    static class Edge {
        int source;
        int destination;

        public Edge ( int source, int destination ) {
            this.source = source;
            this.destination = destination;
        }
    }

    public static void createGraph( ArrayList<Edge> graph[] ){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList <>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,4));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,4));


        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,2));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,4));
    }


    public static boolean isCycleUnDirected(ArrayList<Edge> graph[], boolean visited[], int currentNode, int parent) {
        visited[currentNode] = true;

        for(int i = 0; i< graph[currentNode].size(); i++){
            Edge edge = graph[currentNode].get(i);

            if(visited[edge.destination] && edge.destination != parent){
                return true;
            } else if ( !visited[edge.destination]) {
                if(isCycleUnDirected(graph, visited, edge.destination, currentNode)) {
                    return true;
                }
            }
        }
            return false;
    }

//    public static boolean isCycleUnDirected(ArrayList<Edge> graph[], boolean visited[], int currentNode, int parent){
//        visited[currentNode] = true;
//
//        for(int i = 0; i < graph[currentNode].size(); i++){
//            Edge edge = graph[currentNode].get(i);
//            if(visited[edge.destination] && edge.destination != parent){
//                return true;
//            } else if (!visited[edge.destination]) {
//                if(isCycleUnDirected(graph,visited,edge.destination,currentNode)){
//                    return true;
//                }
//            }
//        }
//        return false;  // if i can not find a cycle then return false
//    }

    public static void main ( String[] args ) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycleUnDirected(graph,new boolean[V],0,-1));
    }
}
