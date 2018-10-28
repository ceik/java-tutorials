public class BicycleBasic {

    // three fields
    public int cadence;
    public int gear;
    public int speed;

    // one constructor
    public BicycleBasic(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }

    // four methods
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