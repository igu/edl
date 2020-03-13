package ArvoreAVL;

import ArvoreBinaria.ArvoreBinariaImpl;
import ArvoreBinaria.ElNaoEncontradoException;
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

    public void remover(Object elem) throws ElNaoEncontradoException {
    	if(this.root != null) { // arvore vazia
        	NoAVL exclusao = (NoAVL) this.buscar(elem, this.root);
        	
        	if((int) elem == (int) exclusao.getElemento()) {
        		if(this.countChilds(exclusao) == 0) { // EXCLUIR NÓ SEM FILHOS
        			if(this.root == exclusao) { this.root = null; }
        			else {
        				
        				this.attFb( (NoAVL) exclusao, "NO-INSERT"); // ATT-FB
        				
        				if(exclusao.getPai().getChildDireito() == exclusao) 
        					exclusao.getPai().setChildDireito(null);
        				else 
        					exclusao.getPai().setChildEsquerdo(null);
        				
        				exclusao.setPai(null);	
        			}
        			this.size--;
        		}else if(this.countChilds(exclusao) == 1) { // EXCLUIR NÓ COM UM FILHO
        			
        			NoAVL filhoOcupaPai;
        			
        			if(this.root == exclusao) { // excluir raiz
        				
        				filhoOcupaPai = (this.containsChildDireito(this.root)) 
        						? 		(NoAVL) this.root.getChildDireito() 
        					    : 		(NoAVL) this.root.getChildEsquerdo(); 
        				
        				filhoOcupaPai.setPai(null);
        				
        				this.attFb( (NoAVL) exclusao, "NO-INSERT"); // ATT-FB
        				
        				this.root = filhoOcupaPai;
        			} else {
        				
        				this.attFb( (NoAVL) exclusao, "NO-INSERT"); // ATT-FB
        				
        				filhoOcupaPai = (this.containsChildDireito(exclusao)) 
        						? 		(NoAVL) exclusao.getChildDireito() 
        					    : 		(NoAVL) exclusao.getChildEsquerdo();
        						
        				filhoOcupaPai.setPai(exclusao.getPai());	
        				
        				if (exclusao.getPai().getChildDireito() == exclusao) 
        					exclusao.getPai().setChildDireito(filhoOcupaPai);
        				else 
        				    exclusao.getPai().setChildEsquerdo(filhoOcupaPai);
        				
        				
        				exclusao.setPai(null);
        				exclusao.setChildDireito(null);
        				exclusao.setChildEsquerdo(null);
        			}
        			this.size--;
        		}else if(this.countChilds(exclusao) == 2) { // EXCLUIR NÓ COM DOIS FILHOS 
        			/* pecorrer até encontrar o menor elemento dir/last esq */
        			No aux = exclusao.getChildDireito();
        			while(aux.getChildEsquerdo() != null) {
        				aux = aux.getChildEsquerdo();
        			}	
        			int elementoLastChild = (int) aux.getElemento();
        			this.remover(elementoLastChild);
        			exclusao.setElemento(elementoLastChild);
        		}
        	} else throw new ElNaoEncontradoException("Elemento não contido na arvore binaria");
        }
    }
    
    @Override
    public void attFb(NoAVL no, String op) {
    	
    	
    	if ( op.equals("INSERT") ) {
    		
    		if ( no == null || this.isRoot(no) ) return;
    		
    		if ((int) no.getElemento() > (int) no.getPai().getElemento()  ) {
                ((NoAVL) no.getPai()).setFatorB( ((NoAVL) no.getPai()).getFatorB() - 1 );
            } else {
            	((NoAVL) no.getPai()).setFatorB( ((NoAVL) no.getPai()).getFatorB() + 1 );
            }
    		
    		if (((NoAVL) no.getPai()).getFatorB() != 0) {
    			if ( ((NoAVL) no.getPai()).getFatorB() < -1 || ((NoAVL) no.getPai()).getFatorB() > 1) {
    				this.balancear( (NoAVL) no.getPai(), op);
    			} else {
    				this.attFb( (NoAVL) no.getPai(), op);
    			}
    		}
    		
    		
    		
    		
    	} else {
    		
    		
    		if ( no == null || this.isRoot(no) ) return;
    		
    		if ((int) no.getElemento() > (int) no.getPai().getElemento()  ) {
                ((NoAVL) no.getPai()).setFatorB( ((NoAVL) no.getPai()).getFatorB() + 1 );
            } else {
            	((NoAVL) no.getPai()).setFatorB( ((NoAVL) no.getPai()).getFatorB() - 1 );
            }
    		
    		if ( ((NoAVL) no.getPai()).getFatorB() < -1 || ((NoAVL) no.getPai()).getFatorB() > 1) {
				this.balancear( (NoAVL) no.getPai(), op);
			}  else {
				if (((NoAVL) no.getPai()).getFatorB() == 0) {
					this.attFb( (NoAVL) no.getPai(), op);
				}
			}
    		
    	}

    }
    
    @Override
	public void balancear(NoAVL noDesregulado, String op) {
    	
    	NoAVL no;

    	if(noDesregulado.getFatorB() == -2) {
    		
    		if( noDesregulado.getChildDireito() != null &&((NoAVL) noDesregulado.getChildDireito()).getFatorB() > 0  ) {
    			// ROTACAO DUPLA ESQUERDA
    		//	System.out.println("ROTACAO DUPLA ESQUERDA");
    		//	System.out.println("NoDesregulado: " + noDesregulado.getElemento());
    		//	System.out.println("FatorB: " + noDesregulado.getFatorB());
    		//	System.out.println("SubArvoreDireita: " + noDesregulado.getChildDireito().getElemento() );
    			no = this.rotSimRight( (NoAVL) noDesregulado.getChildDireito() );
    		}
	    	//	System.out.println("------------- ROT SIMPLES ESQUERDA ----------");
			//	System.out.println("SubArvoreEsquerda POS ROT: " + noDesregulado.getChildEsquerdo().getElemento() );
    			no = this.rotSimLeft(noDesregulado); 

    	} else {
    		if( noDesregulado.getChildEsquerdo() != null && ((NoAVL) noDesregulado.getChildEsquerdo()).getFatorB() < 0  ) {
    			// ROTACAO DUPLA DIREITA
    			System.out.println("ROTACAO DUPLA DIREITA");
    			System.out.println("NoDesregulado: " + noDesregulado.getElemento());
    			System.out.println("FatorB: " + noDesregulado.getFatorB());
    			System.out.println("SubArvoreEsquerda: " + noDesregulado.getChildEsquerdo().getElemento() );
    			no = this.rotSimLeft( (NoAVL) noDesregulado.getChildEsquerdo() );
    		}
    			System.out.println("------------- ROT SIMPLES DIREITA ----------");
    			System.out.println("SubArvoreDireita POS ROT: " + noDesregulado.getChildDireito().getElemento() );
    			no = this.rotSimRight(noDesregulado);
    	}
    	
    	if( op.equals("NO-INSERT") ) {
    		this.attFb(no, op);
    	}
    	
    }
    	

    @Override
    public NoAVL rotSimLeft(NoAVL noDesregulado) {
        
        NoAVL noA = noDesregulado;
        NoAVL noB = (NoAVL) noDesregulado.getChildDireito();
        
        noB.setPai ( noA.getPai() );
        if( this.containsChildEsquerdo(noB) ) {
            noB.getChildEsquerdo().setPai( noA );
        }
        noA.setChildDireito( noB.getChildEsquerdo() );
        noB.setChildEsquerdo( noA );
        noA.setPai( noB );
        
        int fb_a_novo = noA.getFatorB() + 1 - min(noB.getFatorB(), 0);
        // FB_B_novo= FB_B + 1 - min(FB_A, 0); 
        int fb_b_novo = noB.getFatorB() + 1 + max(fb_a_novo, 0);
        // FB_A_novo= FB_A + 1 +max(FB_B_novo, 0);
        
        noA.setFatorB(fb_a_novo);
        noB.setFatorB(fb_b_novo);
        
        if ( noB.getPai() != null) {
        	if (  (int) noB.getPai().getElemento() < (int) noB.getElemento() )
        		noB.getPai().setChildDireito( noB );
        	else 
        		noB.getPai().setChildEsquerdo( noB );
        }
        
        if( noDesregulado == this.root) {
            this.root = noB;
        }
        
        return noB;
    	
    }

    @Override
    public NoAVL rotSimRight(NoAVL noDesregulado) {
       
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
        // FB_B_novo= FB_B - 1 - max(FB_A, 0);
        
        // FB_A_novo= FB_A - 1 + min(FB_B_novo, 0);
        int fb_b_novo = noB.getFatorB() - 1 + min(fb_a_novo, 0);
                
        noA.setFatorB(fb_a_novo);
        noB.setFatorB(fb_b_novo);
        
        if ( noB.getPai() != null) {
        	if (  (int) noB.getPai().getElemento() < (int) noB.getElemento() )
        		noB.getPai().setChildDireito( noB );
        	else 
        		noB.getPai().setChildEsquerdo( noB );
        }
        
        if( noDesregulado == this.root) {
            this.root = noB;
        }
        
        return noB;
        
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
    
    // method para testes
	@Override
	public NoAVL getRoot() {
		return (NoAVL) this.root;
	}

}
