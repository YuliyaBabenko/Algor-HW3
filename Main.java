public class Main {
    public static void main(String[] args) {
        LeftRedBlackTree<Integer> tree = new LeftRedBlackTree<>();
        tree.add(25);
        tree.add(4);
        tree.add(1);
        tree.add(17);
        tree.add(5);
        tree.add(8);
        tree.add(23);
        tree.add(20);        
        System.out.print("\033[H\033[J");
        tree.printTree();

    }
}
