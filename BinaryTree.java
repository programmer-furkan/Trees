import java.io.Serializable;
import java.util.Scanner;

public class BinaryTree<E> implements Serializable{
    protected static class Node<E> implements Serializable{
        protected E data;
        protected Node<E> left;
        protected Node<E> right;
        public Node(E data){
            this.data = data;
            left = null;
            right = null;
        }
        public String toString(){
            return data.toString();
        }
    }
    protected Node<E> root;

    public BinaryTree(){
        root = null;
    }
    public BinaryTree(Node<E> root){
        this.root = root;
    }
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
        root = new Node<BinaryTree.E>(data);
        if(leftTree != null)
            root.left = leftTree;
        else
            root.left = null;
        if(rightTree != null)
            root.right = leftTree;
        else
            root.right = null;
    }
    public BinaryTree<E> getLeftSubtree(){
        if(root != null && root.left != null)
            return root.left;
        else
            return null;
    }
    public BinaryTree<E> getRightSubtree(){
        if(root != null && root.right != null)
            return root.right;
        else
            return null;
    }
    public boolean isLeaf(){
        return (root.left == null) && (root.right == null);
    }
    public String toString(){
       StringBuilder sb = new StringBuilder();
       preOrderTraverse(root, 1, sb);
       return sb.toString(); 
    }
    private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb){
        for(int i = 1; i < depth; i++){
            sb.append(" ");
        }
        if(node == null){
            sb.append("null\n");
        } else{
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth+1, sb);
            preOrderTraverse(node.right, depth+1, sb);
        }
    }
    
    public static BinaryTree<String> readBinaryTree(Scanner scan){
        String data = scan.next();
        if(data.equals("null"))
            return null;
        else{
            BinaryTree<String> left = readBinaryTree(scan);
            BinaryTree<String> right = readBinaryTree(scan);
            return new BinaryTree<String>(data, left, right);
        }
    }
}