package ArvoreBinaria;

public class Teste {
	public static void main(String[] args) {
		ArvoreBinariaImpl novaTree = new ArvoreBinariaImpl(10);
		
		novaTree.inserir(11);
		novaTree.inserir(8);
		novaTree.inserir(9);
		
		novaTree.nos(1);
		
	}
}
