package edl.Vector;

public interface Vector {
    
    public Object elemAtRank(int r) throws EVectorNotExists;
    public Object replaceAtRank(int r, Object o) throws EVectorNotExists;
    public void insertAtRank(int r, Object o) throws EVectorNotExists;
    public Object removeAtRank(int r) throws EVectorNotExists;
    public void display();
    public boolean isEmpty();
    public int size();
    public void resize();
    
}
