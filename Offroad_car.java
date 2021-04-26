public class Offroad_car extends Vehicles {


    public Offroad_car(String name, int volume, int weight) {
        super(name, volume);
        setProperties(this.properties, weight);
    }

    public Offroad_car(String name, int h, int w, int l, int weight) {
        super(name, h, w, l);
        setProperties(this.properties,weight);
    }


    @Override
    public void setProperties(String properties, int weight) {
        this.properties = "the weight of the Off-road car is" + String.valueOf(weight);
    }
}
