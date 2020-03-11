
package ArvoreAVL;

import ArvoreBinaria.ElNaoEncontradoException;

public class Teste {

    public static void main(String[] args) throws ElNaoEncontradoException {
        ArvoreAvllmpl nova = new ArvoreAvllmpl();
        
        nova.inserir(50);
        nova.inserir(90);
        nova.inserir(20);
        nova.inserir(40);
        nova.inserir(10);
        nova.inserir(30);
        nova.inserir(62);
        
        
        nova.displayAVL();
        
        nova.remover(62);
        
        System.out.println("----- POS EXCLUSAO -----");
        
       	nova.displayAVL();
        
    }
    
}
