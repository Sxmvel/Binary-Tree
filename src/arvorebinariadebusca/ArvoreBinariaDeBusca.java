package arvorebinariadebusca;

public class ArvoreBinariaDeBusca {

    public static void main(String[] args) {
        ABB arvore = new ABB();

        int[] valores = {10, 5, 15, 2, 7, 12, 20, 6, 8};

        for (int valor = 0; valor < valores.length; valor++) {
            arvore.inserir(valor);

        }

        System.out.println("Nos nao folhas: " + arvore.contarNaoFolhas());
        System.out.println("Nos folhas: " + arvore.contarFolhas());
        System.out.println("Altura da árvore: " + arvore.altura());

        arvore.removerNosPares();
        System.out.println("Após remover nós pares:");
        System.out.println("Nós folhas: " + arvore.contarFolhas());
        System.out.println("Maior valor: " + arvore.encontrarMaior());

    }

}
