public class City_car extends Vehicles {
   private String[] transmissiontypes = {"Auto", "Mechanical"};

    public City_car(String name, int volume, int choice) {
        super(name, volume);
       setProperties(this.properties,choice);
    }

    public City_car(String name, int h, int w, int l, int choice) {
        super(name, h, w, l);

    }

    public String[] getTransmissiontypes() {
        return transmissiontypes;
    }

    public void setTransmissiontypes(String[] transmissiontypes) {
        this.transmissiontypes = transmissiontypes;
    }


    @Override
    public void setProperties(String properties, int choice) {
        this.properties=this.transmissiontypes[choice];

    }

}
