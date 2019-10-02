package ArvoreSimples;

import java.util.Iterator;

public class ArvoreSimples implements ArvoreGenerica {

    private No raiz;
    private int tamanho;
    
    public ArvoreSimples(Object o) {
        this.raiz = new No(null, o);
        tamanho = 1;
    }
    
    @Override
    public void addChild(No v, Object o) {
        v.addChild(new No(v, o));
        this.tamanho++;
    }

    @Override
    public Object remove(No v) throws InvalidNoException {
        No pai = v.parent();
        if (pai != null || this.isExternal(v)) pai.removeChild(v);
        else throw new InvalidNoException("Vector não existe :(");
        Object o = v.element();
        this.tamanho--;
        return o;
    }
    
    public void swapElements(No v, No w) {
        Object aux = v.element();
        v.setElement(w.element());
        w.setElement(aux);
    }

    @Override
    public int size() {
        return this.tamanho;
    }

    @Override
    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    @Override
    public int height() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator elements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator Nos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public No root() {
        return this.raiz;
    }

    @Override
    public No parent(No v) {
        return v.parent();
    }

    @Override
    public Iterator children(No v) {
        return v.children();
    }

    @Override
    public boolean isInternal(No v) {
        return v.childrenNumber() > 0;
    }

    @Override
    public boolean isExternal(No v) {
        return v.childrenNumber() == 0;
    }

    @Override
    public int depth(No v) {
        return profundidade(v);
    }

    @Override
    public Object replace(No v, Object o) {
       v.setElement(o);
       return v.element();
    }
    
    public boolean isRoot(No v) {
        return  v == this.raiz;
    }
    
    private int profundidade(No v) {
        if(this.raiz == v) return 0;
        else return (1 + profundidade(v.parent()));
    }
    
}
