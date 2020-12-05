package AEstrela;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

public class AEstrelaImpl implements AEstrela {

    @Override
    public ArrayList<ArrayList<Integer>> resolver(int[][] labirinto, int inicio_i, int inicio_j, int fim_i, int fim_j, String metodo) {
        No inicio = new No(null, inicio_i, inicio_j);
        No fim = new No(null, fim_i, fim_j);

        ArrayList<No> heuristica_aberta = new ArrayList<No>();
        HashSet<No> heuristica_fechada = new HashSet<No>(); // garantir integridade na lista_fechada

        //1) add quadro inicial
        heuristica_aberta.add(inicio);

        // 2) repita
        while (heuristica_aberta.size() > 0) {

            No atual = heuristica_aberta.get(0);
            int index_atual = 0;

            // verifica-se se existe um fator menor que o nó atual, pois, pode-se encontrar um melhor caminho
            for (int i = 0; i < heuristica_aberta.size(); i++) {

                // a.1) busco o quadrado com o menor custo de F
                if (heuristica_aberta.get(i).getF() < atual.getF()) {
                    atual = heuristica_aberta.get(i);
                    index_atual = i;
                }

                // a.2) removo da heuristica aberta
                heuristica_aberta.remove(index_atual);

                // b) add a heuristica fechada
                heuristica_fechada.add(atual);
            }

            // d.1) para se encontrou o no final
            if (fim(atual, fim)) {
                ArrayList<Integer> is = new ArrayList<Integer>(); // linhas i's
                ArrayList<Integer> js = new ArrayList<Integer>(); // colunas j's
                ArrayList<ArrayList<Integer>> caminhos = new ArrayList<ArrayList<Integer>>();

                No temp = atual;

                while (temp != null) {
                    is.add(temp.getI());
                    js.add(temp.getJ());
                    temp = temp.getPai();
                }

                // 3) salvar o caminho, caminhando para trás do quadrado alvo
                Collections.reverse(is);
                Collections.reverse(js);

                caminhos.add(is);
                caminhos.add(js);

                return caminhos;

            }

            // verificar os 4 lados (possiveis filhos) 
            // quadrado de cima
            // System.out.println(labirinto[atual.getI()][atual.getJ()] + " atual:" + (atual.getI()) + "/" + atual.getJ());
            if (cima(atual, labirinto.length, labirinto[1].length)) {
                // System.out.println(labirinto[atual.getI() - 1][atual.getJ()] + " atual:" + (atual.getI() - 1) + "/" + atual.getJ());
                if (labirinto[atual.getI() - 1][atual.getJ()] == 3 && ((atual.getI() - 1) != fim.getI() || atual.getJ() != fim.getJ())) {
                    System.out.println("oi 1");
                    labirinto[atual.getI() - 1][atual.getJ()] = 1;
                }
                if (labirinto[atual.getI() - 1][atual.getJ()] != 1) {
                    No novo = new No(atual, atual.getI() - 1, atual.getJ());
                    if (!contains(heuristica_fechada, atual.getI() - 1, atual.getJ())) {

                        if (!contains(heuristica_aberta, atual.getI() - 1, atual.getJ())) {

                            int H = metodoH(novo.getI(), fim.getI(), novo.getJ(), fim.getJ(), metodo);

                            // att  distancia euclidiana (d), g, f: soma de g + h
                            novo.setH(H);
                            novo.setG(atual.getG() + 1);
                            novo.setF(novo.getG() + novo.getH());

                            heuristica_aberta.add(novo);

                        } else {
                            if (novo.getG() < atual.getG()) {
                                No paiAntigo = atual.getPai();
                                atual.setPai(novo);
                                novo.setPai(paiAntigo);

                                // recalc g e f
                                atual.setG(novo.getG() + 1);
                                atual.setF(atual.getG() + atual.getH());
                            }
                        }
                    }
                    // System.out.println("Entrou quadrado cima");
                }
            }

            // quadrado de baixo 
            if (baixo(atual, labirinto.length, labirinto[1].length)) {
                //  System.out.println(labirinto[atual.getI() + 1][atual.getJ()] + " atual:" + (atual.getI() + 1) + "/" + atual.getJ());
                if (labirinto[atual.getI() + 1][atual.getJ()] == 3 && ((atual.getI() + 1) != fim.getI() || atual.getJ() != fim.getJ())) {
                    System.out.println("oi 2");
                    labirinto[atual.getI() + 1][atual.getJ()] = 1;
                }
                No novo = new No(atual, atual.getI() + 1, atual.getJ());
                if (labirinto[atual.getI() + 1][atual.getJ()] != 1) {

                    if (!contains(heuristica_fechada, atual.getI() + 1, atual.getJ())) {

                        if (!contains(heuristica_aberta, atual.getI() + 1, atual.getJ())) {

                            int H = metodoH(novo.getI(), fim.getI(), novo.getJ(), fim.getJ(), metodo);

                            // att  distancia euclidiana (d), g, f: soma de g + h
                            novo.setH(H);
                            novo.setG(atual.getG() + 1);
                            novo.setF(novo.getG() + novo.getH());

                            heuristica_aberta.add(novo);
                        } else {
                            if (novo.getG() < atual.getG()) {
                                No paiAntigo = atual.getPai();
                                atual.setPai(novo);
                                novo.setPai(paiAntigo);

                                // recalc g e f
                                atual.setG(novo.getG() + 1);
                                atual.setF(atual.getG() + atual.getH());
                            }
                        }
                    }

                    //  System.out.println("Entrou quadrado baixo");
                }
            }

            // quadrado esquerdo (tras)
            if (esquerda(atual, labirinto.length, labirinto[1].length)) {
                //   System.out.println(labirinto[atual.getI()][atual.getJ() - 1] + " atual:" + atual.getI() + "/" + (atual.getJ() - 1));
                if (labirinto[atual.getI()][atual.getJ() - 1] == 3 && (atual.getI() != fim.getI() || (atual.getJ() - 1) != fim.getJ())) {
                    System.out.println("oi 3");
                    labirinto[atual.getI()][atual.getJ() - 1] = 1;
                }
                if (labirinto[atual.getI()][atual.getJ() - 1] != 1) {
                    No novo = new No(atual, atual.getI(), atual.getJ() - 1);
                    if (!contains(heuristica_fechada, atual.getI(), atual.getJ() - 1)) {

                        if (!contains(heuristica_aberta, atual.getI(), atual.getJ() - 1)) {

                            int H = metodoH(novo.getI(), fim.getI(), novo.getJ(), fim.getJ(), metodo);

                            // att  distancia euclidiana (d), g, f: soma de g + h
                            novo.setH(H);
                            novo.setG(atual.getG() + 1);
                            novo.setF(novo.getG() + novo.getH());

                            heuristica_aberta.add(novo);
                        } else {
                            if (novo.getG() < atual.getG()) {
                                No paiAntigo = atual.getPai();
                                atual.setPai(novo);
                                novo.setPai(paiAntigo);

                                // recalc g e f
                                atual.setG(novo.getG() + 1);
                                atual.setF(atual.getG() + atual.getH());
                            }
                        }
                    }
                    //    System.out.println("Entrou quadrado esquerdo");

                }
            }

            // quadrado direito (frente)
            if (direita(atual, labirinto.length, labirinto[1].length)) {
                //   System.out.println(labirinto[atual.getI()][atual.getJ() + 1] + " atual:" + atual.getI() + "/" + (atual.getJ() + 1));
                if (labirinto[atual.getI()][atual.getJ() + 1] == 3 && (atual.getI() != fim.getI() || (atual.getJ() + 1) != fim.getJ())) {
                    System.out.println("oi 4");
                    labirinto[atual.getI()][atual.getJ() + 1] = 1;
                }
                if (labirinto[atual.getI()][atual.getJ() + 1] != 1) {
                    No novo = new No(atual, atual.getI(), atual.getJ() + 1);
                    if (!contains(heuristica_fechada, atual.getI(), atual.getJ() + 1)) {

                        if (!contains(heuristica_aberta, atual.getI(), atual.getJ() + 1)) {

                            int H = metodoH(novo.getI(), fim.getI(), novo.getJ(), fim.getJ(), metodo);

                            // att  distancia euclidiana (d), g, f: soma de g + h
                            novo.setH(H);
                            novo.setG(atual.getG() + 1);
                            novo.setF(novo.getG() + novo.getH());

                            heuristica_aberta.add(novo);
                        } else {
                            if (novo.getG() < atual.getG()) {
                                No paiAntigo = atual.getPai();
                                atual.setPai(novo);
                                novo.setPai(paiAntigo);

                                // recalc g e f
                                atual.setG(novo.getG() + 1);
                                atual.setF(atual.getG() + atual.getH());
                            }
                        }
                    }
                    //     System.out.println("Entrou quadrado direito");
                }
            }
        }

        // d.ii) nao encontrou saida
        return null;
    }

