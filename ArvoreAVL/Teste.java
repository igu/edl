
package ArvoreAVL;


public class Teste {

    public static void main(String[] args) {
        ArvoreAvllmpl nova = new ArvoreAvllmpl();
        
        nova.inserir(50);
        nova.inserir(70);
        nova.inserir(20);
        nova.inserir(30);
        nova.inserir(10);
        
        nova.displayAVL();
        
    }
    
}
