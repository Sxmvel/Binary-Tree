package arvorebinariadebusca;

public class ArvoreBinariaDeBusca {

    No raiz;

    // Inserção padrão em ABB
    public void inserir(int chave) {
        raiz = inserirRec(raiz, chave);
    }

    private No inserirRec(No raiz, int chave) {

        if (raiz == null) {
            return new No(chave);
        }

        if (chave < raiz.chave) {
            raiz.esquerda = inserirRec(raiz.esquerda, chave);
        } else {
            raiz.direita = inserirRec(raiz.direita, chave);
        }
        return raiz;

    }

    public static void main(String[] args) {

    }

}
