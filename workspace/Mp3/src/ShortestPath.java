
/* Ver 1.0: Starter code for Dijkstra's Shortest path algorithm */

import java.util.Scanner;
import java.lang.Comparable;
import java.io.FileNotFoundException;
import java.io.File;

public class ShortestPath {
    static final int Infinity = Integer.MAX_VALUE;

    static void DijkstraShortestPaths(Graph g, Vertex s)
    {
        // Code for Dijkstra's algorithm needs to be written
	// Shortest paths will be stored in fields d,p in the Vertex class
    }

    public static void main(String[] args) throws FileNotFoundException {
	Scanner in;

        if (args.length > 0) {
            File inputFile = new File(args[0]);
            in = new Scanner(inputFile);
        } else {
            in = new Scanner(System.in);
        }

	Graph g = Graph.readGraph(in);
	int src = in.nextInt();
	int target = in.nextInt();
        Vertex s = g.getVertex(src);
	Vertex t = g.getVertex(target);
        DijkstraShortestPaths(g, s);

	System.out.println(t.d);
    }
}
