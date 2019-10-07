package ArvoreSimples;

import java.util.Iterator;
import java.util.Vector;

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
        if (pai != null || this.isExternal(v)) {
            pai.removeChild(v);
        } else {
            throw new InvalidNoException("Não é possivel remover :(");
        }
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
        return false;
    }

    @Override
    public int height(No v) {
        if (this.isExternal(v)) {
            return 0;
        } else {
            int h = 0;
            Iterator f = v.children();
            while (f.hasNext()) {
                h = Math.max(h, height((No) f.next()));
            }
            return 1 + h;
        }
    }

    @Override
    public Iterator elements() {
        Vector v = new Vector<No>();
        preOrder(v, raiz, 0);
        return v.iterator();
    }

    @Override
    public Iterator Nos() {
        Vector v = new Vector<No>();
        preOrder(v, raiz, 1);
        return v.iterator();
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
        return v == this.raiz;
    }

    private int profundidade(No v) {
        if (this.raiz == v) {
            return 0;
        } else {
            return (1 + profundidade(v.parent()));
        }
    }

    public void preOrder(Vector v, No n, int mode) {

        if (mode == 1) {
            v.add(n); // caso queira os nos
        } else {
            v.add(n.element()); // caso queira os elementos
        }

        Iterator<No> i = n.children();
        while (i.hasNext()) {
            preOrder(v, i.next(), mode);
        }
    }
}
