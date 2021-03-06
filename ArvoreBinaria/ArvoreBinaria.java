package ArvoreBinaria;

import java.util.ArrayList;

public interface ArvoreBinaria {

    public boolean inserir(Object elem);
    //public No buscar(Object elem, No raiz) throws ElNaoEncontradoException;
    public No buscar(Object elem, No raiz);
    public void remover(Object elem) throws ElNaoEncontradoException;
    public ArrayList<No> nos(int mode);
    public int height(No no);
    public int profundidade(No no);
    public boolean isRoot(No no);
    public boolean containsChildEsquerdo(No no);
    public boolean containsChildDireito(No no);
    public int countChilds(No no);
    public boolean isExternal(No no);
    public void display();
    
}