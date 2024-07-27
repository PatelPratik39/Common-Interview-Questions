package Graph;
import java.util.*;

public class GraphBFS {

    static class Edge{
        int source;
        int destination;

        public Edge(int source, int destination){
            this.source = source;
            this.destination = destination;
        }
    }
    public static void createGraph( ArrayList<Edge> graph[] ){
        for(int i = 0; i< graph.length; i++){
            graph[i] = new ArrayList<Edge>();
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

    public static void bfs(ArrayList<Edge> graph[], int V, boolean visited[], int start){
//        first, I need to create linkedList type of Queue
        Queue<Integer> queue = new LinkedList <>();
//        create a boolean type of visited Array with the size of V to check a current node is visited or not
//        boolean visited[] = new boolean[V];
//        now I need to define my starting point of search
//        queue.add(0);
        queue.add(start);

//        I want to run a loop until my queue gets empty
        while(!queue.isEmpty()){
//            first, i need to print the current node from queue that is removed from queue that turned true
           int currentNode =  queue.remove();
           if(visited[currentNode] == false){
               System.out.print(currentNode + " - " );
               visited[currentNode] = true;

//               i want to get currentNode
               for(int i = 0; i < graph[currentNode].size(); i++){
                   Edge edge = graph[currentNode].get(i);
                   queue.add(edge.destination);
               }
           }
        }

    }


    public static void main ( String[] args ) {
        int V = 7;
        boolean visited[] = new boolean[V];

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        for(int i=0; i <V; i++){
            bfs(graph, V,visited,i );
        }

//        bfs(graph, V);
        System.out.println();

//        for(int i = 0; i < graph[5].size(); i++){
//            Edge edge = graph[5].get(i);
//            System.out.print(edge.destination + " - ");
//        }
    }
}
