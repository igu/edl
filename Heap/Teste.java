package Heap;

public class Teste {

    public static void main(String[] args) {

        HeapImpl nova = new HeapImpl();

        nova.insert(5);
        nova.insert(9);
        nova.insert(7);
        nova.insert(2);
        nova.insert(6);
        
       // nova.removeMin();

        nova.display();
        System.out.println("----------------------");
    }

}