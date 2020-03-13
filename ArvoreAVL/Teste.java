
package ArvoreAVL;

import ArvoreBinaria.ElNaoEncontradoException;

public class Teste {

    public static void main(String[] args) throws ElNaoEncontradoException {
        ArvoreAvllmpl nova = new ArvoreAvllmpl();
        
        nova.inserir(1);
        nova.inserir(2);
        nova.inserir(3);
        nova.inserir(4);
        nova.inserir(5);
        nova.inserir(6);
        nova.inserir(7);
        nova.inserir(8);
        
        nova.displayAVL();
        
        
        System.out.println("----- POS EXCLUSAO -----");
        nova.remover(5);
       	nova.displayAVL();
       	
       	System.out.println("----- POS EXCLUSAO -----");
        nova.remover(2);
       	nova.displayAVL();
       	
       	System.out.println("----- POS EXCLUSAO -----");
        nova.remover(4);
       	nova.displayAVL();
  
        
    }
    
}
