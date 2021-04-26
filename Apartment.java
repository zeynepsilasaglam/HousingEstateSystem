import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Apartment extends Space {
    private static int count = 1;
    private String IDletter = "A";
    private String ID;
    public List<Person> residents = new ArrayList<Person>();

    public Apartment(int volume) {
        super(volume);
        this.ID = IDletter + String.valueOf(this.count);
        this.count = count + 1;
    }


    public Apartment(int h, int w, int l) {
        super(h, w, l);
        this.ID = IDletter + String.valueOf(this.count);
        this.count = count + 1;
    }

    @Override
    public void checkdeadline(Date today) {
        if ((Tenant != null) && (today.after(rent_end))) {
            TenantLetter letter = new TenantLetter("Warning! The rent is not paid. You must make the payment.", getID());
            Tenant.letters.add(letter);
            System.out.println("A letter was sent to " + Tenant.getName() + " with id: " + Tenant.getID());

        }
    }

    public List<Person> getResidents() {
        return residents;
    }

    public void setResidents(List<Person> residents) {
        this.residents = residents;
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


    @Override
    public void clear() {
        this.Tenant = null;
        this.residents.clear();
        System.out.println("apartment cleared");
    }

    static public Person person_findbyID(String ID, List<Person> residents) {
        for (Person guest : residents) {
            if (guest.getID().equals(ID)) {
                return guest;
            }
        }
        return null;
    }
}