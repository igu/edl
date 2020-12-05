package AEstrela;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        AEstrelaImpl star = new AEstrelaImpl();

        /*
        
        LEGENDA:
        
        1 = PAREDE
        0 = LIVRE
        2 = PARTIDA
        3 = SAIDA
         */
        // TESTE 1
        /*int labirinto[][]
                = {
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 3, 1},
                    {1, 2, 0, 0, 0, 1, 0, 1, 0, 1},
                    {1, 1, 1, 1, 0, 1, 0, 1, 0 ,1},
                    {1, 0 ,0 ,0 ,0 ,0 ,0 ,1 ,0 ,1},
                    {1, 0 ,1 ,1 ,1 ,1 ,1 ,1 ,0 ,1},
                    {1, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,1},
                    {1, 1 ,1 ,1 ,1 ,1 ,1, 1 ,0 ,1},
                    {1, 1 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,1},
                    {1, 1 ,0 ,1 ,0 ,0 ,1 ,1 ,1 ,1}
                }; 
        
        
        // R: 2,1 -> 1,2 -> 2,2 -> 1,3 -> 2,3 -> 1,4 -> 2,4 -> 3,4 -> 4,4 -> 4,3 -> 4,2 -> 4,1 -> 5,1 -> 6,1 -> 6,2 -> 6,3 -> 6,4 -> 6,5 -> 6,6 -> 6,7 -> 6,8 -> 5,8 -> 5,9
        
        
        int inicio_i = 2;
        int inicio_j = 1;

        int fim_i = 1;
        int fim_j = 8;
        
        //fim-teste-1
        
        */
        // TESTE 2
        /*
       inicio-teste-2
        int labirinto[][]
                = {
                    {1, 2, 1, 1, 1, 1},
                    {1, 0, 1, 1, 1, 1},
                    {1, 0, 1, 1, 3, 1},
                    {1, 0, 0, 0, 0, 1},
                    {3, 1, 0, 0, 0, 1},
                    {3, 1, 0, 0, 0, 1},
                }; 
       
        int inicio_i = 0;
        int inicio_j = 1;

        int fim_i = 2;
        int fim_j = 4;

       fim-teste2
         */
        //TESTE 3
        
        // inicio-teste-3
        int labirinto[][]
                = {
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 2, 0, 0, 0, 1, 0, 1, 0, 1},
                    {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                    {1, 0, 1, 1, 1, 1, 1, 1, 0, 3},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                    {3, 1, 0, 0, 1, 0, 0, 0, 0, 1},
                    {1, 1, 0, 1, 0, 0, 1, 1, 1, 1}
                };
        
        int inicio_i = 2;
        int inicio_j = 1;

        int fim_i = 5;
        int fim_j = 9;

        //fim-teste-3
        
        
        String tipo_heuristica = "m"; // manhattan
        // String tipo_heuristica = "e"; // euclidiana 

        ArrayList<ArrayList<Integer>> solucao = star.resolver(labirinto, inicio_i, inicio_j, fim_i, fim_j, tipo_heuristica);

        if (solucao == null) {
            System.out.println("Não existe saída nesse labirinto");
        } else {
            for (int i = 0; i < solucao.get(0).size(); i++) {
                System.out.print(solucao.get(0).get(i) + "," + solucao.get(1).get(i) + ((solucao.get(0).size() - 1 != i) ? " -> " : ""));
            }
            System.out.println("");
        }

    }
}
