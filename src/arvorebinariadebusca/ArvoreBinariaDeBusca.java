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

    // 1. Contar nós não-folhas
    public int contarNaoFolhas() {
        return NoNaoFolhas(raiz);
    }
    private int NoNaoFolhas(No no) {
        if (no == null || (no.esquerda == null && no.direita == null)) {
            return 0;
        }
        return 1 + NoNaoFolhas(no.esquerda) + NoNaoFolhas(no.direita);
    }

    public static void main(String[] args) {

    }

}
