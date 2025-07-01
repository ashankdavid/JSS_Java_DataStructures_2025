package Programs.LinkedList;

class Node{
    char data;
    Node next;
    Node prev;

    Node(char data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DLL {
    Node head;

    DLL(){
        head = null;
    }

    void insertHead(char val){
        Node n = new Node(val);
        if(head!=null){
            head.prev = n;
        }
        n.next = head;
        head = n;
    }

    void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    void RotateByN(int N){
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = head;
        head.prev = temp;

        while(N-- > 0){
            head = head.next;
            temp = temp.next;
        }

        head.prev = null;
        temp.next = null;
    }
}

class DriverCode{
    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insertHead('e');
        dll.insertHead('d');
        dll.insertHead('c');
        dll.insertHead('b');
        dll.insertHead('a');
        System.out.println("Before Rotation: ");
        dll.display();
        System.out.println();
        System.out.println("After Rotation: ");
        dll.RotateByN(3);
        dll.display();

    }
}
