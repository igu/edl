package PilhaLE;

public class Teste {
	public static void main(String[] args) throws EPilhaVazia {
		PilhaImpl nova = new PilhaImpl();
	
	
		nova.push(111);
		nova.push(2);
	
		System.out.println(nova.size());
	
		nova.display();
	
		nova.pop();
	
		System.out.println(nova.size());
	
		nova.display();
	
		nova.pop();
	
		nova.display();
	
	  }
}
