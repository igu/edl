package ArvoreAVL;

import ArvoreBinaria.ArvoreBinariaImpl;
import ArvoreBinaria.No;
import static java.lang.Math.max;
import static java.lang.Math.min;
import java.util.ArrayList;

public class ArvoreAvllmpl extends ArvoreBinariaImpl implements ArvoreAvl {
    

    public boolean inserir(Object elem) {
        if (this.root != null) {
            NoAVL pai = (NoAVL) this.buscar(elem, root);
            if (pai.getElemento() == elem) {
                return false; // ELEMENTO JÁ CONTIDO
            }
            NoAVL novoFilho = new NoAVL(elem, pai, null, null, 0);

            if ((int) pai.getElemento() > (int) novoFilho.getElemento()) {
                pai.setChildEsquerdo(novoFilho);
            } else {
                pai.setChildDireito(novoFilho);
            }

            this.attFb(novoFilho, "INSERT");

            this.size++;
            return true;
        }

        this.root = new NoAVL(elem, null, null, null, 0);
        this.size++;
        return true;
    }

    @Override
    public void attFb(NoAVL no, String op) {

    
        if (this.isRoot(no)) return;
 
        int fatorPai = ((NoAVL) no.getPai()).getFatorB();
        if ((int) no.getPai().getElemento() < (int) no.getElemento()) {
            ((NoAVL) no.getPai()).setFatorB((op.equals("INSERT") ? --fatorPai : ++fatorPai));
        } else {
            ((NoAVL) no.getPai()).setFatorB((op.equals("INSERT") ? ++fatorPai : --fatorPai));
        }

        if (((NoAVL) no.getPai()).getFatorB() > 1 || ((NoAVL) no.getPai()).getFatorB() < -1) {
            this.balancear( (NoAVL) no.getPai() );
        } else {
            if (op.equals("INSERT")) {
                if (((NoAVL) no.getPai()).getFatorB() == 0) return;
            } else {
                if (((NoAVL) no.getPai()).getFatorB() != 0) return;
            }
            this.attFb((NoAVL) no.getPai(), op); // recusao
        }   
    }
    
    @Override
	public void balancear(NoAVL noDesregulado) {
    	

    	if(noDesregulado.getFatorB() == -2) {
    		
    		if( ((NoAVL) noDesregulado.getChildDireito()).getFatorB() > 0  ) {
    			// ROTACAO DUPLA ESQUERDA
    			this.rotSimRight( (NoAVL) noDesregulado.getChildDireito() );
    			this.rotSimLeft(noDesregulado); 
    		} else {
    			this.rotSimLeft(noDesregulado);
    		}

    	} else {
    		if( ((NoAVL) noDesregulado.getChildEsquerdo()).getFatorB() < 0  ) {
    			// ROTACAO DUPLA DIREITA
    			this.rotSimLeft( (NoAVL) noDesregulado.getChildEsquerdo() ); 
    			this.rotSimRight(noDesregulado);
    		} else {
    			this.rotSimRight(noDesregulado);
    		}
    	}
    	
		
	}

    @Override
    public void rotSimLeft(NoAVL noDesregulado) {
        
        NoAVL noA = noDesregulado;
        NoAVL noB = (NoAVL) noDesregulado.getChildDireito();
        
        noB.setPai ( noA.getPai() );
        if( this.containsChildEsquerdo(noB) ) {
            noB.getChildEsquerdo().setPai( noA );
        }
        noA.setChildDireito( noB.getChildEsquerdo() );
        noB.setChildEsquerdo( noA );
        noA.setPai( noB );
        
        int fb_a_novo = noB.getFatorB() + 1 - max(noA.getFatorB(), 0);
        int fb_b_novo = noA.getFatorB() + 1 - min(noB.getFatorB(), 0);
        
        noA.setFatorB(fb_b_novo);
        noB.setFatorB(fb_a_novo);
        
        if( noDesregulado == this.root) {
            this.root = noB;
        }
    	
    }

    @Override
    public void rotSimRight(NoAVL noDesregulado) {
       
        NoAVL noA = noDesregulado;
        NoAVL noB = (NoAVL) noDesregulado.getChildEsquerdo();
        
        noB.setPai ( noA.getPai() );
        if( this.containsChildDireito(noB) ) {
            noB.getChildDireito().setPai( noA );
        }
        noA.setChildEsquerdo( noB.getChildDireito() );
        noB.setChildDireito( noA );
        noA.setPai( noB );
        
        int fb_a_novo = noA.getFatorB() - 1 - max(noB.getFatorB(), 0);
        int fb_b_novo = noB.getFatorB() - 1 + min(noA.getFatorB(), 0);
                
        noA.setFatorB(fb_b_novo);
        noB.setFatorB(fb_a_novo);
        
        if( noDesregulado == this.root) {
            this.root = noB;
        }
        
    }

    @Override
    public void displayAVL() {
        
        
        int k = 0, colunas = this.size, linhas = this.height(this.root) + 1;
    	String matrix[][] = new String[linhas][colunas];
    	ArrayList<No> nosContains = this.nos(2);
    	while(k < this.size) {
                String fb = "[" + ((NoAVL) nosContains.get(k)).getFatorB() + "]";
    		matrix[ this.profundidade( nosContains.get(k)) ][ k ] =  (int) nosContains.get(k).getElemento() + fb;
    		k++;
    	}
    	
    	 for(int i = 0; i < linhas; i++) {
             for(int j = 0; j < colunas; j++) {
                 if(matrix[i][j] != null) System.out.print(matrix[i][j]); 
                 else System.out.print("   ");
             }
             System.out.print("\n");
         }

    }

}
