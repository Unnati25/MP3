
/* Ver 1.0: Starter code for Prim's MST algorithm */


import java.util.PriorityQueue;
import java.util.Scanner;
import java.lang.Comparable;
import java.io.FileNotFoundException;
import java.io.File;

public class MST {
    static final int Infinity = Integer.MAX_VALUE;

    static int PrimMST(Graph g, Vertex s)
    {
        int wmst = 0;
        int size=1;
        PriorityQueue<Edge> pq= new PriorityQueue<>();
        for(Edge e:s.adj){
        	pq.add(e);
        }
        while(size<g.size){
        	s.seen=true;
        	Edge e= pq.remove();
        	wmst =wmst + e.weight;
        	if(e.from.seen && e.to.seen)
        		continue;
        	if(e.from.seen){
        		e.to.seen=true;
        		e.to.p=e.from;
        		for(Edge f:e.to.adj){
        			pq.add(f);
        		}
        	}
        	else{
        		e.from.seen=true;
        		e.from.p=e.to;
        		for(Edge f:e.from.adj){
        			pq.add(f);
        		}
        	}
        	
        size++;	
        }
        return wmst;
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
        Vertex s = g.getVertex(1);
        System.out.println(PrimMST(g, s));
    }
}
