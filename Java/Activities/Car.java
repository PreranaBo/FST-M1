package activities;

public class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;
    Car ()
    {
        tyres=4;
        doors=4;
    }
    public void displayCharacteristics(){
        System.out.println("Color is: " + color);
        System.out.println("Transmission: " + transmission);
        System.out.println("Make is: " + make);
        System.out.println("Door Numbers: " + doors);
        System.out.println("Tyre Numbers: " + tyres);

    }
    public void accelerate(){
        System.out.println("car is accelerated");
    }
    public void brake(){
        System.out.println("car is stopped");
    }

}
