package Pilha;

public interface Pilha {
	public int size();
	public boolean isEmpty();
	public Object top() throws EPilhaVazia;
	public void push(Object o);
	public Object pop() throws EPilhaVazia;
}
