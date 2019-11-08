package Dicionario;

public class Hash {

    private int tabelaHash[];
    private int size;
    private int afterPrimo;
    private boolean linearProb;

    public Hash() {
        this.tabelaHash = new int[13];
        this.size = 0;
    }

    public void insertProbing() {
    }

    public void insert(int k) {
        this.linearProb = false;
        if (this.fiftyPerCent()) {
            int novaHash[] = new int[this.afterPrimo(this.tabelaHash.length)];
            for (int i = 0; i < this.size; i++) {

            }

        } else {
            // k + j * (q - k mod q) % tabelaHash.length
            boolean encontrado = true;
            if (this.tabelaHash[this.hashCode(k)] == 0) {
                this.tabelaHash[this.hashCode(k)] = k;
                this.size++;
            } else {
                for (int j = 0; j < this.tabelaHash.length && encontrado == true; j++) {
                    if (this.tabelaHash[this.hashCodeDuplo(k, j)] == 0) {
                        this.tabelaHash[this.hashCodeDuplo(k, j)] = k;
                        encontrado = false;
                        this.size++;
                    }
                }
            }

        }
    }

    public void insertProbing(int k) {
        if (this.fiftyPerCent()) {
            // DUPLICAR
        } else {
            if (this.tabelaHash[this.hashCode(k)] == 0) {
                this.tabelaHash[this.hashCode(k)] = k;
                this.size++;
            } else {
                boolean encontre = true;
                int i = 1;
                while (encontre) {
                    if (this.tabelaHash[this.hashCode(k) + i] == 0) {
                        this.tabelaHash[this.hashCode(k) + i] = k;
                        this.size++;
                        encontre = false;
                    } else {
                        encontre = true;
                    }
                    i++;
                }
            }
        }
    }

    public boolean fiftyPerCent() {
        return this.size == (tabelaHash.length / 2);
    }

    public int afterPrimo(int n) {
        int aftPrimo = n;
        while (true) {
            int i = 2, contador = 0;
            aftPrimo += 1;
            for (i = 2; i < aftPrimo; i++) {
                if (n % i == 0) {
                    contador++;
                }
            }
            if (contador == 2) {
                return aftPrimo;
            }
        }
    }

    public int beforePrimo(int n) {
        int befPrimo = n;
        while (true) {
            int i = 2, contador = 0;
            befPrimo -= 1;
            for (i = 2; i < befPrimo; i++) {
                if (n % i == 0) {
                    contador++;
                }
            }
            if (contador == 2) {
                return befPrimo;
            }
        }
    }

    public int hashCodeDuplo(int k, int j) {
        int befPrimo = this.beforePrimo(this.tabelaHash.length);
        return k + j * this.h2(k);
    }

    public int h2(int k) {
        if (linearProb) {
            return 1;
        } else {
            int befPrimo = this.beforePrimo(this.tabelaHash.length);
            return (befPrimo - k) % befPrimo;
        }

    }

}
