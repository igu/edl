package edl.Lista;

public interface Lista {

    /*
      ==== METÓDOS GENERICOS ===== 
    */
    
    public int size();
    public boolean isEmpty();
    public void display();
    
    /*
      ==== METÓDOS DE FILA ===== 
    */
    
    public boolean isFirst(No n);
    public boolean isLast(No n);
    
    /*
      ==== METÓDOS PARA ACESSAR ===== 
    */
    
    public No first();
    public No last();
    public No before(No o);
    public No after(No o);
    
    /*
      ==== METÓDOS PARA ATUALIZAR ===== 
    */
    
    public void replaceElement(No n, Object o);
    public void swapElements(No trocado, No trocador);
    public No insertBefore(No before, Object o);
    public No insertAfter(No after, Object o);
    public No insertFirst(Object o);
    public No insertLast(Object o);
    public void remove(No n);
    
}
