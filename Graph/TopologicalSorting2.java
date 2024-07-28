package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting2 {

    static class Edge{
        int source;
        int destination;

        public Edge(int source, int destination){
            this.source = source;
            this.destination = destination;
        }
    }

    public static void createGraph( ArrayList < Edge >[] graph ){
        for(int i=0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));

    }

//    create DFS = topologySort
    public static void topologySort( ArrayList<Edge> graph[], boolean visited[], int currentNode, Stack<Integer> stack ){
        visited[currentNode] = true;
//        find neighbors of currentNode
        for(int i=0; i< graph[currentNode].size(); i++){
            Edge edge = graph[currentNode].get(i);
//            now check whether has not been visited using recursive call
            if(!visited[edge.destination]){
                topologySort(graph,visited,edge.destination,stack);
            }
        }
        stack.push(currentNode);
    }

    public static void topSort(ArrayList<Edge> graph[], int V){
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack <>();

        for(int i = 0; i< V; i++){
            if(!visited[i]){
                topologySort(graph,visited,i, stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }


    public static void main ( String[] args ) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        topSort(graph,V);
    }
}
