package Pilha;

public class PilhaArray implements Pilha {
	
	// OBJECT
	private Object S[];
	
	// TAMANHO
	private int t = -1;
	
	public PilhaArray(int tam) {
		this.S = new Object[tam];
	}

	@Override
	public int size() {
		return this.t + 1;
	}
	
	public int tamanho() {
		return this.S.length;
	}

	@Override
	public boolean isEmpty() {
		return this.t < 0;
	}

	@Override
	public Object top() throws EPilhaVazia {
		if (isEmpty()) throw new EPilhaVazia ("Pilha vazia"); 
		return this.S[t];
	}

	@Override
	public void push(Object o) {
		if( this.t == (this.S.length - 1)) {
			Object N[] = new Object[this.S.length * 2];
			for(int i = 0; i < this.S.length; i++) {
				N[i] = this.S[i];
			}
			this.S = N;
		}
		this.S[++t] = o;
	}

	@Override
	public Object pop() throws EPilhaVazia {
		if (isEmpty()) throw new EPilhaVazia ("Pilha vazia"); 
		return this.S[t--];
	}

}
