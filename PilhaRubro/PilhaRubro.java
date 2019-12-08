package PilhaRubro;

public interface PilhaRubro {
	public boolean isEmpty();
	public Object top_vermelho() throws EPilhaVazia;
    public Object top_preto() throws EPilhaVazia;
	public void push_vermelho(Object o);
    public void push_preto(Object o);
	public Object pop_vermelho() throws EPilhaVazia;
    public Object pop_preto() throws EPilhaVazia;
    public void resize();
    public void print_pilha();
}

