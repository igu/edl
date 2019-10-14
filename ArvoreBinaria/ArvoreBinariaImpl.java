package ArvoreBinaria;

import java.util.ArrayList;
import java.util.List;

public class ArvoreBinariaImpl implements ArvoreBinaria {
    
    private No root = null;
    private ArrayList<No> nosArrayList = null; 
    private int size = 0;
    
    public ArvoreBinariaImpl() { } // Arvore iniciando sem raiz
    
    public ArvoreBinariaImpl(Object elem) { // Arvore iniciando com raiz
        this.root = new No(elem, null, null, null);
        this.size++;
    }
    
    @Override
    public boolean inserir(Object elem) {
        if (this.root != null) { // existe um no raiz
           No pai = this.buscar(elem, this.root);
           No novoFilho = new No(elem, pai, null, null);
           if((int) pai.getElemento() == (int) novoFilho.getElemento()) { // n pode igual
        	   return false; // implementar excecao dps
           } else {
        	   if((int) novoFilho.getElemento() < (int) pai.getElemento()) {
        		   pai.setChildEsquerdo(novoFilho);
        	   } else {
        		   pai.setChildDireito(novoFilho);
        	   }
           }
        } else this.root = new No(elem, null, null, null);
        this.size++;
        return true;
    }

    @Override
    public No buscar(Object elem, No raiz) {
        if (this.isExternal(raiz) || (int) elem == (int) raiz.getElemento()) return raiz;
        else if ((int) elem < (int) raiz.getElemento() && this.containsChildEsquerdo(raiz)) return buscar(elem, raiz.getChildEsquerdo());
        else if ((int) elem > (int) raiz.getElemento() && this.containsChildDireito(raiz)) return buscar(elem, raiz.getChildDireito());
        return raiz;
    }

    @Override
    public void remover(Object elem) throws ElNaoEncontradoException {
        if(this.root != null) { // arvore vazia
        	No exclusao = this.buscar(elem, this.root);
        	if((int) elem == (int) exclusao.getElemento()) {
        		if(this.countChilds(exclusao) == 0) { // EXCLUIR NÓ SEM FILHOS
        			if(this.root == exclusao) {
        				this.root = null;
        				this.size--;
        			}else {
        				if(exclusao.getPai().getChildDireito() == exclusao) {
        					exclusao.getPai().setChildDireito(null);
        				}else {
        					exclusao.getPai().setChildEsquerdo(null);
        				}
        				exclusao.setPai(null);
        				this.size--;
        			}
        		}else if(this.countChilds(exclusao) == 1) { // EXCLUIR NÓ COM UM FILHO
        			if(this.root == exclusao) { // excluir raiz
        				if(this.containsChildDireito(exclusao)) {
        					exclusao.getChildDireito().setPai(null);
        					this.root = exclusao.getChildDireito();
        				} else {
        					exclusao.getChildEsquerdo().setPai(null);
        					this.root = exclusao.getChildEsquerdo();
        				}
        				this.size--;
        			} else {
        				if(this.containsChildDireito(exclusao)) {
        					No filho = exclusao.getChildDireito();
        					filho.setPai(exclusao.getPai());
        					if(exclusao.getPai().getChildDireito() == exclusao) {
        						exclusao.getPai().setChildDireito(filho);
        					}else {
        						exclusao.getPai().setChildEsquerdo(filho);
        					}
        				}else {
        					No filho = exclusao.getChildEsquerdo();
        					filho.setPai(exclusao.getPai());
        					if(exclusao.getPai().getChildDireito() == exclusao) {
        						exclusao.getPai().setChildDireito(filho);
        					}else {
        						exclusao.getPai().setChildEsquerdo(filho);
        					}
        				}
        				exclusao.setPai(null);
        				exclusao.setChildDireito(null);
        				exclusao.setChildEsquerdo(null);
        				this.size--;
        			}
        		}else if(this.countChilds(exclusao) == 2) { // EXCLUIR NÓ COM DOIS FILHOS 
        			/* pecorrer até encontrar o menor elemento dir/last esq */
        			No aux = exclusao.getChildDireito();
        			while(aux.getChildEsquerdo() != null) {
        				aux = aux.getChildEsquerdo();
        			}	
        			int elementoLastChild = (int) aux.getElemento();
        			System.out.println("Trocado por: " + elementoLastChild);
        			this.remover(elementoLastChild);
        			exclusao.setElemento(elementoLastChild);
        		}
        	} else throw new ElNaoEncontradoException("Elemento não contido na arvore binaria");
        }
    }

