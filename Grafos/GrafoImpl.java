package Grafos;

import java.util.ArrayList;

public class GrafoImpl implements Grafo {

    private Object[][] matriz;
    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;

    public GrafoImpl() {
        this.matriz = new Object[0][0];
        this.vertices = new ArrayList<Vertice>();
        this.arestas = new ArrayList<Aresta>();
    }

    @Override
    public Vertice[] finalVertices(Aresta e) {
        Vertice vertices[] = {e.getV1(), e.getV2()};
        return vertices;
    }

    @Override
    public Vertice oposto(Vertice v, Aresta e) throws EIncidenteException {
        if (v == null || e == null) {
            throw new EIncidenteException("Aresta ou Vertice não existem");
        } else if (v.equals(e.getV1())) {
            return e.getV2();
        } else if (v.equals(e.getV2())) {
            return e.getV1();
        }
        throw new EIncidenteException("Vertice não incidente");
    }

    @Override
    public boolean eAdjacente(Vertice v, Vertice w) {
        for (Aresta e : arestas) {
            if ((e.getV1() == v && e.getV2() == w) || (e.getV1() == w && e.getV2() == v)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void substituirVerticeElem(Vertice v, Object x) {
        v.setEl(x);
    }

    @Override
    public void substituirArestaElem(Aresta e, Object x) {
        e.setEl(x);
    }

    @Override
    public Vertice inserirVertice(Object o) {
        Vertice novo = new Vertice(o);
        vertices.add(novo);
        this.matriz = redimensionar('i');
        return novo;
    }

    public Object[][] redimensionar(char op) {
        Object[][] tempMatriz = new Object[this.vertices.size()][this.vertices.size()];

        int tam = (op == 'i') ? this.matriz.length : this.vertices.size();
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                tempMatriz[i][j] = this.matriz[i][j];
            }
        }

        return tempMatriz;
    }

    @Override
    public Aresta inserirAresta(Vertice v, Vertice w, Object o) {
        Aresta nova = new Aresta(v, w, false, o);

        boolean ares_um = this.matriz[this.vertices.indexOf(v)][this.vertices.indexOf(w)] == null;
        boolean ares_dois = this.matriz[this.vertices.indexOf(w)][this.vertices.indexOf(v)] == null;

        if (ares_um) {
            this.matriz[this.vertices.indexOf(v)][this.vertices.indexOf(w)] = new ArrayList<Aresta>();
        }
        
        if (ares_dois) {
            this.matriz[this.vertices.indexOf(w)][this.vertices.indexOf(v)] = new ArrayList<Aresta>();
        }
        
        ((ArrayList<Aresta>) this.matriz[this.vertices.indexOf(v)][this.vertices.indexOf(w)]).add(nova);
        ((ArrayList<Aresta>) this.matriz[this.vertices.indexOf(w)][this.vertices.indexOf(v)]).add(nova);
        
        this.arestas.add(nova);

        return nova;
    }

    @Override
    public Object removeVertice(Vertice v) {
        Object el = v.getEl();
        this.vertices.remove(v);
        ArrayList<Aresta> ares = this.arestasIncidentes(v);
        for (Aresta a : ares) {
            this.arestas.remove(a);
            a.setEl(null);
            a.setV1(null);
            a.setV2(null);
        }
        v.setEl(null);
        this.matriz = this.redimensionar('x');
        return el;
    }

    @Override
    public Object removeAresta(Aresta e) {

        int i = this.vertices.indexOf(e.getV1());
        int j = this.vertices.indexOf(e.getV2());

        Object el = e.getEl();

        if (e.isHeaded()) {
            ((ArrayList<Aresta>) (ArrayList<Aresta>) this.matriz[j][i]).remove(e);
        } 
        
        ((ArrayList<Aresta>) (ArrayList<Aresta>) this.matriz[i][j]).remove(e);

        e.setV1(null);
        e.setV2(null);
        e.setEl(null);

        this.arestas.remove(e);

        return el;
    }

    @Override
    public ArrayList<Aresta> arestasIncidentes(Vertice v) {
        ArrayList<Aresta> incidentes = new ArrayList();
        for (Aresta e : arestas) {
            if (e.getV1() == v || e.getV2() == v) {
                incidentes.add(e);
            }
        }
        return incidentes;
    }

    @Override
    public ArrayList<Vertice> vertices() {
        return this.vertices;
    }

    @Override
    public ArrayList<Aresta> arestas() {
        return this.arestas;
    }

    @Override
    public Aresta inserirArestaDirecionada(Vertice v, Vertice w, Object o) {
        Aresta nova = new Aresta(v, w, true, o);
        boolean ares = this.matriz[this.vertices.indexOf(v)][this.vertices.indexOf(w)] == null;
        if (ares) {
            this.matriz[this.vertices.indexOf(v)][this.vertices.indexOf(w)] = new ArrayList<Aresta>();
        }
        
        ((ArrayList<Aresta>) this.matriz[this.vertices.indexOf(v)][this.vertices.indexOf(w)]).add(nova);
        this.arestas.add(nova);

        return nova;
    }

    @Override
    public boolean eDirecionado(Aresta e) {
        return e.isHeaded();
    }

    public void displayTabela() {
        for (int i = 0; i < this.matriz.length; i++) {
            System.out.print("\n" + vertices.get(i).getEl() + "|");
            for (int j = 0; j < matriz.length; j++) {
                if (this.matriz[i][j] != null) {
                    System.out.print( ((ArrayList<Aresta>) (this.matriz[i][j])).size() + "|");
                } else {
                    System.out.print("0|");
                }
            }
        }
        System.out.println("");
        System.out.println("Numero de vertices: " + this.vertices.size());
        System.out.println("Numero de arestas: " + this.arestas.size());
    }

}
