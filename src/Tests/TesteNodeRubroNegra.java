package Tests;

import RubroNegra.NodeRubroNegra;

public class TesteNodeRubroNegra {
    public static void main(String[] args) {
        NodeRubroNegra<Integer> node = new NodeRubroNegra<Integer>(10);

        // Exemplo de acesso aos atributos do nó
        System.out.println("Chave: " + node.getChave());
        System.out.println("Cor: " + (node.isCor() ? "Preto" : "Vermelho"));

        // Exemplo de atribuição de informações ao nó
        node.setInfo(42);
        System.out.println("Informação: " + node.getInfo());
    }
}

