package PilhaLE;

public class PilhaImpl implements Pilha {
	
	
	private No topo = null;
	private int size = 0;
	

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.topo == null; 
	}

	@Override
	public Object top() throws EPilhaVazia {
		if(isEmpty()) throw new EPilhaVazia ("Pilha Vazia :(");
		return this.topo.getElemento();
	}

	@Override
	public void push(Object o) {
		this.topo = new No(o,this.topo);
		size++;
	}

	@Override
	public Object pop() throws EPilhaVazia {
		if(isEmpty()) throw new EPilhaVazia ("Pilha Vazia :(");
		Object lixo = this.topo.getElemento();
		this.topo = this.topo.getProximo();
		this.size--;
		return lixo;
	}

  public void display() {
    No copia = this.topo;
    for(int i = 0; i < this.size(); i++){
      System.out.print("[" + copia.getElemento() + "] -> ");
      copia = copia.getProximo();
    }
    System.out.print("null\n");
  }

}

