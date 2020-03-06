package ArvoreAVL;

import ArvoreBinaria.ArvoreBinariaImpl;

public class ArvoreAvllmpl extends ArvoreBinariaImpl implements ArvoreAvl {
    
    // SLIDE 14;22 

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

        if (op.equals("INSERT")) {
            if (this.isRoot(no) || ((NoAVL) no.getPai()).getFatorB() == 0) return;
                 // CODNIÇÃO DE FINAL ENCONTROU O RAIZ OU UM PAI COM FATOR == 0
        } else {
            if (this.isRoot(no) || ((NoAVL) no.getPai()).getFatorB() != 0) return;
        }
        
        int fatorPai = ((NoAVL) no.getPai()).getFatorB();
        if ((int) no.getPai().getElemento() < (int) no.getElemento()) {
            ((NoAVL) no.getPai()).setFatorB((op.equals("INSERT") ? --fatorPai : ++fatorPai));
        } else {
            ((NoAVL) no.getPai()).setFatorB((op.equals("INSERT") ? ++fatorPai : --fatorPai));
        }

        if (((NoAVL) no.getPai()).getFatorB() > 1 || ((NoAVL) no.getPai()).getFatorB() < - 1) // tem que balancear
        
        this.attFb((NoAVL) no.getPai(), op); // recusao
    }

    @Override
    public void rotSimLeft() {
        // TODO Auto-generated method stub

    }

    @Override
    public void rotSimRight() {
        // TODO Auto-generated method stub

    }

    @Override
    public void displayAVL() {
        // TODO Auto-generated method stub

    }

}
