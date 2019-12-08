package FilaDeque;

public class Teste {
	public static void main(String[] args) throws EFilaVazia {
		FilaImpl teste = new FilaImpl(8);
		
		teste.enfileirar(0);
		teste.enfileirar(1);
		teste.enfileirar(2);
		teste.enfileirar(3); 
		teste.enfileirar(4); // lotou
		
		teste.desenfileirar();
		teste.desenfileirar();
		teste.desenfileirar();
		
		teste.enfileirar(5);
		teste.enfileirar(6);
		teste.enfileirar(7);
		teste.enfileirar(8);
		teste.enfileirar(9);
		teste.enfileirar(10);
		
	}
}
