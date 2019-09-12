package edl.Sequencia;

import edl.Lista.No;
import edl.Vector.EVectorNotExists;

public class SequenciaImpl implements Sequencia {
	
    private No sentinelaInicial;
    private No sentinelaFinal;
    private int TAMANHO = 0;
    
    public SequenciaImpl () {
    	this.sentinelaInicial.setProx(new No(null, null));
        this.sentinelaFinal.setAnt(new No(null, null));
    }

	@Override
	public int size() {
		return this.TAMANHO;
	}

	@Override
	public boolean isEmpty() {
		return this.TAMANHO == 0;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
	}

	@Override
	public No atRank(int rank) {
		No node;
		if(rank <= size() / 2) {
			node = this.sentinelaInicial.getProx();
			for(int i = 0; i < rank; i++) {
				node = node.getProx();
			}
		}else {
			node = this.sentinelaFinal.getAnt();
			for(int i = 0; i < (size() - rank - 1); i++) {
				node = node.getAnt();
			}
		}
		return node;
	}

	@Override
	public int rankOf(No no) {
		No n = this.sentinelaInicial.getProx();
		int r = 0; // ASK TO COLEGUINHA ABOUT R INICIALIZED WITH 0
		while(n != no && n != this.sentinelaFinal) {
			n = n.getProx();
			r++;
		}
		return r;
	}

	@Override
	public boolean isFirst(No n) {
		return n.getAnt().getAnt() == null;
	}

	@Override
	public boolean isLast(No n) {
		return n.getProx().getProx() == null;
	}

	@Override
	public No first() {
		return this.sentinelaInicial.getProx();
	}

	@Override
	public No last() {
		return this.sentinelaFinal.getAnt();
	}

	@Override
	public No before(No o) {
		return o.getAnt();
	}

	@Override
	public No after(No o) {
		return o.getProx();
	}

	@Override
	public void replaceElement(No n, Object o) {
		n.setO(o);
	}

	@Override
	public void swapElements(No trocado, No trocador) {
		Object aux = trocado.getO();
		trocado.setO(trocador.getO());
		trocador.setO(aux);
	}

	@Override
	public No insertBefore(No before, Object o) {
		No no = new No(before, before.getAnt(), o);
		before.getAnt().setProx(no);
		before.setAnt(no);
		this.TAMANHO++;
		return no;
	}

	@Override
	public No insertAfter(No after, Object o) {
		No no = new No(after.getProx(), after, o);
		after.getProx().setAnt(no);
		after.setProx(no);
		return no;
	}

	@Override
	public No insertFirst(Object o) {
		No no = new No(this.sentinelaInicial.getProx(), this.sentinelaInicial, o);
		this.sentinelaInicial.getProx().setAnt(no);
		this.sentinelaInicial.setProx(no);
		this.TAMANHO++;
		return no;
	}

	@Override
	public No insertLast(Object o) {
		No no = new No(this.sentinelaFinal, this.sentinelaFinal.getAnt(), o);
		this.sentinelaFinal.getAnt().setProx(no);
		this.sentinelaFinal.setAnt(no);
		this.TAMANHO++;
		return no;
	}

	@Override
	public void remove(No n) {
		n.getAnt().setProx(n.getProx());
		n.getProx().setAnt(n.getAnt());
		n.setAnt(null);
		n.setProx(null);
		this.TAMANHO--;
	}

	@Override
	public Object elemAtRank(int r) throws EVectorNotExists {
		try {
			return this.atRank(r).getO();
		} catch(Exception e ) {
			throw new EVectorNotExists("Vector não existe :(");
		}
	}

	@Override
	public Object replaceAtRank(int r, Object o) throws EVectorNotExists {
		try {
			No no = this.atRank(r);
			Object value = no.getO();
			this.replaceElement(no, o);
			return value;
		} catch (Exception e) { 
			throw new EVectorNotExists("Vector não existe :(");
		}
	}

	@Override
	public void insertAtRank(int r, Object o) throws EVectorNotExists {
		try {
			No no = this.atRank(r);
			this.insertBefore(no, o);
		} catch (Exception e) {
			throw new EVectorNotExists("Vector não existe :(");
		}
	}

	@Override
	public Object removeAtRank(int r) throws EVectorNotExists {
		try {
			No no = this.atRank(r);
			Object value = no.getO();
			this.remove(no);
			return value;
		} catch (Exception e ) {
			throw new EVectorNotExists("Vector não existe :(");
		}
	}
	
}