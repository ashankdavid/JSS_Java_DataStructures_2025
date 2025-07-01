package DataStructures.LinkedList.Singly;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class SLL {
    private Node head;

    SLL(){
        head = null;
    }

    void insertAtHead(int val){
        Node n = new Node(val);
        n.next = head;
        head = n;
    }

    void insertAtTail(int val){
        Node n = new Node(val);
        if(head==null){
            head = n;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = n;
    }

    int getSize(){
        int size = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        return size;
    }

    void insertAtPos(int val, int pos){
        Node n = new Node(val);
        int LLsize = getSize();
        if(pos<0 || pos>LLsize){
            System.out.println("Invalid Position Entered!");
        }else if(pos == 0){
            n.next = head;
            head = n;
        }else{
            Node temp = head;
            while(--pos > 0){
                temp = temp.next;
            }
            n.next = temp.next;
            temp.next = n;
        }
    }

    void deleteAtHead(){
        if(head==null){
            return;
        }
        Node todelete = head;
        head = head.next;
        todelete = null; // This will call Garbage Collection
        // to delete making 1st head node to be deleted
    }

    void deleteByVal(int val){
        if(head == null) return;

        if(head.data == val){
            deleteAtHead();
            return;
        }

        Node temp = head;
        while(temp.next!=null && temp.next.data!=val){
            temp = temp.next;
        }

        if(temp.next == null){
            System.out.println("The value which you are looking for is not present in the linked list");
            return;
        }

        Node todelete = temp.next;
        temp.next = temp.next.next;
        todelete = null;
    }

    void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NUll");
    }
}

class DriverCode{
    public static void main(String[] args) {
        SLL ll = new SLL();
        ll.insertAtTail(50);
        ll.display();
        ll.insertAtHead(10);
        ll.insertAtHead(20);
        ll.insertAtHead(30);
        ll.insertAtHead(40);
        ll.display();
        ll.insertAtPos(100, 30000);
        ll.display();
        ll.deleteAtHead();
        ll.display();
        ll.deleteByVal(10);
        ll.display();
        ll.deleteByVal(500);
    }
}
