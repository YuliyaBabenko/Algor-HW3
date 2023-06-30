public class LeftRedBlackTree<T extends Comparable<T>> {

    private class Node {
        T value;
        Color color;
        Node left, right;

        public Node(T value) {
            this.value = value;
            this.color = Color.RED;
            this.left = null;
            this.right = null;
        }
    }

    private enum Color {
        RED, BLACK
    }

    private Node root;

    public void add(T value) {
        root = addNode(root, value);
        root.color = Color.BLACK;
    }

    private Node addNode(Node node, T value) {
        if (node == null) {
            return new Node(value);
        }
        if (value.compareTo(node.value) < 0) {
            node.left = addNode(node.left, value);
        }
        else if (value.compareTo(node.value) > 0) {
            node.right = addNode(node.right, value);
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == Color.RED;
    }

    private Node rotateLeft(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = Color.RED;
        return x;
    }

    private Node rotateRight(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = Color.RED;
        return x;
    }

    private void flipColors(Node node) {
        node.color = Color.RED;
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
    }

    public void printTree() {
      System.out.print("\n");
        printTree(root, "", false, 'r');
        System.out.println("\n");
    }

    private void printTree(Node node, String prefix, boolean isLeft, Character key) {
        if (node == null) {
            return;
        }
        System.out.println(prefix + (isLeft ? "├── " : "└── ") +
                key + " " + node.value  + "(" + (node.color == Color.RED ? "R" : "B") + ")");
        printTree(node.left, prefix + (isLeft ? "│   " : "    "), true, 'L');
        printTree(node.right, prefix + (isLeft ? "│   " : "    "), false, 'R');
    }
}
