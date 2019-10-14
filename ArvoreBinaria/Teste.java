package ArvoreBinaria;

public class Teste {
	public static void main(String[] args) {
		ArvoreBinariaImpl novaTree = new ArvoreBinariaImpl(25);
		
		novaTree.inserir(20);
		novaTree.inserir(18);
		novaTree.inserir(25);
		novaTree.inserir(15);
		novaTree.inserir(23);
		novaTree.inserir(28);
		novaTree.inserir(31);
		novaTree.inserir(22);
		novaTree.inserir(21);
		novaTree.inserir(24);
		
		novaTree.display();
		
		
		System.out.println("-----------------------------------" + novaTree.getSize());
		
		try {
			novaTree.remover(20);
		} catch (ElNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		novaTree.display();
		
		System.out.println("-----------------------------------" + novaTree.getSize());
		
	}
}
