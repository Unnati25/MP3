
/* Ver 1.0: Starter code for Dijkstra's Shortest path algorithm */

import java.util.HashSet;
import java.util.Scanner;
import java.lang.Comparable;
import java.io.FileNotFoundException;
import java.io.File;

public class ShortestPath {
    static final int Infinity = Integer.MAX_VALUE;

    static void DijkstraShortestPaths(Graph g, Vertex s)
    {    
    	for(Vertex v:g){
    	v.d=Infinity;
    	v.p=null;
    }
    	Vertex[] arr = g.v.toArray(new Vertex[g.v.size()]);
    	IndexedHeap<Vertex> pq = new IndexedHeap<>(arr, s);
    	
    	s.d=0;
    	HashSet<Vertex> S = new HashSet<>();
    	while(!pq.isEmpty()){
    		Vertex u = pq.remove();
    		S.add(u);
    		for(Edge e: u.adj){
    		  Vertex v= e.otherEnd(u);
    			if(!S.contains(v) && u.d + e.weight<v.d){
    				v.d=u.d+e.weight;
    				v.p=u;
    				pq.decreaseKey(v);
    			}
    			
    		}
    	}
        
    }

    public static void main(String[] args) throws FileNotFoundException {
	Scanner in;

       /* if (args.length > 0) {
            File inputFile = new File(args[0]);
            in = new Scanner(inputFile);
        } else {
            in = new Scanner(System.in);
        }*/
	 //File inputFile = new File("./src/abc.txt");
	 in = new Scanner(System.in);
	Graph g = Graph.readGraph(in);
	int src = in.nextInt();
	int target = in.nextInt();
        Vertex s = g.getVertex(src);
	   Vertex t = g.getVertex(target);
        DijkstraShortestPaths(g, s);

	System.out.println(t.d);
    }
}
