package edl.Lista;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        String op;
        Scanner in = new Scanner(System.in);
        ListaImpl nova = new ListaImpl();
        do {
            
            System.out.print(" --- MENU ----"
                + "\n1. size"
                + "\n2. isEmpty"
                + "\n3. isFirst"
                + "\n4. isLast"
                + "\n5. first"
                + "\n6. last"
                + "\n7. before"
                + "\n8. after"
                + "\n9. replaceElement"
                + "\n10. swapElements"
                + "\n11. insertBefore"
                + "\n12. insertAfter"
                + "\n13. insertFirst"
                + "\n14. insertLast"
                + "\n15. remove"
                + "\n16. display\n");
            op = in.nextLine();
            
            switch(op) {
                case "1":
                    System.out.println(nova.size());
                    break;
                case "2":
                    System.out.println("Vazio: " + nova.isEmpty());
                    break;
                case "3":
                    System.out.println("isFirst: " + nova.isFirst( nova.first() ) );
                    break;
                case "4":
                    System.out.println("isLast: " + nova.isLast( nova.last() ) );
                    break;
                case "5":
                    System.out.println("First: " + nova.first().getO());
                    break;
                case "6":
                    System.out.println("Last: " + nova.last().getO() );
                    break;
                case "7":
                    System.out.println("Before: " + nova.before( nova.last() ) );
                    break;
                case "8":
                    System.out.println("After: " + nova.after( nova.first() ) );
                    break;
                case "9":
                    nova.replaceElement(nova.first().getProx().getProx(), "HEHEH");
                    break;
                case "10":
                    nova.swapElements(nova.first().getProx().getProx(), nova.first());
                    break;
                case "11":
                    nova.insertAfter(nova.first(), "INSERIDO APOS O INICIO");
                    break;
                case "12":
                    nova.insertBefore(nova.last(), "ANTES DO FIM");
                    break;
                case "13":
                    nova.insertFirst("INSERIDO POR PRIMEIRO");
                    break;
                case "14":
                    nova.insertLast("INSERIDO POR ULTIMO");
                    break;
                case "15":
                    nova.remove(nova.last().getAnt());
                    break;
                case "16":
                    nova.display();
                    break;
                default:
                    op = "0";
            }
        } while (!op.equals("0"));
    }
}
