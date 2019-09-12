package edl.Vector;

import java.util.Random;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {

        Random gerador = new Random();
        VectorImpl novo = new VectorImpl(2);
        boolean execute = true;
        Scanner in = new Scanner(System.in);
        String asw;

        while (execute) {
            System.out.println("--- MENU ---"
                    + "\n1. size"
                    + "\n2. isEmpty"
                    + "\n3. elemAtRank"
                    + "\n4. replaceAtRank"
                    + "\n5. insertAtRank"
                    + "\n6. removeAtRank"
                    + "\n7. display");
            String op = in.nextLine();
            switch (op) {
                case "1":
                    System.out.println("Tamanho: " + novo.size());
                    break;
                case "2":
                    System.out.println("Vazio: " + novo.isEmpty());
                    break;
                case "3":
                    System.out.println("Digite a posição do elemento");
                    asw = in.nextLine();
                    try {
                        Object recuperado = novo.elemAtRank(Integer.parseInt(asw));
                        System.out.println(recuperado.toString());
                    } catch (NumberFormatException e) {
                        System.out.println("Você não digitou um número");
                    } catch (EVectorNotExists e) {
                        System.out.println("Este espaço não existe no array");
                    }
                    break;
                case "4":
                    System.out.println("Digite a posição do elemento que deseja sobrescrever");
                    asw = in.nextLine();
                    System.out.println("NOVO OBJ CRIADO...");
                    try {
                        novo.replaceAtRank(Integer.parseInt(asw), 20);
                    } catch (NumberFormatException e) {
                        System.out.println("Você não digitou um número");
                    } catch (EVectorNotExists e) {
                        System.out.println("Este espaço não existe no array");
                    }
                    break;
                case "5":
                    System.out.println("Digite a posição do elemento que deseja adicionar");
                    asw = in.nextLine();
                    System.out.println("ADICIONANDO NOVO OBJ...");
                    try {
                        novo.insertAtRank(Integer.parseInt(asw), gerador.nextInt(400));
                    } catch (NumberFormatException e) {
                        System.out.println("Você não digitou um número");
                    } catch (EVectorNotExists e) {
                        System.out.println("Este espaço não existe no array");
                    }
                    break;
                case "6":
                    System.out.println("Digite a posição do elemento que deseja remover");
                    asw = in.nextLine();
                    try {
                        novo.removeAtRank(Integer.parseInt(asw));
                    } catch (NumberFormatException e) {
                        System.out.println("Você não digitou um número");
                    } catch (EVectorNotExists e) {
                        System.out.println("Este espaço não existe no array");
                    }
                    break;
                case "7":
                    novo.display();
                    break;
                default:
                    execute = false;
            }
        }
    }
}
