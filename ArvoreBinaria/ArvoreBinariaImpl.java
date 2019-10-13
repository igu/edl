package ArvoreBinaria;

import java.util.ArrayList;
import java.util.List;
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
    public boolean inserir(Object elem) {
        if (this.root != null) { // existe um no raiz
           No pai = this.buscar(elem, this.root);
           No novoFilho = new No(elem, null, null, pai);
           if((int) pai.getElemento() == (int) novoFilho.getElemento()) { // n pode igual
        	   return false;
           } else {
        	   if((int) novoFilho.getElemento() < (int) pai.getElemento()) {
        		   pai.setChildEsquerdo(novoFilho);
        	   } else {
        		   pai.setChildDireito(novoFilho);
        	   }
           }
        } else this.root = new No(elem, null, null, null);
        this.size++;
        return true;
    }

    @Override
    public No buscar(Object elem, No raiz) {
        if (this.isExternal(raiz) || (int) elem == (int) raiz.getElemento()) return raiz;
        else if ((int) elem < (int) raiz.getElemento()) return buscar(elem, raiz.getChildEsquerdo());
        else return buscar(elem, raiz.getChildDireito());
    }

    @Override
    public boolean remover(Object elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<No> nos(int mode) {
       this.nosArrayList = new ArrayList<No>();
       
       if(mode == 1) this.preOrdem(this.root);
       else if(mode == 2) this.inOrdem(this.root);
       else if(mode == 3) this.posOrdem(this.root);
       
       return this.nosArrayList;
    }

    @Override
    public int height(No no) {
        if(this.isExternal(no) || no == null) return 0;
        else {
        	int i = 0, h = 0;
        	
        	List<No> childs = new ArrayList<No>();
        	childs.add(no.getChildEsquerdo());
        	childs.add(no.getChildDireito());
        	
        	while(i < childs.size()) {
        		h = Math.max(h, this.height(childs.get(i++)));
        	}
        	return 1 + h;
        }
    }

    @Override
    public int profundidade(No no) {
        if(this.root == no) return 0;
        return 1 + this.profundidade(no.getPai());
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
        return no.getChildDireito() != null;
    }

    @Override
    public int countChilds(No no) {
        if(this.containsChildDireito(no) && this.containsChildEsquerdo(no)) return 2;
        else if(this.isExternal(no)) return 0;
        return 1;
    }

    @Override
    public boolean isExternal(No no) {
        return !(this.containsChildDireito(no) || this.containsChildEsquerdo(no));
    }
    
    private void preOrdem(No no) {
    	this.nosArrayList.add(no);
    	
    	if(this.containsChildEsquerdo(no)) {
    		this.posOrdem(no.getChildEsquerdo());
    	}
    	
    	if(this.containsChildEsquerdo(no)) {
    		this.posOrdem(no.getChildDireito());
    	}
    }
    
    private void inOrdem(No no) {
    	if(this.containsChildEsquerdo(no)) {
    		this.posOrdem(no.getChildEsquerdo());
    	}
    	
    	this.nosArrayList.add(no);
    	
    	if(this.containsChildEsquerdo(no)) {
    		this.posOrdem(no.getChildDireito());
    	}
    }
    
    private void posOrdem(No no) {
    	if(this.containsChildEsquerdo(no)) {
    		this.posOrdem(no.getChildEsquerdo());
    	}
    	
    	if(this.containsChildEsquerdo(no)) {
    		this.posOrdem(no.getChildDireito());
    	}
    	
    	this.nosArrayList.add(no);
    }
    
    @Override
    public void display() {
        /* FALTA IMPLEMENTAR */
    }
    
}