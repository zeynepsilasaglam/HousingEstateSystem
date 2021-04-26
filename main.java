import java.text.SimpleDateFormat;

public class main {
    final static SimpleDateFormat dateFormat =new SimpleDateFormat("dd-MM-yyyy");
    public static void main(String[] args) {
        Housing_estate house1 = new Housing_estate("Raclawicka146");//HE1
        house1.addApartment(33);//A1
        house1.addApartment(60);//A2
        house1.addApartment(2,13,7);//A3
        house1.addApartment(3,7,5);//A4
        house1.addApartment(20);//A5
        house1.addParkingspace(70);//PS1
        house1.addParkingspace(20);//PS2
        house1.addParkingspace(9);
        house1.addParkingspace(2,2,2);
        house1.addParkingspace(2,3,3);
        Person p1= new Person("Jalil", "Abrahamlee", 129304,"adress_Jalil" );//P1
        Person p2= new Person("Zeynep", "Saglam", 234567,"adress_Zeynep" );//P2
        Person p3= new Person("John", "Lennon", 345678,"TheBeatles" );
        Person p4= new Person("Klaus", "Meine", 456789,"Scorpions" );
        Person p5= new Person("Matthew James", " Bellamy", 567890,"Muse" );
        Offroad_car v1 = new Offroad_car("offroad car 1", 20, 100);//V1
        City_car v2 = new City_car("Alfa Romeo Guiletta", 2,2,3, 1);//V2
        Boat v3 = new Boat("boat", 40, 2);
        Motorcycle v4 = new Motorcycle("motorcycle 1", 1,1,3, 2);
        Amphibious v5 = new Amphibious("amphibious 1", 50, 2010);
        Basic_items v6= new Basic_items("Table",2);
        p1.rentParking_space ("HE1","A1", "01/04/2021", "01/03/2021");
        p1.addguest("P2","A1","HE1");
        p1.rentParking_space("HE1","PS2","01/04/2021","01/03/2021");
        try {
            p1.add_vehicle("HE1","PS2","V2");
        } catch (Notenoughplace notenoughplace) {
            notenoughplace.printStackTrace();
        }
        p3.rentApartment("HE1","A2","23/05/2021","23/04/2021");
        p3.addguest("P4","A2", "HE1");
        p3.addguest("P5","A2", "HE1");
        classmenu.WHOLEMENU();
    }
}
