package DataStructures.Queues;

public class Queue {
    int[] arr;
    int front, back;
    int size;

    Queue(int n){
        size = n;
        front = back = -1;
        arr = new int[size];
    }

    void push(int x){
        if(back == size-1){
            System.out.println("Overflown");
            return;
        }
        back++;
        arr[back] = x;

        if(front == -1){
            front++;
        }
    }

    void pop(){
        if(front == -1 || front > back){
            System.out.println("Underflown");
            return;
        }
        front++;
    }

    int peek(){
        if(front == -1 || front > back){
            System.out.println("Underflown");
            return -1;
        }
        return arr[front];
    }

    boolean isEmpty(){
        if(front == -1 || front > back){
            return true;
        }
        return false;
    }
}
