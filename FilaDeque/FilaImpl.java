package FilaDeque;

public class FilaImpl implements Fila {
	
	private Object tadFila[];
	
	private int inicio;
	private int fim;
	
	public FilaImpl(int tam) {
		inicio = 0;
		fim = 0;
		tadFila = new Object[tam];
	}

	@Override
	public int tamanho() {
		return (this.tadFila.length - this.inicio + this.fim) % this.tadFila.length;
	}

	@Override
	public boolean estaVazia() {
		return this.inicio == this.fim;
	}

	@Override
	public Object inicio() throws EFilaVazia {
		if(estaVazia()) throw new EFilaVazia ("Fila está vazia :(");
		return this.tadFila[this.inicio];
	}

	@Override
	public void enfileirar(Object o) {
		if(tamanho() == (this.tadFila.length - 1)) resize();
		this.tadFila[fim++] = o;
		this.fim %= this.tadFila.length;
	}

	@Override
	public Object desenfileirar() throws EFilaVazia {
		if(estaVazia()) throw new EFilaVazia ("Fila totalmente vazia :(");
		Object o = this.tadFila[this.inicio++];
		this.inicio %= this.tadFila.length;
		return o;
	}

	@Override
	public void resize() {
		Object novo[] = new Object[this.tadFila.length * 2];
		int sizeFila = this.tamanho();
		for(int i = this.inicio, j = 0; j != sizeFila; j++, i++) {
			novo[j] = this.tadFila[i % this.tadFila.length];
		}
		this.tadFila = novo;
		this.inicio = 0;
		this.fim = sizeFila;
		
	}

}
