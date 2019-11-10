package Dicionario;

public class Hash {

    private int tabelaHash[];
    private int size;

    public Hash() {
        this.tabelaHash = new int[13];
        this.size = 0;
    }
    
    public int size() {
        return this.size;
    }
    
    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void insert(int k, int mode) {
        if (mode > 1 || mode < 0) {
            mode = 1; // so pode ser 0 ou 1 0 = probing 1 = duplo
        }
        if (this.fiftyPerCent()) {
            this.resize();
        } else {
            // k + j * (q - k mod q) % tabelaHash.length
            boolean encontrado = true;
            for (int j = 0; j < this.tabelaHash.length && encontrado == true; j++) {
                if (this.tabelaHash[this.hashCodeDuplo(k, j, mode)] == 0) {
                    this.tabelaHash[this.hashCodeDuplo(k, j, mode)] = k;
                    encontrado = false;
                    this.size++;
                }
            }
        }
    }

    public void resize() {
        int aftPrimo = this.beforePrimo(this.tabelaHash.length);
        System.out.println(aftPrimo);
        int novaHash[] = new int[aftPrimo];
        int mode = 1;
        for (int i = 0; i < this.tabelaHash.length; i++) {
            if (this.tabelaHash[i] != 0) {
                boolean encontrado = true;
                for (int j = 0; j < this.tabelaHash.length && encontrado == true; j++) {
                    if (novaHash[this.hashCodeDuplo(this.tabelaHash[i], j, mode)] == 0) {
                        novaHash[this.hashCodeDuplo(this.tabelaHash[i], j, mode)] = this.tabelaHash[i];
                        encontrado = false;
                    }
                }
            }
        }
        this.tabelaHash = novaHash;
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

    public int hashCodeDuplo(int k, int j, int mode) {
        return k + j * this.h2(k, mode);
    }

    public int h2(int k, int mode) {
        if (mode == 1) { // linear probing
            return 1;
        } else {
            int befPrimo = this.beforePrimo(this.tabelaHash.length);
            return (befPrimo - k) % befPrimo;
        }
    }
}
