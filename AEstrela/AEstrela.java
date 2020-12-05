package AEstrela;

import java.util.ArrayList;

public interface AEstrela {
    public ArrayList<ArrayList<Integer>> resolver(int labirinto[][], int inicio_i, int inicio_j, int fim_i, int fim_j, String heuristica);
    public boolean cima(No atual, int tam_linha, int tam_coluna);
    public boolean baixo(No atual, int tam_linha, int tam_coluna);
    public boolean esquerda(No atual, int tam_linha, int tam_coluna);
    public boolean direita(No atual, int tam_linha, int tam_coluna);
    public boolean fim(No atual, No fim);
    public int metodoH(int i_inicio, int i_fim, int j_inicio, int j_fim, String metodo);
}
