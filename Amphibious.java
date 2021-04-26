public class Amphibious extends  Vehicles{

    public Amphibious(String name, int volume, int productionyear) {
        super(name, volume);
        setProperties(this.properties, productionyear);
    }

    public Amphibious(String name, int h, int w, int l, int productionyear) {
        super(name, h, w, l);
        setProperties(this.properties, productionyear);
    }

    @Override
    public void setProperties(String properties, int productionear) {
        this.properties = "the production year is" + String.valueOf(productionear);
    }
}
