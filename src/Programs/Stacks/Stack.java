package Programs.Stacks;

public class Stack {
    int[] arr;
    int top;
    int size;

    Stack(int size){
        this.size = size;
        top = -1;
        arr = new int[size];
    }

    void push(int val){
        if(top == size-1){
            System.out.println("Overflow");
            return;
        }
        top++;
        arr[top] = val;
    }

    void pop(){
        if(top==-1){
            System.out.println("Underflow");
            return;
        }
        top--;
    }

    int Top(){
        if(top==-1){
            System.out.println("Underflow");
            return -1;
        }
        return arr[top];
    }

    boolean isEmpty(){
        return top == -1;
    }

    static boolean isBalanced(String exp){
        Stack st = new Stack(10);
        for(char ch : exp.toCharArray()){
            if(ch=='('){
                st.push(ch);
            }else if(ch == ')'){
                if(st.isEmpty()){
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("())"));
    }
}
