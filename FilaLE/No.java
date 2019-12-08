package FilaLE;

public class No {
	private Object elemento;
	private No proximo;
	
	public No(Object o, No proximo) {
		this.elemento = o;
		this.proximo = proximo;
	}
	
	public Object getElemento() {
		return this.elemento;
	}
	
	public void setElemento(Object o) {
		this.elemento = o;
	}
	
	public No getProximo() {
		return this.proximo;
	}
	
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
}
