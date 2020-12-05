package AEstrela;

public class No {

    /*
                LEGENDA:
        f ->  F é calculado somando G e H
        g ->  custo do movimento para se mover do ponto de início até o quadrado determinado na malha seguindo o caminho criado para chegar lá
        h ->  custo estimado do movimento para mover daquele quadrado determinado até o destino final, ponto B
        i -> linha
        j -> coluna
    
     */
    private int f, g, h, i, j;
    private No pai;

    public No(No pai, int i, int j) {
        this.pai = pai;
        this.i = i;
        this.j = j;

        this.f = this.g = this.h = 0;
    }


    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

}
