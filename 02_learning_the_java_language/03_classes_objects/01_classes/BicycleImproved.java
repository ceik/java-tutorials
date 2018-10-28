public class BicycleBasic {

    private int cadence;
    private int gear;
    private int speed;

    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }

    public int getCadence() {
        return cadence;
    }

    public int getGear() {
        return gear;
    }

    public int getSpeed() {
        return speed;
    }

    public void setCadence(int newValue) {
        cadence = newValue;
    }

    public void setGear(int newValue) {
        gear = newValue;
    }

    public void applyBreaks(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }
}

public class MountainBike extends Bicycle {

    // one field
    public int seatHeight;

    // one constructor
    public MountainBike(int startCadence, int startSpeed, int startGear,
                        int startHeight) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }

    // one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
}