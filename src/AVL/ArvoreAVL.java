package AVL;

public class ArvoreAVL {
    private Node root;
    private int rotationCount;

    private class Node {
        private int key;
        private int height;
        private Node left;
        private Node right;

        public Node(int key) {
            this.key = key;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    public ArvoreAVL() {
        this.root = null;
        this.rotationCount = 0;
    }

    public int getAltura() {
        return getAltura(root);
    }

    private int getAltura(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public int getRotacoes() {
        return rotationCount;
    }

    private int balanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getAltura(node.left) - getAltura(node.right);
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;

        y.height = Math.max(getAltura(y.left), getAltura(y.right)) + 1;
        x.height = Math.max(getAltura(x.left), getAltura(x.right)) + 1;

        rotationCount++;
        
        return x;
    }

    private Node rotateRight(Node x) {
        Node y = x.left;
        Node T2 = y.right;

        y.right = x;
        x.left = T2;

        x.height = Math.max(getAltura(x.left), getAltura(x.right)) + 1;
        y.height = Math.max(getAltura(y.left), getAltura(y.right)) + 1;

        rotationCount++;
        
        return y;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            // Duplicate keys are not allowed in AVL tree
            return node;
        }

        node.height = 1 + Math.max(getAltura(node.left), getAltura(node.right));

        int balance = balanceFactor(node);

        // Left Left Case
        if (balance > 1 && key < node.left.key) {
            return rotateRight(node);
        }

        // Right Right Case
        if (balance < -1 && key > node.right.key) {
            return rotateLeft(node);
        }

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }
}
