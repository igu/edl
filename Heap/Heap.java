package Heap;

import java.util.ArrayList;

public interface Heap {

    public int size();

    public boolean isEmpty();

    public void insert(Object o);

    public void upHeap();

    public void removeMin();

    public void downHeap();

    public void display();
    
    public ArrayList<Integer> inteiros();
    
    public boolean containsChildDireito(int index);
    
    public boolean containsChildEsquerdo(int index);
    
}
