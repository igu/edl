package ArvoreBinaria;

public class No {

    private Object elem;
    private No childEsquerdo;
    private No childDireito;
    private No pai;

    public No(Object elem, No pai, No childEsquerdo, No childDireito) {
        this.elem = elem;
        this.pai = pai;
        this.childEsquerdo = childEsquerdo;
        this.childDireito = childDireito;
    }

    public Object getElemento() {
        return this.elem;
    }

    public void setElemento(Object elem) {
        this.elem = elem;
    }

    public No getPai() {
        return this.pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }
    
    public No getChildEsquerdo() {
        return this.childEsquerdo;
    }
    
    public void setChildEsquerdo(No childEsquerdo) {
        this.childEsquerdo = childEsquerdo;
    }
    
    public No getChildDireito() {
        return this.childDireito;
    }
    
    public void setChildDireito(No childDireito) {
        this.childDireito = childDireito;
    }

}
