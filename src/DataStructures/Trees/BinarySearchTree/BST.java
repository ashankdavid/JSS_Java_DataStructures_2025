package DataStructures.Trees.BinarySearchTree;

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

    BST(){
        root = null;
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

    private boolean searchRec(Node root, int key){
        if(root == null){
            return false;
        }
        if(key == root.key){
            return true;
        }
        if(key < root.key){
            return searchRec(root.left, key);
        }else{
            return searchRec(root.right, key);
        }
    }

    boolean search(int key){
        return searchRec(root, key);
    }

    Node findSuccessor(Node root){
        Node temp = root;
        while(temp.left!=null){
            temp = temp.left;
        }
        return temp;
    }

    private Node deleteRec(Node root, int key){
        if(root==null){
            return root;
        }
        if(key < root.key){
            root.left = deleteRec(root.left, key);
        }
        else if(key > root.key){
            root.right = deleteRec(root.right, key);
        }
        else{
            // You have found the node to be deleted
            // Case 1: Node has 0 or 1 child
            if(root.left == null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }

            // Case 2: Node with 2 children
            Node successor = findSuccessor(root.right);
            root.key = successor.key;
            root.right = deleteRec(root.right, successor.key);
        }
        return root;
    }

    void remove(int key){
        root = deleteRec(root, key);
    }

    void InDFS(Node root){
        if(root==null){
            return;
        }
        InDFS(root.left);
        System.out.print(root.key + " ");
        InDFS(root.right);
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

        bst.InDFS(bst.root);

        int key = 50;
        System.out.println(bst.search(key));
    }
}
