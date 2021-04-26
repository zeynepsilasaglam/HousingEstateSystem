import java.util.Date;


abstract class Space implements Comparable<Space> {
    private String id;
    private int volume;
    Person Tenant;
    Date rent_start;
    Date rent_end;

    public Space(int volume) {
        this.volume = volume;

    }

    public Space(int h, int w, int l) {
        this.volume = h * w * l;
    }

    public Person getTenant() {
        return Tenant;
    }

    public void setTenant(Person tenant) {
        Tenant = tenant;
    }

    public Date getRent_start() {
        return rent_start;
    }

    public void setRent_start(Date rent_start) {
        this.rent_start = rent_start;
    }

    public Date getRent_end() {
        return rent_end;
    }

    public void setRent_end(Date rent_end) {
        this.rent_end = rent_end;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setVolume(int height, int lenght, int width) {
        this.volume = height * lenght * width;
    }

    @Override
    public int compareTo(Space space) {
        return Integer.compare(this.volume, space.volume);
    }

    public abstract void checkdeadline(Date today);
    public abstract void clear();
}


