package activities;

public class Activity1 {
    public static void main(String[] args) {
        Car audi = new Car();
        audi.make = 2014;
        audi.color = "Black";
        audi.transmission = "Manual";

        audi.displayCharacteristics();
        audi.accelerate();
        audi.brake();
    }
}