    public boolean contains(HashSet<No> heuristica, int i, int j) {

        for (No novo : heuristica) {
            if (novo.getI() == i && novo.getJ() == j) {
                return true;

            }
        }
        return false;
    }

    public boolean contains(ArrayList<No> heuristica, int i, int j) {
        for (No novo : heuristica) {
            if (novo.getI() == i && novo.getJ() == j) {
                return true;

            }
        }
        return false;
    }

    @Override
    public boolean cima(No atual, int tam_linha, int tam_coluna) {
        if ((atual.getI() - 1 < tam_linha && atual.getI() - 1 > - 1) && (atual.getJ() < tam_coluna && atual.getJ() > - 1)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean baixo(No atual, int tam_linha, int tam_coluna) {
        if ((atual.getI() + 1 < tam_linha && atual.getI() + 1 > -1) && (atual.getJ() < tam_coluna && atual.getJ() > - 1)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean esquerda(No atual, int tam_linha, int tam_coluna) {
        if ((atual.getI() < tam_linha && atual.getI() > -1) && (atual.getJ() - 1 < tam_coluna && atual.getJ() - 1 > - 1)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean direita(No atual, int tam_linha, int tam_coluna) {
        if ((atual.getI() < tam_linha && atual.getI() > -1) && (atual.getJ() + 1 < tam_coluna && atual.getJ() + 1 > - 1)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean fim(No atual, No fim) {
        if (atual.getI() == fim.getI() && atual.getJ() == fim.getJ()) {
            return true;
        }
        return false;
    }

    @Override
    public int metodoH(int i_inicio, int i_fim, int j_inicio, int j_fim, String metodo) {
        if(metodo.equals("m")) { // Distancia Manhattan
            return (Math.abs(i_inicio - i_fim) + Math.abs(j_inicio - j_fim)) * 10;
        }
        return ((int) Math.pow(i_inicio - i_fim, 2)) + ((int) Math.pow(j_inicio - j_fim, 2));
    }

}
