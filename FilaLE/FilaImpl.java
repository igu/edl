package FilaLE;

public class FilaImpl implements Fila {

	
	private int size = 0;
	
	private No inicio = null;
	private No fim = null;
	
	@Override
	public int tamanho() {
		return size;
	}

	@Override
	public boolean estaVazia() {
		return size == 0;
	}

	@Override
	public Object inicio() throws EFilaVazia {
		if(estaVazia()) throw new EFilaVazia ("Fila está vazia :(");
		return inicio;
	}

	@Override
	public void enfileirar(Object o) {
		if(this.inicio == null) {
			this.inicio = new No(o, null);
			this.fim = this.inicio;
		} else {
			this.fim.setProximo(new No(o,null));
			this.fim = this.fim.getProximo();
		}
		this.size++;
	}

	@Override
	public Object desenfileirar() throws EFilaVazia {
		if(estaVazia()) throw new EFilaVazia ("Fila está vazia :(");
		No lixo = this.inicio;
		this.inicio = this.inicio.getProximo();
		this.size--;
		return lixo;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
