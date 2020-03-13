package ArvoreAVL;

public interface ArvoreAvl {

    public void attFb(NoAVL no, String op);
    public void balancear(NoAVL noDesregulado, String op);
    public NoAVL rotSimLeft(NoAVL noDesregulado);
    public NoAVL rotSimRight(NoAVL noDesregulado);
    public void displayAVL();
    public NoAVL getRoot();
}
