package PilhaRubro;

public class PilhaRubroArray implements PilhaRubro {
    
    
    // PILHA COLORIDA
    private Object color[];
    
    // TOPO VERMELHO
    private int tam_vermelho = -1;
    
    // TOPO PRETO
    private int tam_preto;
    
    
    // TAMANHO PRETO
    private int size_preto = 0;
    
    // TAMANHO VERMLEHO
    private int size_vermelho = 0;
    
    
    public PilhaRubroArray(int tam){
        this.color = new Object[tam];
        tam_preto = tam;
    }


    @Override
    public boolean isEmpty() {
        return (size_vermelho == 0 && size_preto == 0);
    }

    @Override
    public Object top_vermelho() throws EPilhaVazia {
        if (isEmpty()) throw new EPilhaVazia ("Pilha vermelha vazia");
        return color[tam_vermelho];
    }
    
    @Override
    public Object top_preto() throws EPilhaVazia {
    	if (isEmpty()) throw new EPilhaVazia ("Pilha preta vazia");
        return color[tam_preto];
    }

    @Override
    public void push_vermelho(Object o) {
        if( this.tam_preto - this.tam_vermelho == 1) {
            resize();
	}
        this.color[++tam_vermelho] = o;
        ++size_vermelho;
        
    }
    
    @Override
    public void resize() {
        Object N[] = new Object[this.color.length * 2];
        for(int i = 0; i < this.size_vermelho; i++){
            N[i] = this.color[i];
        }
        for(int i = 0; i < this.size_preto; i++){
            N[ N.length - size_preto + i] = this.color[i + tam_preto];
        }
        this.tam_preto = N.length - size_preto;
        this.color = N;
    }
    

    @Override
    public void push_preto(Object o) {
        if( this.tam_preto - this.tam_vermelho == 1) {
            resize();
	}
        this.color[--tam_preto] = o;
        size_preto++;
    }

    @Override
    public Object pop_vermelho() throws EPilhaVazia {
        if (isEmpty()) throw new EPilhaVazia ("Pilha vazia");
        Object o = color[tam_vermelho];
        color[tam_vermelho--] = null;
        size_vermelho--;
        return o;
    }

   @Override
    public Object pop_preto() throws EPilhaVazia {
	   if (isEmpty()) throw new EPilhaVazia ("Pilha vazia");
       Object o = color[tam_preto];
       color[tam_preto++] = null;
       size_preto--;
       return o;
    }


    @Override
    public void print_pilha() {
       for(int i = 0; i < this.color.length; i++){
           System.out.print(this.color[i] + "\t");
       }
       System.out.println("\n-    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    -    \n");
    }
    
}
