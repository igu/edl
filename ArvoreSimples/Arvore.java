package ArvoreSimples;

import java.util.Iterator;

public interface Arvore {
    
    /* Métodos Genéricos */
    public int size();
    public boolean isEmpty();
    public int height();
    public Iterator elements();
    public Iterator Nos();
    
    /* Métodos de acesso */
    public No root();
    public No parent(No v);
    public Iterator children(No v);
    
    
    /* Métodos de consulta */
    public boolean isInternal(No v);
    public boolean isExternal(No v);
    public int depth(No v); 
    
    /* Métodos de atualização */
    public Object replace(No v, Object o);
}
