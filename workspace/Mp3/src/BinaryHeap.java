// Ver 1.0:  Starter code for Binary Heap implementation

import java.util.Comparator;

public class BinaryHeap<T> implements PQ<T> {
    T[] pq;
    Comparator<T> c;
    int size;
    /** Build a priority queue with a given array q */
    BinaryHeap(T[] q, Comparator<T> comp) {
	pq = q;
	c = comp;
	size =pq.length -1;
	buildHeap();
    }

    /** Create an empty priority queue of given maximum size */
    BinaryHeap(int n, Comparator<T> comp) { /* to be implemented */
    	Object[] pq = new Object[n];
    	T[] p = (T[])pq;
    	c=comp;
    	buildHeap();
    }

    public void insert(T x) {
	add(x);
    }

    public T deleteMin() {
	return remove();
    }

    public T min() { 
	return peek();
    }

    public void add(T x) { 
    	size++;
    	pq[size]=x;
    	percolateUp(size);
    }

    public T remove() { 
     T min = min();
     pq[1]=pq[size--];
     percolateDown(1);
	return min;
    }

    public T peek() { 
	return pq[1];
    }

    /** pq[i] may violate heap order with parent */
    void percolateUp(int i) { /* to be implemented */
    pq[0]=pq[i];
    while(c.compare(pq[i/2], pq[0])>0 && i>1){
    	pq[i]=pq[i/2];
    	i=i/2;
       }
      pq[i]=pq[0];
      
    	}

    /** pq[i] ma y violate heap order with children */
    void percolateDown(int i) {
    	T x=pq[i];
    	while(2*i<=size){
    		if(2*i==size){
    			if(c.compare(x,pq[size])>0){
    				pq[i]=pq[size];
    				i=size;
    			}
    			else break;
    			}
    			else {
    				int schild = 2*i;
    				if(c.compare(pq[schild],pq[schild+1])>0){
    					schild++;
    				}
    				if(c.compare(x,pq[schild])>0){
    					pq[i]=pq[schild];
    					i=schild;
    				}
    				else break;
    			}
    	}
    	pq[i]=x;
    }

    /** Create a heap.  Precondition: none. */
    void buildHeap() {
    for(int i=pq.length/2; i>=1;i--){
    	percolateDown(i);
    }
    }
    
    public boolean isEmpty(){
    	return size <= 0;
    }

    /* sort array A[1..n].  A[0] is not used. 
       Sorted order depends on comparator used to buid heap.
       min heap ==> descending order
       max heap ==> ascending order
     */
    public static<T> void heapSort(T[] A, Comparator<T> comp) { 
    }
}
