public class Deneme{
    public static void main(String[] args) {
        BinarySearchTree<String> bt = new BinarySearchTree<String>();
        bt.add("lay");
        bt.add("house");
        bt.add("priest");
        System.out.println(bt.toString());
    }
}