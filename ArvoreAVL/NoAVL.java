package ArvoreAVL;

import ArvoreBinaria.No;

public class NoAVL extends No {
	
	private int fatorB;

	public NoAVL(Object elem, No pai, No childEsquerdo, No childDireito, int fatorB) {
		super(elem, pai, childEsquerdo, childDireito);
		this.setFatorB(fatorB);
	}

	public int getFatorB() {
		return fatorB;
	}

	public void setFatorB(int fatorB) {
		this.fatorB = fatorB;
	}

}
