package ArvoreAVL;

public interface ArvoreAvl {

    public void attFb(NoAVL no, String op);
    public void balancear(NoAVL noDesregulado);
    public void rotSimLeft(NoAVL noDesregulado);
    public void rotSimRight(NoAVL noDesregulado);
    public void displayAVL();
    public NoAVL getRoot();
}
