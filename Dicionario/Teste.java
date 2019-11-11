package Dicionario;

public class Teste {

    public static void main(String[] args) {
        Hash novo = new Hash();
        novo.insert(18, 1);
        novo.display();
        System.out.println("----------------------------");
        novo.insert(41, 1);
        novo.display();
        System.out.println("----------------------------");
        novo.insert(22, 1);
        novo.display();
        System.out.println("----------------------------");
        novo.insert(44, 1);
        novo.display();
        System.out.println("----------------------------");
    }
}
