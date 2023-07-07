package application;

import java.util.Random;
import AVL.ArvoreAVL;
import RubroNegra.RubroNegra;

public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvoreAVL = new ArvoreAVL();
        RubroNegra<Integer> rubroNegra = new RubroNegra<Integer>();

        Random random = new Random();

        int quantidade = 500000; // Altere aqui para 500000, 1000000 ou 1500000

        for (int i = 0; i < quantidade; i++) {
            int numero = random.nextInt(quantidade); // Gera um número aleatório até a quantidade definida
            rubroNegra.add(numero);
            arvoreAVL.insert(numero);
        }

        System.out.println("RN: Altura: " + (rubroNegra.getAltura() - 1));
        System.out.println("RN: Rotações: " + rubroNegra.getNumRotacoes());
        System.out.println("AVL: Altura: " + (arvoreAVL.getAltura() - 1));
        System.out.println("AVL: Rotações: " + arvoreAVL.getRotacoes());
    }
}
