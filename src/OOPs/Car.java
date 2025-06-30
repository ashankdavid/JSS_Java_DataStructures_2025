package OOPs;

public class Car {
    String brandName;
    int manuDate;

    Car(String bName, int mDate){
        brandName = bName;
        manuDate = mDate;
    }

    public static void main(String[] args) {
        Car c1 = new Car("Audi", 2001);
        Car c2 = new Car("BMW", 2005);
    }
}
