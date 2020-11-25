package Grafos;


public class Teste {
    public static void main(String[] args) {
        GrafoImpl grafo = new GrafoImpl();
        
        
        Vertice v1 = grafo.inserirVertice("v1");
        Vertice v2 = grafo.inserirVertice("v2");
        
        Vertice v3 = grafo.inserirVertice("v3");
        Vertice v4 = grafo.inserirVertice("v4");
        
        Vertice v5 = grafo.inserirVertice("v5");
        Vertice v6 = grafo.inserirVertice("v6");
        
        Aresta a = grafo.inserirAresta(v1, v3, 2);
        Aresta b = grafo.inserirAresta(v2, v4, 2);
       //  Aresta c = grafo.inserirAresta(v5, v6, 0);
        Aresta c = grafo.inserirArestaDirecionada(v5, v6, 0);
        
        Aresta d = grafo.inserirAresta(v1, v1, 0);
        
        grafo.displayTabela();
        
        // grafo.removeVertice(v1);
        
        System.out.println("-------");
        
        grafo.displayTabela();
        
        
        System.out.println("-------");
        
        System.out.println(a.isHeaded());
        System.out.println(c.isHeaded());
        
        System.out.println("POS DROP ARESTA D");
        
        grafo.removeAresta(d);
        grafo.displayTabela();
        
    }
}
