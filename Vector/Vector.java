package Vector;

public interface Vector {
    
    public Object elemAtRank(int r) throws EVectorNotExists;
    public Object replaceAtRank(int r, Object o) throws EVectorNotExists;
    public void insertAtRank(int r, Object o) throws EVectorNotExists;
    public Object removeAtRank(int r) throws EVectorNotExists;
    public int size();
    public boolean isEmpty();
    public void resize();
    public void display();
    
}
