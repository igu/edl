package Lista;

public class No {
    
    private No prox;
    private No ant;
    private Object o;
    
    public No(No prox, No ant, Object o) {
        this.prox = prox;
        this.ant = ant;
        this.o = o;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public No getAnt() {
        return ant;
    }

    public void setAnt(No ant) {
        this.ant = ant;
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }
    
    public No(No prox, No ant) {
        this.prox = prox;
        this.ant = ant;
    }
    
}
