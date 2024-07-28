package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {
    static class Edge{
        int source;
        int destination;
        public Edge(int source, int destination){
            this.source = source;
            this.destination = destination;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    public static void topologicalSort( ArrayList<Edge> graph[], int currentNode,boolean visited[], Stack<Integer> stack){
        visited[currentNode] = true;  //first make current to true as visited into visited[]

//        find neighbors of the current node
        for (int i = 0; i < graph[currentNode].size(); i++){
            Edge edge = graph[currentNode].get(i);

//           Perform the recursive call if the neighbor has not been visited
            if(!visited[edge.destination]){
                topologicalSort(graph,edge.destination,visited, stack);
            }
        }
//         Push the current node to the stack after visiting all its adjacent vertices
        stack.push(currentNode);
    }

//    new method to sorted graph
    public static void topSort(ArrayList<Edge> graph[], int V){
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i < V; i++){
            if(!visited[i]){
                topologicalSort(graph,i,visited, stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }


    public static void main ( String[] args ) {
        int V = 6;
        ArrayList <Edge> graph[] = new  ArrayList[V];
        createGraph(graph);

        topSort(graph, V);
    }
}
