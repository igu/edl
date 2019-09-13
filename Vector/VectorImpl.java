package edl.Vector;

public class VectorImpl implements Vector {

    private Object S[];
    private int TAM_VECTOR = -1;

    public VectorImpl(int tam) {
        this.S = new Object[tam];
    }

    @Override
    public Object elemAtRank(int r) throws EVectorNotExists {
        try {
            return this.S[r];
        } catch (Exception e) {
            throw new EVectorNotExists("Vector não existe :(");
        }
    }

    @Override
    public Object replaceAtRank(int r, Object o) throws EVectorNotExists {
        try {
            Object old = this.elemAtRank(r);
            this.S[r] = o;
            return old;
        } catch (Exception e) {
            throw new EVectorNotExists("Vector não existe :(");
        }
    }

    @Override
    public void insertAtRank(int r, Object o) throws EVectorNotExists {
        if (this.size() == this.S.length) {
            resize();
        }
        try {
            for (int i = (this.S.length - 1); i > r; i--) {
                this.S[i] = this.S[i - 1];
            }
            this.S[r] = o;
            this.TAM_VECTOR++;
        } catch (Exception e) {
            throw new EVectorNotExists("Vector não existe :(");
        }
    }

    @Override
    public Object removeAtRank(int r) throws EVectorNotExists {
        try {
            Object old = this.elemAtRank(r);
            for (int i = r; i < (this.S.length - 1); i++) {
                this.S[i] = this.S[i + 1];
                this.S[i + 1] = null;
            }
            this.TAM_VECTOR--;
            return old;
        } catch (Exception e) {
            throw new EVectorNotExists("Vector não existe :(");
        }
    }

    @Override
    public int size() {
        return (TAM_VECTOR + 1);
    }

    @Override
    public boolean isEmpty() {
        return TAM_VECTOR == -1;
    }

    @Override
    public void resize() {
        Object novo[] = new Object[this.S.length * 2];
        for (int i = 0; i < this.S.length; i++) {
            novo[i] = this.S[i];
        }
        this.S = novo;
    }

    @Override
    public void display() {
        for (int i = 0; i < this.S.length; i++) {
            System.out.print(this.S[i] + "\t");
        }
        System.out.print("\n");
    }

}
