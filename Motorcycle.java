public class Motorcycle extends Vehicles{
    private String[] fueltype = {"1-Diesel", "2-Petrol", "3-Electric"};


    public Motorcycle(String name, int volume, int choice) {
        super(name, volume);
        setProperties(this.properties, choice);
    }

    public Motorcycle(String name, int h, int w, int l, int choice) {
        super(name, h, w, l);
        setProperties(this.properties, choice);
    }

    public String[] getFueltype() {
        return fueltype;
    }

    public void setFueltype(String[] fueltype) {
        this.fueltype = fueltype;
    }

    @Override
    public void setProperties(String properties, int choice) {
        this.properties=this.fueltype[choice];
    }
}
