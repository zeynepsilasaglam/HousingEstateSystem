import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Person {
    private String ID;
    private String IDletter = "P";
    private String name;
    private String surname;
    private int pesel;
    private String address;
    private static int count = 1;
    private boolean rentsApartment = false;
    Space[] rentspace = new Space[5];
    List<TenantLetter> letters = new ArrayList<TenantLetter>();
    static List<Person> people_list = new ArrayList<Person>();

    public Person(String name, String surname, int pesel, String address) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.address = address;
        this.ID = IDletter + String.valueOf(this.count);
        this.count += 1;
        people_list.add(this);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getID() {
        return ID;
    }

    public String getIDletter() {
        return IDletter;
    }

    public void setIDletter(String IDletter) {
        this.IDletter = IDletter;
    }

    public static List<Person> getPeople_list() {
        return people_list;
    }

    public static void setPeople_list(List<Person> people_list) {
        Person.people_list = people_list;
    }

    public boolean getRentsApartment() {
        return rentsApartment;
    }

    public void setRentsApartment(boolean rentsApartment) {
        this.rentsApartment = rentsApartment;
    }

    static public Person person_findbyID(String ID, List<Person> people_list) {
        for (Person guest : people_list) {
            if (guest.getID().equals(ID)) {
                return guest;
            }
        }
        return null;
    }

    static public TenantLetter letter_findbyID(String ID, List<TenantLetter> letters) {
        for (TenantLetter l1 : letters) {
            if (l1.getRoom_id().equals(ID)) {
                return l1;
            }
        }
        return null;
    }

    public void rentApartment(String ID_housing_estate, String ID_apartment, String rent_end, String today) {
        Housing_estate currenthouse = Housing_estate.housing_estate_findbyID(ID_housing_estate, Housing_estate.housing_estates_list);
        Apartment current = Housing_estate.apartment_findbyID(ID_apartment, currenthouse.apartments);
        if (current == null) {
            return;
        }
        if (this.rentspace[4] != null) {
            System.out.println("You already rent 5 spaces, sorry!");
            return;
        } else if (current.Tenant != null) {
            System.out.println("This room busy,sorry!");
            return;
        } else {
            for (int i = 0; i < rentspace.length; i++) {
                if (rentspace[i] == null) {
                    rentspace[i] = (Space) current;
                    current.Tenant = this;
                    try {
                        current.rent_start = new SimpleDateFormat("dd/MM/yyyy").parse(today);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    try {
                        current.rent_end = new SimpleDateFormat("dd/MM/yyyy").parse(rent_end);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    setRentsApartment(true);
                    System.out.println("Apartment with ID:" + current.getID() + "was rented to person" + this.getName() + " " + this.getID());
                    System.out.println(" Rent end date is:" + current.rent_end + "Please pay you rent before deadline!");
                    return;
                }
            }
        }
    }

    public void rentParking_space(String ID_housing_estate, String ID_parking_space, String rent_end, String today) {
        Housing_estate currenthouse = Housing_estate.housing_estate_findbyID(ID_housing_estate, Housing_estate.housing_estates_list);
        Parking_space current = Housing_estate.parking_space_findbyID(ID_parking_space, currenthouse.parkings);
        if (this.rentsApartment != false) {
            if (this.rentspace[4] != null) {
                System.out.println("You already rent 5 spaces, sorry!");
                return;
            } else if (current.Tenant != null) {
                System.out.println("This room busy,sorry!");
                return;
            } else {

                for (int i = 0; i < rentspace.length; i++) {
                    if (rentspace[i] == null) {
                        rentspace[i] = (Space) current;
                        current.Tenant = this;
                        try {
                            current.rent_start = new SimpleDateFormat("dd/MM/yyyy").parse(rent_end);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        ;
                        try {
                            current.rent_end = new SimpleDateFormat("dd/MM/yyyy").parse(rent_end);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        setRentsApartment(true);
                        System.out.println("Parking space with ID:" + current.getID() + "was rented to person" + this.getName() + " " + this.getID());
                        System.out.println(" Rent end date is:" + current.rent_end + "Please pay you rent before deadline!");
                        return;
                    }
                }
            }
        } else
            System.out.println("You can not rent a parking space if you are not renting an apartment!");
        return;
    }

    public void addguest(String person_ID, String apartment_ID, String house_ID) {
        Housing_estate currenthouse = Housing_estate.housing_estate_findbyID(house_ID, Housing_estate.housing_estates_list);
        Apartment current = Housing_estate.apartment_findbyID(apartment_ID, currenthouse.apartments);
        Person currentperson = Person.person_findbyID(person_ID, Person.people_list);
        if (currentperson == this) {
            System.out.println("You can't add yourself as a guest!");
            return;
        }
        for (int i = 0; i < rentspace.length; i++) {
            if (rentspace[i] == (Space) current && current != null) {
                current.residents.add(currentperson);
            }
        }
        System.out.println("Tenant is not renting this apartment");
    }

    public void removeguest(String person_ID, String apartment_ID, String house_ID) {
        Housing_estate currenthouse = Housing_estate.housing_estate_findbyID(house_ID, Housing_estate.housing_estates_list);
        Apartment currentapartment = Housing_estate.apartment_findbyID(apartment_ID, currenthouse.apartments);
        Person currentperson = Apartment.person_findbyID(person_ID, currentapartment.residents);
        if (currentperson != null) {
            for (int i = 0; i < rentspace.length; i++) {
                if (rentspace[i] == (Space) currentapartment && currentapartment!=null) {
                    currentapartment.residents.remove(currentperson);
                }

            }
            System.out.println("Tenant is not renting this apartment");
        } else System.out.println("You do not have this guest in your list");
    }

    public void add_vehicle(String house_ID, String parking_ID, String vehicle_ID) throws Notenoughplace {
        Housing_estate currenthouse = Housing_estate.housing_estate_findbyID(house_ID, Housing_estate.housing_estates_list);
        Parking_space currentparking = Housing_estate.parking_space_findbyID(parking_ID, currenthouse.parkings);
        Vehicles v1 = Vehicles.vehicle_findbyID(vehicle_ID, Vehicles.vehiclelist);
        if (currenthouse != null) {
            if (currentparking != null) {
                if (v1 != null) {
                    for (int i = 0; i < rentspace.length; i++) {
                        if (rentspace[i] == (Space) currentparking) {
                            if (currentparking.getBusy_volume() + v1.getVolume() > currentparking.getVolume()) {
                                throw new Notenoughplace("Remove some old items, because you dont have enough space for this item");
                            } else {
                                currentparking.items_list.add(v1);
                                currentparking.setBusy_volume(currentparking.getBusy_volume() + v1.getVolume());
                                return;
                            }
                        }

                    }
                    System.out.println("Tenant is not renting this Parking space");
                } else System.out.println("Wrong vehicle ID");
            } else System.out.println("Wrong parking space ID");
        } else System.out.println("Wrong house ID");
    }

    public void remove_vehicle(String house_ID, String parking_ID, String vehicle_ID) {
        Housing_estate currenthouse = Housing_estate.housing_estate_findbyID(house_ID, Housing_estate.housing_estates_list);
        Parking_space currentparking = Housing_estate.parking_space_findbyID(parking_ID, currenthouse.parkings);
        Vehicles v1 = Vehicles.vehicle_findbyID(vehicle_ID, Vehicles.vehiclelist);
        Vehicles v2 = Vehicles.vehicle_findbyID(vehicle_ID, currentparking.items_list);
        if (currenthouse != null) {
            if (currentparking != null) {
                if (v1 != null) {
                    for (int i = 0; i < rentspace.length; i++) {
                        if (rentspace[i] == (Space) currentparking) {
                            if (v1 == v2) {
                                currentparking.items_list.remove(v1);
                                currentparking.setBusy_volume(currentparking.getBusy_volume() - v1.getVolume());
                                return;
                            }
                        }
                        System.out.println("Tenant is not renting this Parking space");
                    }
                } else System.out.println("Wrong vehicle ID");
            } else System.out.println("Wrong parking space ID");
        } else System.out.println("Wrong house ID");
    }

    public void renewrent_apartment(String house_ID, String apartment_ID, String rent_end) {
        Housing_estate currenthouse = Housing_estate.housing_estate_findbyID(house_ID, Housing_estate.housing_estates_list);
        Apartment currentapartment = Housing_estate.apartment_findbyID(apartment_ID, currenthouse.apartments);
        TenantLetter l1 = letter_findbyID(apartment_ID, letters);
        if (currentapartment != null && currenthouse != null) {
            if (l1 != null) {
                letters.remove(l1);
            }
            for (int i = 0; i < rentspace.length; i++) {
                if (rentspace[i] == (Space) currentapartment) {
                    try {
                        currentapartment.rent_end = new SimpleDateFormat("dd/MM/yyyy").parse(rent_end);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

            }
            System.out.println("Tenant is not renting this Parking space");

        } else System.out.println("Wrong house ID or apartment ID");
    }

    public void cancelrent_apartment(String house_ID, String apartment_ID) {
        Housing_estate currenthouse = Housing_estate.housing_estate_findbyID(house_ID, Housing_estate.housing_estates_list);
        Apartment currentapartment = Housing_estate.apartment_findbyID(apartment_ID, currenthouse.apartments);
        TenantLetter l1 = letter_findbyID(apartment_ID, letters);
        if (currentapartment != null && currenthouse != null) {
            if (l1 != null) {
                letters.remove(l1);
            }
            for (int i = 0; i < rentspace.length; i++) {
                if (rentspace[i] == (Space) currentapartment) {
                    currentapartment.clear();
                }
            }
            System.out.println("Tenant is not renting this Parking space");
        } else System.out.println("Wrong house ID or apartment ID");
    }

    public void renewrent_parking(String house_ID, String parking_ID, String rent_end) {
        Housing_estate currenthouse = Housing_estate.housing_estate_findbyID(house_ID, Housing_estate.housing_estates_list);
        Parking_space currentparking = Housing_estate.parking_space_findbyID(parking_ID, currenthouse.parkings);
        TenantLetter l1 = letter_findbyID(parking_ID, letters);
        if (currentparking != null && currenthouse != null) {
            if (l1 != null) {
                letters.remove(l1);
            }
            for (int i = 0; i < rentspace.length; i++) {
                if (rentspace[i] == (Space) currentparking) {
                    try {
                        currentparking.rent_end = new SimpleDateFormat("dd/MM/yyyy").parse(rent_end);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Tenant is not renting this Parking space");
        } else System.out.println("Wrong house ID or apartment ID");
    }

    public void cancelrent_parking(String house_ID, String parking_ID) {
        Housing_estate currenthouse = Housing_estate.housing_estate_findbyID(house_ID, Housing_estate.housing_estates_list);
        Parking_space currentparking = Housing_estate.parking_space_findbyID(parking_ID, currenthouse.getParkings());
        TenantLetter l1 = letter_findbyID(parking_ID, letters);
        if (currentparking != null && currenthouse != null) {
            if (l1 != null) {
                letters.remove(l1);
            }
            for (int i = 0; i < rentspace.length; i++) {
                if (rentspace[i] == (Space) currentparking) {
                    currentparking.clear();
                }
            }
            System.out.println("Tenant is not renting this Parking space");
        } else System.out.println("Wrong house ID or apartment ID");
    }


}