    @Override
    public ArrayList<No> nos(int mode) {
       this.nosArrayList = new ArrayList<No>();
       
       if(mode == 1) this.preOrdem(this.root);
       else if(mode == 2) this.inOrdem(this.root);
       else if(mode == 3) this.posOrdem(this.root);
       
       return this.nosArrayList;
    }

    @Override
    public int height(No no) {
        if(no == null || this.isExternal(no)) return 0;
        else {
        	int h = 0;
        	
        	List<No> childs = new ArrayList<No>();
        	childs.add(no.getChildEsquerdo());
        	childs.add(no.getChildDireito());
        	
        	for(int i = 0; i < childs.size(); i++) {
        		h = Math.max(h, this.height(childs.get(i)));
        	}
        	return 1 + h;
        }
    }

    @Override
    public int profundidade(No no) {
        if(this.root == no) return 0;
        return 1 + this.profundidade(no.getPai());
    }

    @Override
    public boolean isRoot(No no) {
        return this.root == no;
    }

    @Override
    public boolean containsChildEsquerdo(No no) {
        return no.getChildEsquerdo() != null;
    }

    @Override
    public boolean containsChildDireito(No no) {
        return no.getChildDireito() != null;
    }

    @Override
    public int countChilds(No no) {
        if(this.containsChildDireito(no) && this.containsChildEsquerdo(no)) return 2;
        else if(this.isExternal(no)) return 0;
        return 1;
    }

    @Override
    public boolean isExternal(No no) {
        return !(this.containsChildDireito(no) || this.containsChildEsquerdo(no));
    }
    
    private void preOrdem(No no) {
    	this.nosArrayList.add(no);
    	
    	if(this.containsChildEsquerdo(no)) {
    		this.preOrdem(no.getChildEsquerdo());
    	}
    	
    	if(this.containsChildDireito(no)) {
    		this.preOrdem(no.getChildDireito());
    	}
    }
    
    private void inOrdem(No no) {
    	if(this.containsChildEsquerdo(no)) {
    		this.inOrdem(no.getChildEsquerdo());
    	}
    	
    	this.nosArrayList.add(no);
    	
    	if(this.containsChildDireito(no)) {
    		this.inOrdem(no.getChildDireito());
    	}
    }
    
    private void posOrdem(No no) {
    	if(this.containsChildEsquerdo(no)) {
    		this.posOrdem(no.getChildEsquerdo());
    	}
    	
    	if(this.containsChildDireito(no)) {
    		this.posOrdem(no.getChildDireito());
    	}
    	
    	this.nosArrayList.add(no);
    }
    
    @Override
    public void display() {
    	
    	int k = 0, colunas = this.size, linhas = this.height(this.root) + 1;
    	int matrix[][] = new int[linhas][colunas];
    	ArrayList<No> nosContains = this.nos(2);
    	while(k < this.size) {
    		matrix[ this.profundidade(nosContains.get(k)) ][ k ] = (int) nosContains.get(k).getElemento();
    		k++;
    	}
    	
    	 for(int i = 0; i < linhas; i++) {
             for(int j = 0; j < colunas; j++) {
                 if(matrix[i][j] != 0) System.out.print(matrix[i][j] + "   "); 
                 else System.out.print("   ");
             }
             System.out.print("\n");
         }
     }
    
    public int getSize() {
    	return size;
    }
}