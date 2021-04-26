public class Boat extends Vehicles{
    private String[] enginetypes = {"Outboard", "Inboard", "Stern Drive"};

    public Boat(String name, int volume, int choice) {
        super(name, volume);
        setProperties(this.properties,choice);
    }

    public Boat(String name, int h, int w, int l, int choice) {
        super(name, h, w, l);
        setProperties(this.properties,choice);
    }

    public String[] getEnginetypes() {
        return enginetypes;
    }

    public void setEnginetypes(String[] enginetypes) {
        this.enginetypes = enginetypes;
    }

    @Override
    public void setProperties(String properties, int choice) {
        this.properties=this.enginetypes[choice];
    }
}
