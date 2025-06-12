package arvorebinariadebusca;

public class ABB {
    No raiz;

    // Metodo para Insercao na arvore.
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

    // 2. Função que conte o número de nós folhas em uma ABB simples.
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

    // 3. Função que calcule a altura de uma árvore.
    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(No no) {
        if (no == null){
            return -1;
        } // -1 se contar arestas, 0 se contar nós
        
        // Calcula a altura da subárvore esquerda e da direita.
        return 1 + Math.max(alturaRec(no.esquerda), alturaRec(no.direita));
    }
    
    
}
