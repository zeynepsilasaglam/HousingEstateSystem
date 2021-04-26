public class Basic_items extends Vehicles{

    public Basic_items(String name, int volume) {
        super(name, volume);
    }

    public Basic_items(String name, int h, int w, int l) {
        super(name, h, w, l);
    }

    @Override
    public void setProperties(String properties, int choice) {
        return;
    }
}
