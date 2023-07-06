package application;

import AVL.ArvoreAVL;
import RubroNegra.RubroNegra;


public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvoreAVL = new ArvoreAVL();
        RubroNegra<Integer> rubroNegra = new RubroNegra<Integer>();

        rubroNegra.add(10);
        rubroNegra.add(20);
        rubroNegra.add(30);
        rubroNegra.add(40);
        rubroNegra.add(50);
        rubroNegra.add(60);

        arvoreAVL.insert(10);
        arvoreAVL.insert(20);
        arvoreAVL.insert(30);
        arvoreAVL.insert(40);
        arvoreAVL.insert(50);
        arvoreAVL.insert(60);

        System.out.println("RN: Altura: " + (rubroNegra.getAltura()-1));
        System.out.println("RN: Rotações: " + rubroNegra.getNumRotacoes());
        System.out.println("AVL: Altura: " + (arvoreAVL.getAltura()-1));
        System.out.println("AVL: Rotações: " + arvoreAVL.getRotacoes());

    }
}
