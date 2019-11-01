package Heap;

import java.lang.Math;
import java.util.ArrayList;

public class HeapImpl implements Heap {

    private Object heapArray[];
    private ArrayList<Integer> inteirosHeap;
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
        boolean folha = true, maior_que_ka = true;

        do {
            childRightIndex = 2 * i + 1;
            childLeftIndex = 2 * i;

            if (this.containsChildEsquerdo(i)) {
                if (this.containsChildDireito(i)) {
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
                } else {
                    maior_que_ka = false;
                }
                i = k;
            } else {
                folha = false;
            }           
        } while (folha && maior_que_ka);

        // Downheap termina quando a chave k encontra uma folha ou um nó 
        // cuja chave é maior do que k
    }

    @Override
    public void display() {
        int linhas = (int) ((Math.log(this.size) / Math.log(2))) + 1; // altura
        int colunas = this.size, k = 0;
        int matrix[][] = new int[linhas][colunas];

        ArrayList<Integer> inteiros = this.inteiros();

        while (k < this.size) {
            matrix[(int) (Math.log(inteiros.get(k)) / Math.log(2))][k] = (int) this.heapArray[inteiros.get(k)];
            k++;
        }

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (matrix[i][j] != 0) {
                    System.out.print(matrix[i][j] + "   ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.print("\n");
        }
    }

    @Override
    public ArrayList<Integer> inteiros() {
        this.inteirosHeap = new ArrayList<Integer>();
        this.inOrdem(1);
        return this.inteirosHeap;
    }

    private void inOrdem(int index) {
        if (this.containsChildEsquerdo(index)) {
            this.inOrdem(index * 2);
        }

        this.inteirosHeap.add(index);

        if (this.containsChildDireito(index)) {
            this.inOrdem(index * 2 + 1);
        }
    }

    @Override
    public boolean containsChildDireito(int index) {
        index *= 2 + 1;
        if (index <= this.size) {
            if (this.heapArray[index] != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsChildEsquerdo(int index) {
        index *= 2;
        if (index <= this.size) {
            if (this.heapArray[index] != null) {
                return true;
            }
        }
        return false;
    }
}