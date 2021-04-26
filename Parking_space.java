import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Parking_space extends Space {
    private int busy_volume;
    private static int count = 1;
    private String IDletter = "PS";
    private String ID;
    List<Vehicles> items_list = new ArrayList<Vehicles>();

    public Parking_space(int volume) {
        super(volume);
        this.ID = IDletter + String.valueOf(this.count);
        this.count += 1;
    }

    public Parking_space(int h, int w, int l) {
        super(h, w, l);
        this.ID = IDletter + String.valueOf(this.count);
        this.count += 1;
    }

    @Override
    public void checkdeadline(Date today) {
        if ((Tenant != null) && (today.after(rent_end))) {
            TenantLetter letter = new TenantLetter("Warning! The rent is not paid. You must make the payment.",getID());
            Tenant.letters.add(letter);
            System.out.println("A letter was sent to " + Tenant.getName() + " with id: " + Tenant.getID());

        }
    }

    @Override
    public void clear() {
        this.items_list.clear();
        this.busy_volume = 0;
        System.out.println("parking space is cleared");
    }

    public int getBusy_volume() {
        return busy_volume;
    }

    public void setBusy_volume(int busy_volume) {
        this.busy_volume = busy_volume;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getIDletter() {
        return IDletter;
    }

    public void setIDletter(String IDletter) {
        this.IDletter = IDletter;
    }

    public String getID() {
        return ID;
    }


}
