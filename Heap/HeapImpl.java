package Heap;

public class HeapImpl implements Heap {

    private Object heapArray[];
    private int size;

    public HeapImpl() {
        this.size = 0;
        this.heapArray = new Object[1000];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void insert(Object o) {
        this.heapArray[++this.size] = (int) o;
        this.upHeap();
    }

    @Override
    public void upHeap() {
        int i = this.size;
        // Upheap termina quando a chave k encontra o nó raiz ou um nó cujo pai possua uma chave menor ou igual a k
        while (i != 1 && ((int) this.heapArray[i]) <= ((int) this.heapArray[i / 2])) {
            int aux = (int) this.heapArray[i];
            this.heapArray[i] = this.heapArray[i / 2];
            this.heapArray[i / 2] = aux;
            i /= 2;
        }
    }

    @Override
    public void removeMin() {
        this.heapArray[1] = this.heapArray[this.size--];
        this.downHeap();
    }

    @Override
    public void downHeap() {
        int i = 1, k;
        int childRightIndex;
        int childLeftIndex;

        do {
            childRightIndex = 2 * i + 1;
            childLeftIndex = 2 * i;
            if (childRightIndex <= this.size) {
                if ((int) this.heapArray[childRightIndex] < (int) this.heapArray[childLeftIndex]) {
                    k = childRightIndex;
                } else {
                    k = childLeftIndex;
                }
            } else {
                k = childLeftIndex;
            }

            if (((int) this.heapArray[k]) < ((int) this.heapArray[i])) {
                int aux = (int) this.heapArray[k];
                this.heapArray[k] = (int) this.heapArray[i];
                this.heapArray[i] = aux;
            }

            i = k;
        } while (childLeftIndex < this.size);

        // Downheap termina quando a chave k encontra uma folha 
        // ou um nó cuja chave é maior do que k
    }

    @Override
    public void display() {

    }
}
