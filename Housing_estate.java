import java.util.ArrayList;
import java.util.List;

public class Housing_estate {
    private String address;
    private static int count = 1;
    private String IDletter = "HE";
    private String ID;
    static List<Apartment> apartments;
   List<Parking_space> parkings;
     static List<Housing_estate> housing_estates_list = new ArrayList<Housing_estate>();

    public Housing_estate(String address) {
        this.address = address;
        this.ID = IDletter + String.valueOf(this.count);
        this.apartments = new ArrayList<Apartment>();
        this.parkings = new ArrayList<Parking_space>();
        this.count += 1;
        housing_estates_list.add(this);
    }

    public List<Housing_estate> getHousing_estates_list() {
        return housing_estates_list;
    }

    public void setHousing_estates_list(List<Housing_estate> housing_estates_list) {
        this.housing_estates_list = housing_estates_list;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public void addApartment(int volume) {
        Apartment apartment = new Apartment(volume);
        apartments.add(apartment);
    }


    public void addApartment(int h, int w, int l) {
        Apartment apartment = new Apartment(h, w, l);
        apartments.add(apartment);
    }

    public void addParkingspace(int volume) {
        Parking_space parking = new Parking_space(volume);
        parkings.add(parking);
    }

    public void addParkingspace(int h, int w, int l) {
        Parking_space parking = new Parking_space(h, w, l);
        parkings.add(parking);
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public List<Parking_space> getParkings() {
        return parkings;
    }

    public void setParkings(List<Parking_space> parkings) {
        this.parkings = parkings;
    }

    static public Housing_estate housing_estate_findbyID(
            String ID, List<Housing_estate> housing_estates_list) {
        for (Housing_estate house : housing_estates_list) {
            if (house.getID().equals(ID)) {
                return house;
            }
        }
        return null;
    }
    static public Parking_space parking_space_findbyID(String ID, List<Parking_space> parkings) {
        for (Parking_space p1 : parkings) {
            if (p1.getID().equals(ID)) {
                return p1;
            }
        }
        return null;
    }
    static public Apartment apartment_findbyID(String ID, List<Apartment> apartments) {
        for (Apartment a1 : apartments) {
            if (a1.getID().equals(ID)) {
                return a1;
            }
        }
        return null;
    }
}


