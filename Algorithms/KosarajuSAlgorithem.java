package Algorithms;

import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.Stack;

public class KosarajuSAlgorithem {

    static class Edge{
        int source;
        int destination;
        public Edge(int source, int destination ){
            this.source = source;
            this.destination = destination;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0;  i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));
//        graph[4].add(new Edge(4,0));
    }

//    Topological sorting contains 4 parameters always, array, currentNode, visited[], stack

    public static void topSort(ArrayList<Edge> graph[], boolean visited[], int currentNode, Stack<Integer> stack){
        visited[currentNode] = true;  // if the current node is not visited, then make it true as visited
//        find neighbor of currentNode size and find the edge
        for(int i = 0; i < graph[currentNode].size(); i++){
            Edge edge = graph[currentNode].get(i);

//            if the destination of edge is not visited, then make it visited by recursion call of topsort()
            if(!visited[edge.destination]){
                topSort(graph,visited,edge.destination,stack);
            }
        }
//        after iterating the loop, push the visited node to stack
        stack.push(currentNode);
    }

//    simple code of Depth-First Search (DFS)
    public static void dfs(ArrayList<Edge> graph[], boolean visited[], int currentNode){
        visited[currentNode] = true;  // if the current Node is not visited, then make it visited

        System.out.print(currentNode + " ");
//       loop over an array
        for(int i = 0; i < graph[currentNode].size(); i++){
            Edge edge = graph[currentNode].get(i);
            if(!visited[edge.destination]){
                dfs(graph,visited,edge.destination);
            }
        }
    }

    public static void kosarajuSAlgo(ArrayList<Edge> graph[], int V){
//        step1 = create a stack where i will store stack in Topological Order => Time Complexity O(V+E)
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];   // whenever, we perform DFS, vistied Array should be defined with false by default

        for(int i = 0; i< V; i++){
            if(!visited[i]){
                topSort(graph, visited, i, stack);
            }
        }
//        step2 = clone graph means Transpose the graph  => Time Complexity O(V+E)
        ArrayList<Edge> transposedGraph[] = new ArrayList[V];
//        loop over new transposed graph
        for(int i = 0; i< transposedGraph.length; i++){
            visited[i] = false;    // I need to make a visited array as false that is turn True wile topological sort
            transposedGraph[i] = new ArrayList<>();
        }

//        below method iterate over transposedGraph[]'s each Vertex V and get neighbors of each Vertex
        for(int i = 0; i < V;  i++){
            for(int j = 0; j < graph[i].size(); i++){
                Edge e = graph[i].get(j);   // Original FLow = e.source(i) -> e.destination
                transposedGraph[e.destination].add(new Edge(e.destination, e.source));
            }
        }
//        step3 = perform DFS on TransposedGraph[]  => Time Complexity O(V+E)
        while(!stack.isEmpty()){
            int currentNode = stack.pop();
            if(!visited[currentNode]){
                dfs(transposedGraph,visited, currentNode);
                System.out.println();
            }
//            System.out.println();
        }

    }

    public static void main ( String[] args ) {
        int V= 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        kosarajuSAlgo(graph, V);
    }
}
