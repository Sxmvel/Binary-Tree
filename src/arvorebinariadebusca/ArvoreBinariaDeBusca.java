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

    // 1. Função que conte o número de nós não folhas em uma ABB simples.
    public int contarNaoFolhas() {
        return NoNaoFolhas(raiz);
    }
    
    private int NoNaoFolhas(No no) {
        if (no == null || (no.esquerda == null && no.direita == null)) {
            return 0;
        }
        return 1 + NoNaoFolhas(no.esquerda) + NoNaoFolhas(no.direita);
    }

    //  função que conte o número de nós folhas em uma ABB simples.
    public int contarFolhas() {
        return contarFolhas(raiz);
    }

    private int contarFolhas(No no) {
        if (no == null) {
            return 0;
        }
        if (no.esquerda == null && no.direita == null) {
            return 1;
        }
        return contarFolhas(no.esquerda) + contarFolhas(no.direita);
    }

    public static void main(String[] args) {
        ArvoreBinariaDeBusca arvore = new ArvoreBinariaDeBusca();

        int[] valores = {10, 5, 15, 2, 7, 12, 20, 6, 8};

        for (int valor = 0; valor < valores.length; valor++) {
            arvore.inserir(valor);

        }

        System.out.println("Nos nao folhas: " + arvore.contarNaoFolhas());
        System.out.println("Nós folhas: " + arvore.contarFolhas());
    }

}
