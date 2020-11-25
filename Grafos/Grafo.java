package Grafos;

import java.util.ArrayList;

public interface Grafo {
    public Vertice[] finalVertices(Aresta e);
    public Vertice oposto(Vertice v, Aresta e) throws EIncidenteException;
    public boolean eAdjacente(Vertice v, Vertice w);
    public void substituirVerticeElem(Vertice v, Object x);
    public void substituirArestaElem(Aresta e, Object x);
    public Vertice inserirVertice(Object o);
    public Aresta inserirAresta(Vertice v, Vertice w, Object o);
    public Aresta inserirArestaDirecionada(Vertice v, Vertice w, Object o);
    public Object removeVertice(Vertice v);
    public Object removeAresta(Aresta e);
    public ArrayList<Aresta> arestasIncidentes(Vertice v);
    public boolean eDirecionado(Aresta e);
    public ArrayList<Vertice> vertices();
    public ArrayList<Aresta> arestas();
}
