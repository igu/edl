package Grafos;

public class Aresta {
    
    /*
            NOMECLATURA
        V1 = VERTICE INICIAL
        V2 = VERTICE FINAL
        isHeaded = É direcionado
    
    */
    
    private Vertice v1 = null;
    private Vertice v2 = null;
    private boolean isHeaded;
    private Object el;
    
    public Aresta (Vertice v1, Vertice v2, boolean isHeaded, Object el) {
        this.v1 = v1;
        this.v2 = v2;
        this.isHeaded = isHeaded;
        this.el = el;
    }

    public Vertice getV1() {
        return v1;
    }

    public void setV1(Vertice v1) {
        this.v1 = v1;
    }

    public Vertice getV2() {
        return v2;
    }

    public void setV2(Vertice v2) {
        this.v2 = v2;
    }

    public boolean isHeaded() {
        return isHeaded;
    }

    public void setIsHeaded(boolean isHeaded) {
        this.isHeaded = isHeaded;
    }

    public Object getEl() {
        return el;
    }

   
    public void setEl(Object el) {
        this.el = el;
    }
    
}
