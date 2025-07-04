package Programs.BST.BalancedTree;

class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BalancedBinaryTree {

    static int height(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    static boolean isBalanced(Node root){
        if(root==null){
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        if(isBalanced(root)){
            System.out.println("Balanced");
        }else{
            System.out.println("Not - Balanced");
        }

    }
}
