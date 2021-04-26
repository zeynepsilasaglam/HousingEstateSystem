import java.util.*;
import java.util.Comparator;

abstract class Vehicles implements Comparable<Vehicles> {
    protected String properties;
    private String name;
    private int volume;
    private String ID;
    private String IDletter = "V";
    private int count = 1;
    static List<Vehicles> vehiclelist = new ArrayList<Vehicles>();

    public Vehicles(String name, int volume) {
        this.name = name;
        this.volume = volume;
        this.ID = IDletter + String.valueOf(this.count);
        this.count += 1;
        vehiclelist.add(this);
    }

    public Vehicles(String name, int h, int w, int l) {
        this.name = name;
        this.volume = h * w * l;
        this.ID = IDletter + String.valueOf(this.count);
        this.count += 1;
        vehiclelist.add(this);
    }

    public abstract void setProperties(String properties, int choice);

    public String getProperties() {
        return properties;
    }


    public int getVolume() {
        return volume;
    }

    public void setVolume(int height, int lenght, int width) {
        this.volume = height * lenght * width;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }


    static public Vehicles vehicle_findbyID(String ID, List<Vehicles> vehiclelist) {
        for (Vehicles v1 : vehiclelist) {
            if (v1.getID().equals(ID)) {
                return v1;
            }
        }
        return null;
    }

    public int compareTo(Vehicles vehicle2) {//natural order (by volume)
        return Integer.compare(this.volume, vehicle2.volume);
    }

    public String Sortbyname(Vehicles v1, Vehicles v2) {
        return String.valueOf((v1.name.compareTo(v2.name)));
    }
}
