package Programs.BST;

class Node{
    int key;
    Node left;
    Node right;

    Node(int data){
        this.key = data;
        this.left = null;
        this.right = null;
    }
}

public class BST {
    Node root;
    Long prevVal;

    BST(){
        root = null;
        prevVal = null;
    }

    private Node insertRec(Node root, int key){
        if(root==null){
            Node n = new Node(key);
            return n;
        }
        if(key < root.key){
            root.left = insertRec(root.left, key);
        }else if(key > root.key){
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    void insert(int key){
        root = insertRec(root, key);
    }

    private boolean isBSTHelper(Node root, long min, long max){
        if(root == null) return true;
        if(root.key <= min || root.key >= max) return false;

        return isBSTHelper(root.left, min, root.key) &&
                isBSTHelper(root.right, root.key, max);
    }

    boolean isBST(){
        return isBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean InOrderCheck(Node root){
        if(root==null) return true;

        if(!InOrderCheck(root.left)) return false;

        if(prevVal!=null && root.key <= prevVal) return false;
        prevVal = (long) root.key;

        return InOrderCheck(root.right);
    }

    boolean isBSTUsingInorder(){
        prevVal = null;
        return InOrderCheck(root);
    }
}

class DriverCode{
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(50);
        bst.insert(30);
        bst.insert(80);
        bst.insert(10);
        bst.insert(40);
        bst.insert(70);
        bst.insert(100);
        bst.insert(35);
        bst.insert(60);
        bst.insert(75);

        // I made a violation to check if our validator is working fine or not!
//        bst.root.left.left.left = new Node(500);

        System.out.println(bst.isBST());
        System.out.println(bst.isBSTUsingInorder());

    }
}
