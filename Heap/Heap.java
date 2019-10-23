package Heap;

public interface Heap {
	public int size();
	public boolean isEmpty();
	public void insert(Object o);
	public void removeMin();
	public void upHeap();
	public void downHeap();
	public void display();
}
