package Java_Generics;

class Test1<T> {

    T obj;

    Test1(T obj){
        this.obj = obj;
    }

    T getObj(){
        return this.obj;
    }
}

class Driver1{
    public static void main(String[] args) {
//        Test1<String> obj1 = new Test1();
    }
}