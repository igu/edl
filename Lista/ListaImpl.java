package edl.Lista;

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
        No copy = this.sentinelaInicial;
        System.out.println(copy.getO() + " (S.I) => ");  // IMPRIME NÓ SENTINELA INICIAL
        for(int i = 0; i < this.TAMANHO; i++) {
        	System.out.print(copy.getO() + " => ");
        	copy = copy.getProx();
        }
        System.out.print(copy.getO() + " (S.F)\n"); // IMPRIME NÓ SENTINELA FINAL
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
        n.setO(o);
    }

    @Override
    public void swapElements(No trocado, No trocador) {
        Object mov = trocado.getO();
        trocado.setO( trocador.getO() );
        trocador.setO( mov );
    }

    @Override
    public No insertBefore(No before, Object o) {
        No novi = new No(before, before.getAnt(), o);
        before.getAnt().setProx(novi);
        before.setAnt(novi);
        this.TAMANHO++;
        return novi;
    }

    @Override
    public No insertAfter(No after, Object o) {
        No novi = new No(after.getProx(), after, o);
        after.getProx().setAnt(novi);
        after.setProx(novi);
        this.TAMANHO++;
        return novi;
    }

    @Override
    public No insertFirst(Object o) {
        No novi = new No(this.sentinelaInicial.getProx(), this.sentinelaInicial, o);
        this.sentinelaInicial.getProx().setAnt(novi);
        this.sentinelaInicial.setProx(novi);
        this.TAMANHO++;
        return novi;
    }

    @Override
    public No insertLast(Object o) {
        No novi = new No(this.sentinelaFinal, this.sentinelaFinal.getAnt(), o);
        this.sentinelaFinal.getAnt().setProx(novi);
        this.sentinelaFinal.setAnt(novi);
        this.TAMANHO++;
        return novi;
    }

    @Override
    public void remove(No n) {
        n.getAnt().setProx(n.getProx());
        n.getProx().setAnt(n.getAnt());
        n.setAnt(null); // JAVA N PRECISA
        n.setProx(null); // JAVA N PRECISA
        this.TAMANHO--;
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
