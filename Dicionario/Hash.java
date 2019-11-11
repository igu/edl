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
            mode = 1; 
            /*
                 so pode ser 0 ou 1 
                0 = duplo 1 = probing 
            */
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

    public int findElement(int k, int index, int mode) throws NotElementFoundException {
        if (mode > 1 || mode < 0) {
            mode = 1; 
            /*
                 so pode ser 0 ou 1 
                0 = duplo 1 = probing 
            */
        }

        if (index > 1 || index < 0) {
            index = 1; 
            /* 
                retornar index ou retornar 
                    elemento 0 = index 1 = elemento
            */
            
        }

        int j = 0;
        try {
            while (j++ < this.tabelaHash.length) {
                int indice = this.hashCodeDuplo(k, j, mode);
                int valor = this.tabelaHash[indice];
                if (valor != 0 && valor == k) {
                    if (index == 0) {
                        return indice;
                    }
                    return valor;
                }
            }
        } catch (Exception e) {
            throw new NotElementFoundException("NO_SUCH_KEY");
        }
        return 0;
    }

    public int removeElement(int k, int mode) throws NotElementFoundException {
        int indice = this.findElement(k, 0, mode);
        int elemento = this.tabelaHash[indice];
        System.out.println(elemento);
        this.tabelaHash[indice] = 0; // zera o elemtento
        this.size--;
        return elemento;
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
        } // k + j * 1 mod tamanho do array 
        // k + j * (q - k mod q) mod tamanho do array
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
            if (contador == 0) {
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
            if (contador == 0) {
                return befPrimo;
            }
        }
    }

    public int hashCodeDuplo(int k, int j, int mode) {
        return (k + j * this.h2(k, mode)) % this.tabelaHash.length;
    }

    public int h2(int k, int mode) {
        if (mode == 1) { // linear probing
            return 1;
        } else {
            int befPrimo = this.beforePrimo(this.tabelaHash.length);
            return (befPrimo - k) % befPrimo;
        }
    }
    
    public void display() {
        System.out.println("|KEY| |ELEMENTO|");
        for(int i = 0; i < this.tabelaHash.length; i++) {
            System.out.print("|" + i + "|" + " |" + this.tabelaHash[i] + "| ");
        }
        System.out.println("\n");
    }
}
