package ArvoreBinaria;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArvoreBinariaImpl implements ArvoreBinaria {
    
    private No root = null;
    private ArrayList<No> nosArrayList = null; 
    private int size = 0;
    
    public ArvoreBinariaImpl() { } // Arvore iniciando sem raiz
    
    public ArvoreBinariaImpl(Object elem) { // Arvore iniciando com raiz
        this.root = new No(elem, null, null, null);
        this.size++;
    }
    
    @Override
    public void inserir(Object elem) {
        if (this.root != null) { // existe um no raiz
           No pai;
            try {
                pai = this.buscar(elem);
            } catch (ElNaoEncontradoException ex) {
                System.out.println("Elemento não encontrado");
            }
           No novoNo = new No(elem, null, null, pai);
        } else {
           this.root = new No(elem, null, null, null);
           this.size++;
        }
    }

    @Override
    public No buscar(Object elem) throws ElNaoEncontradoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Object elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<No> nos(int mode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int height(No no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int profundidade(No no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isRoot(No no) {
        return this.root == no;
    }

    @Override
    public boolean containsChildEsquerdo(No no) {
        return no.getChildEsquerdo() != null;
    }

    @Override
    public boolean containsChildDireito(No no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countChilds(No no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isExternal(No no) {
        return this.containsChildDireito(no) || this.containsChildEsquerdo(no);
    }

    @Override
    public void display() {
        /* FALTA IMPLEMENTAR */
    }
    
}