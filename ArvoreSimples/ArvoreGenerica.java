package ArvoreSimples;

import java.util.Iterator;

public interface ArvoreGenerica extends Arvore {
       
    public void addChild(No v, Object o);
    public Object remove(No v) throws InvalidNoException;
    
}
