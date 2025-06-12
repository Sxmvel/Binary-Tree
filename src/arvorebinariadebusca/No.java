package arvorebinariadebusca;

public class No {

    int chave;
    No esquerda;
    No direita;

    public No(int valor) {
        this.chave = valor;
        this.esquerda = null;
        this.direita= null;
    }
}
