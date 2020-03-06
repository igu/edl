package ArvoreAVL;

public interface ArvoreAvl {

    public void attFb(NoAVL no, String op);
    public void balancear(NoAVL pai);
    public void rotSimLeft(NoAVL pai);
    public void rotSimRight();
    public void displayAVL();
}
