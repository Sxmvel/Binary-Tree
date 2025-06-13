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
        if (no == null) {
            return -1;
        } // -1 se contar arestas, 0 se contar nós

        // Calcula a altura da subárvore esquerda e da direita.
        return 1 + Math.max(alturaRec(no.esquerda), alturaRec(no.direita));
    }

    // 4. Funcao para remover todos os nós com chave par
    public void removerNosPares() {
        raiz = removerNosParesRec(raiz);
    }

    private No removerNosParesRec(No no) {
        if (no == null) {
            return null;
        }

        no.esquerda = removerNosParesRec(no.esquerda);
        no.direita = removerNosParesRec(no.direita);

        if (no.chave % 2 == 0) {
            if (no.esquerda == null) {
                return no.direita;
            }
            if (no.direita == null) {
                return no.esquerda;
            }

            // Substituir por menor valor da subárvore direita
            No substituto = encontrarMinimo(no.direita);
            no.chave = substituto.chave;
            no.direita = removerRec(no.direita, substituto.chave);
        }

        return no;
    }

    private No encontrarMinimo(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }

    private No removerRec(No no, int chave) {
        if (no == null) {
            return null;
        }
        if (chave < no.chave) {
            no.esquerda = removerRec(no.esquerda, chave);
        } else if (chave > no.chave) {
            no.direita = removerRec(no.direita, chave);
        } else {
            if (no.esquerda == null) {
                return no.direita;
            }
            if (no.direita == null) {
                return no.esquerda;
            }
            No temp = encontrarMinimo(no.direita);
            no.chave = temp.chave;
            no.direita = removerRec(no.direita, temp.chave);
        }
        return no;
    }

    // 5. Funcao que encontra o maior número
    public int encontrarMaior() {
        if (raiz == null) {
            throw new RuntimeException("Árvore vazia");
        }
        No atual = raiz;
        while (atual.direita != null) {
            atual = atual.direita;
        }
        return atual.chave;
    }

    
    public void imprimirArvore() {
        imprimirArvoreRec(raiz, 0);
    }

    private void imprimirArvoreRec(No no, int nivel) {
        if (no != null) {
            imprimirArvoreRec(no.direita, nivel + 1);

            for (int i = 0; i < nivel; i++) {
                System.out.print("    "); // 4 espaços por nível
            }
            System.out.println(no.chave);

            imprimirArvoreRec(no.esquerda, nivel + 1);
        }
    }

}
