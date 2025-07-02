package DataStructures.Trees.BinaryTrees;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    static Node createNode(int val){
        Node n = new Node(val);
        return n;
    }

    static void DFS(Node root){
        if(root==null) { return;}

        System.out.print(root.data + " ");
        DFS(root.left);
        DFS(root.right);
    }

    public static void main(String[] args) {
        Node root = createNode(1); // Level 1

        root.left = createNode(2); // Level 2
        root.right = createNode(3);

        root.left.left = createNode(4); // Level 3
        root.left.right = createNode(5);
        root.right.left = createNode(6);
        root.right.right = createNode(7);

        root.left.right.left = createNode(8); // Level 4
        root.right.left.left = createNode(15);
        root.right.left.right = createNode(9);

        DFS(root);
    }
}

