package Tests;

import AVL.ArvoreAVL;

public class TesteArvoreAVL {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        // Insira aqui os valores que deseja testar
        int[] valores = { 10, 5, 15, 3, 7, 12, 20 };

        // Insere os valores na árvore AVL
        for (int valor : valores) {
            arvore.insert(valor);
        }

        // Imprime a altura da árvore AVL
        System.out.println("Altura da árvore AVL: " + (arvore.getAltura() - 1));

        // Imprime o número de rotações realizadas na árvore AVL
        System.out.println("Número de rotações: " + arvore.getRotacoes());
    }
}
