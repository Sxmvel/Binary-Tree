package arvorebinariadebusca;

public class ArvoreBinariaDeBusca {

    public static void main(String[] args) {
        ABB arvore = new ABB();

        int[] valores = {10, 5, 15, 2, 7, 12, 20, 6, 8};

        for (int valor = 0; valor < valores.length; valor++) {
            arvore.inserir(valores[valor]);

        }
        
        arvore.imprimirArvore();

        System.out.println("Nos nao folhas: " + arvore.contarNaoFolhas());
        System.out.println("Nos folhas: " + arvore.contarFolhas());
        System.out.println("Altura da árvore: " + arvore.altura());

        arvore.removerNosPares();
        System.out.println("Apos remover nós pares:\n");
        arvore.imprimirArvore();
        
        
        System.out.println("\nMaior valor: " + arvore.encontrarMaior());

    }

}
