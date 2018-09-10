package breadthfirstsearch;

/**
 *
 * @author niall o connor
 */
import java.util.*;
 
public class BreadthFirstSearch
{
    private int V;   // number of edges or vertices
    private LinkedList<Integer> adj[]; //simulate neibouring nodes
 
    BreadthFirstSearch(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    // add an edge with a set width
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
 
    // traverses from a given source
    void BFS(int s)
    {
        // a new array of boolean values to indicate if node has been visited
        boolean visited[] = new boolean[V];
 
        // Create a queue to store the nodes in
        LinkedList<Integer> queue = new LinkedList<>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
 
        // traverse if not empty
        while (!queue.isEmpty())
        {
            // Dequeue the next element from the queue
            s = queue.poll();
            System.out.print(s+" ");
 
            // iterator over the node marking it's neighbours as visited
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    // mark as true and add it to the queue to be traversed over
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
 
    public static void main(String args[])
    {

        BreadthFirstSearch g = new BreadthFirstSearch(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("An example of a breath first traversal starting from source 2 ");

        g.BFS(2);

        System.out.println("\nAn example of a breath first traversal starting from source 1");
 
        g.BFS(1);
    }
}
