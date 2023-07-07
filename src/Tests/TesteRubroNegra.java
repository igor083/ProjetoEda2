package Tests;

import RubroNegra.RubroNegra;

public class TesteRubroNegra {
    public static void main(String[] args) {
        RubroNegra<Integer> rubroNegra = new RubroNegra<Integer>();

        // Insira aqui os valores que deseja testar
        int[] valores = { 10, 5, 15, 3, 7, 12, 20 };

        // Insere os valores na árvore Rubro-Negra
        for (int valor : valores) {
            rubroNegra.add(valor);
        }

        // Imprime a altura da árvore Rubro-Negra
        System.out.println("Altura da árvore Rubro-Negra: " + (rubroNegra.getAltura() - 1));

        // Imprime o número de rotações realizadas na árvore Rubro-Negra
        System.out.println("Número de rotações: " + rubroNegra.getNumRotacoes());
    }
}
