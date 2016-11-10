
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
        PriorityQueue<Edge> pq= new PriorityQueue<>();
        for(Edge e:s.adj){
        	pq.add(e);
        }
        while(!pq.isEmpty()){
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
        }
        return wmst;
    }
    static int PrimMST2(Graph g, Vertex s)
    {
        int wmst = 0;
        Vertex[] arr = g.v.toArray(new Vertex[g.v.size()]);
        IndexedHeap<Vertex> pq= new IndexedHeap<Vertex>(arr, s);
       // s.seen=true;
        s.d=0;
        while(!pq.isEmpty()){
        	s.seen=true;
        	Vertex v = pq.remove();
        	wmst = wmst + v.d;
        	for(Edge e:v.adj){
        		 Vertex u=e.to;
        	 if(!u.seen && e.weight <u.d){
        		 u.d=e.weight;
        		 u.p=v;
        		pq.percolateUp(u.getIndex());
        	 }
        	}
        }
        return wmst;
    }
}
