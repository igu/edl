package Lista;

public class ListaImpl implements Lista {

    private No sentinelaInicial;
    private No sentinelaFinal;
    private int TAMANHO = 0;
    
    public ListaImpl() {
        this.sentinelaInicial.setProx(new No(null, null));
        this.sentinelaFinal.setAnt(new No(null, null));
    }

    @Override
    public int size() {
        return this.TAMANHO;
    }

    @Override
    public boolean isEmpty() {
        return this.TAMANHO == 0;
    }

    @Override
    public void display() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public No first() {
       return this.sentinelaInicial.getProx();
    }

    @Override
    public No last() {
       return this.sentinelaFinal.getAnt();
    }

    @Override
    public No before(No o) {
        return o.getAnt();
    }

    @Override
    public No after(No o) {
        return o.getProx();
    }

    @Override
    public void replaceElement(No n, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void swapElements(No trocado, No trocador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertBefore(No before, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertAfter(No after, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertFirst(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertLast(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(No n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFirst(No n) {
        return n.getAnt().getAnt() == null;
    }

    @Override
    public boolean isLast(No n) {
        return n.getProx().getProx() == null;
    }

}
