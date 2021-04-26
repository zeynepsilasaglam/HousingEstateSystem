import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.Collections;
import java.util.Scanner;

public class classmenu {
    public static void WHOLEMENU() {
        int choice;
        Scanner input = new Scanner(System.in);
        do {
            printMenu();
            System.out.println("Choose what do you want to do:");
            choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Write the address of the house which you want to create:");
                    input.nextLine();
                    String address = input.nextLine();
                    Housing_estate house = new Housing_estate(address);
                    System.out.println("Housing estate is created");
                }
                case 2 -> Menu2();
                case 3 -> vehicleMenu();
                case 4 -> personmenu();
                case 5 -> {
                    //Showing all people
                    System.out.println("1-see list of guests of exact apartment");
                    System.out.println("2-see all poeple");
                    System.out.println("0-back");
                    int choice1 = input.nextByte();
                    switch (choice1) {
                        case 0 -> {
                            return;
                        }
                        case 1 -> {
                            System.out.println("Enter ID of a house:");
                            input.nextLine();
                            String house_ID = input.nextLine();
                            Housing_estate housechosen = Housing_estate.housing_estate_findbyID(house_ID, Housing_estate.housing_estates_list);
                            System.out.println("Enter ID of apartment in indicated housing estate:");
                            String apartment_ID = input.nextLine();
                            Apartment apartment = Housing_estate.apartment_findbyID(apartment_ID, Housing_estate.apartments);
                            if (housechosen != null && apartment != null) {
                                for (Person resident : apartment.residents) {
                                    System.out.println(resident.getID() + " " + resident.getName() + " " + resident.getSurname());
                                }
                            } else System.out.println("Wrong ID of house or apartment!");
                        }
                        case 2 -> {
                            for (Person person : Person.getPeople_list()) {
                                System.out.println(person.getID() + " " + person.getName() + " " + person.getSurname());
                            }
                        }
                    }
                }
                case 6 -> {
                    System.out.println("Enter ID of a house:");
                    input.nextLine();
                    String house_ID = input.nextLine();
                    Housing_estate housechosen = Housing_estate.housing_estate_findbyID(house_ID, Housing_estate.housing_estates_list);
                    System.out.println("What do you want to see?");
                    System.out.println("1-List of apartments");
                    System.out.println("2-List of parking space");
                    System.out.println("0-back");
                    int choice1 = input.nextInt();
                    switch (choice1) {
                        case 0 -> {
                            return;
                        }
                        case 1 -> {
                            if (housechosen != null) {
                                for (Apartment apartment : housechosen.apartments) {
                                    System.out.println(apartment.getID() + " " + "with volume" + apartment.getVolume());
                                }
                            }
                            System.out.println("Wrong ID of housing estate");
                        }
                        case 2 -> {
                            if (housechosen != null) {
                                for (Parking_space p : housechosen.parkings) {
                                    System.out.println(p.getID() + "  with volume  " + p.getVolume() );
                                }
                            }
                            System.out.println("Wrong ID of housing estate");
                        }

                    }
                }
                case 7 -> {
                    //rent room
                    System.out.println("Enter ID of a house where you want to add apartment/parking space:");
                    input.nextLine();
                    String house_ID = input.nextLine();
                    System.out.println("WHAT DO YOU WANT TO RENT?");
                    System.out.println("1-apartment");
                    System.out.println("2-Parking space");
                    System.out.println("0-back");
                    int choice1 = input.nextInt();
                    input.nextLine();
                    switch (choice1) {
                        case 0 -> {
                            return;
                        }
                        case 1 -> {
                            System.out.println("Enter ID of apartment in indicated housing estate:");
                            String apartment_ID = input.nextLine();
                            System.out.println("Enter your ID:");
                            String person_ID = input.nextLine();
                            Person person = Person.person_findbyID(person_ID, Person.getPeople_list());
                            System.out.println("Enter Todays date(dd/mm/yyyy):");
                            String today_date = input.nextLine();
                            System.out.println("Enter rent end date(dd/mm/yyyy):");
                            String rent_end_date = input.nextLine();
                            person.rentApartment(house_ID, apartment_ID, rent_end_date, today_date);


                        }
                        case 2 -> {
                            System.out.println("Enter ID of parking space in indicated housing estate:");
                            String parking_ID = input.nextLine();
                            System.out.println("Enter your ID :");
                            String person_ID = input.nextLine();
                            Person person = Person.person_findbyID(person_ID, Person.getPeople_list());
                            System.out.println("Enter Todays date(dd/mm/yyyy):");
                            String today_date = input.nextLine();
                            System.out.println("Enter rent end date(dd/mm/yyyy):");
                            String rent_end_date = input.nextLine();
                            person.rentParking_space(house_ID, parking_ID, rent_end_date, today_date);

                        }
                    }

                }
                case 8 -> {
                    System.out.println("Enter ID of a house where you want to add apartment/parking space:");
                    input.nextLine();
                    String house_ID = input.nextLine();
                    System.out.println("Enter your ID :");
                    String person_ID = input.nextLine();
                    System.out.println("wHAT DO YOU WANT TO DO?");
                    System.out.println("1-renew");
                    System.out.println("2-cancel");
                    System.out.println("0-back");
                    int choice1 = input.nextInt();
                    input.nextLine();
                    switch (choice1) {
                        case 0 -> {
                            return;
                        }
                        case 1 -> {
                            System.out.println("1_renew rent of APARTMENT");
                            System.out.println("2_renew rent of Parking Space");
                            System.out.println("0-back");
                            int choice2 = input.nextInt();
                            input.nextLine();
                            switch (choice2) {
                                case 0 -> {
                                    return;
                                }
                                case 1 -> {
                                    System.out.println("Enter ID of apartment in indicated housing estate:");
                                    String apartment_ID = input.nextLine();
                                    Person person = Person.person_findbyID(person_ID, Person.getPeople_list());
                                    System.out.println("Enter rent end date(dd/mm/yyyy):");
                                    String rent_end_date = input.nextLine();
                                    person.renewrent_apartment(house_ID, apartment_ID, rent_end_date);

                                }
                                case 2 -> {
                                    System.out.println("Enter ID of parking space in indicated housing estate:");
                                    String parking_ID = input.nextLine();
                                    Person person = Person.person_findbyID(person_ID, Person.getPeople_list());
                                    System.out.println("Enter rent end date(dd/mm/yyyy):");
                                    String rent_end_date = input.nextLine();
                                    person.renewrent_parking(house_ID, parking_ID, rent_end_date);

                                }
                            }
                        }
                        case 2 -> {
                            System.out.println("1-cancel rent of APARTMENT");
                            System.out.println("2-cancel rent of Parking Space");
                            System.out.println("0-back");
                            int choice2 = input.nextInt();
                            input.nextLine();
                            switch (choice2) {
                                case 0 -> {
                                    return;
                                }
                                case 1 -> {
                                    System.out.println("Enter ID of apartment in indicated housing estate:");
                                    String apartment_ID = input.nextLine();
                                    Person person = Person.person_findbyID(person_ID, Person.getPeople_list());
                                    person.cancelrent_apartment(house_ID, apartment_ID);

                                }
                                case 2 -> {
                                    System.out.println("Enter ID of parking space in indicated housing estate:");
                                    String parking_ID = input.nextLine();
                                    Person person = Person.person_findbyID(person_ID, Person.getPeople_list());
                                    person.cancelrent_parking(house_ID, parking_ID);

                                }
                            }


                        }
                    }

                }
                case 9 -> {
                    //check in check out guest
                    System.out.println("Enter ID of a house where yo want to check in/out ur guest:");
                    input.nextLine();
                    String house_ID = input.nextLine();
                    System.out.println("Enter ID of apartment in indicated housing estate:");
                    String apartment_ID = input.nextLine();
                    System.out.println("Enter your ID :");
                    String person_ID = input.nextLine();
                    Person person = Person.person_findbyID(person_ID, Person.getPeople_list());
                    System.out.println("Enter ID of your guest:");
                    String guest_ID = input.nextLine();
                    System.out.println("What do you want to do?");
                    System.out.println("1-add guest");
                    System.out.println("2-remove guest");
                    System.out.println("0-back");
                    int choice1 = input.nextInt();
                    switch (choice1) {
                        case 0 -> {
                            return;
                        }
                        case 1 -> person.addguest(guest_ID, apartment_ID, house_ID);
                        case 2 -> person.removeguest(guest_ID, apartment_ID, house_ID);
                    }


                }
                case 10 -> {
                    //add remove vehicle
                    System.out.println("Enter ID of a house where you want to add/remove vehicle");
                    input.nextLine();
                    String house_ID = input.nextLine();
                    System.out.println("Enter ID of parking space in indicated housing estate:");
                    String parking_ID = input.nextLine();
                    System.out.println("Enter your ID :");
                    String person_ID = input.nextLine();
                    Person person = Person.person_findbyID(person_ID, Person.getPeople_list());
                    System.out.println("Enter ID of your vehicle:");
                    String vehicle_ID = input.nextLine();
                    System.out.println("What do you want to do?");
                    System.out.println("1-add");
                    System.out.println("2-remove");
                    int choice1 = input.nextInt();
                    input.nextLine();
                    switch (choice1) {
                        case 1 -> {
                            try {
                                person.add_vehicle(house_ID, parking_ID, vehicle_ID);
                            } catch (Notenoughplace notenoughplace) {
                                notenoughplace.printStackTrace();
                            }
                        }
                        case 2 -> {
                            person.remove_vehicle(house_ID, parking_ID, vehicle_ID);
                        }
                    }
                }
                case 11 -> {
                    try {
                        classmenu.writeToFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } while (choice != 0);
    }

    public static void printMenu() {
        System.out.println("1 - Create a Housing estate");
        System.out.println("2 - Add an apartment or parking space");
        System.out.println("3 - Add a new Vehicle");
        System.out.println("4 - Add a new Person");
        System.out.println("5 - Show all People");
        System.out.println("6 - See apartment/parking spaces list of housing estate");
        System.out.println("7 - Rent a room");
        System.out.println("8 - Renew/Cancel a rent");
        System.out.println("9 - Check in/out guests to/from apartment");
        System.out.println("10 - Add/Remove vehicle to/from parking place");
        System.out.println("11 - Save to a file");
        System.out.println("0 - Exit");
    }

    public static void personmenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("name:");
        String name = input.nextLine();
        System.out.println("surname:");
        String surname = input.nextLine();
        System.out.println("pesel:");
        int pesel = input.nextInt();
        input.nextLine();
        System.out.println("address");
        String address = input.nextLine();
        try {
            Person person = new Person(name, surname, pesel, address);
            System.out.println("successfully created a person");
        } catch (Exception e) {
            System.out.println("couldn't create a person");
        }
    }

    public static void vehicleMenu() {
        Scanner input = new Scanner(System.in);
        int choice;
        int choice1;
        int property;
        String name;
        int volume = 0;
        int h, w, l;
        System.out.println("Choose the way you want to enter volume");
        System.out.println("1 - volume");
        System.out.println("2 - height, width, length");
        choice1 = input.nextInt();
        if (choice1 == 1) {

            System.out.println("enter volume: ");
            int v1 = input.nextInt();
            volume = v1;
        }
        if (choice1 == 2) {
            System.out.println("enter height, width and length");
            h = input.nextInt();
            w = input.nextInt();
            l = input.nextInt();
            volume = h * w * l;
        }

        System.out.println("enter name of a car:");
        input.nextLine();
        name = input.nextLine();
        System.out.println("choose type of a vehicle:");
        System.out.println("1 - city car");
        System.out.println("2 - motorcycle");
        System.out.println("3 - boat");
        System.out.println("4 - off-road car");
        System.out.println("5 - amphibious");
        System.out.println("6 - basic items(table,chair etc)");
        System.out.println("0 - go back to menu");
        choice = input.nextInt();
        if (choice == 0) {
            return;
        }
        switch (choice) {

            case 1 -> {
                System.out.println("press 1 for Auto car \n press 2 for Mechanical car");
                property = input.nextInt();
                int v = volume;
                City_car v1 = new City_car(name, v, property - 1);
            }
            case 2 -> {
                System.out.println("Enter 1,2 or 3:");
                System.out.println("1-Diesel\t2-Petrol\t 3-Electric");
                property = input.nextInt();
                Motorcycle m1 = new Motorcycle(name, volume, property - 1);
            }
            case 3 -> {
                System.out.println("Enter 1,2 or 3:");
                System.out.println("1-Outboard\t2-Inboard\t 3-Stern Drive");
                property = input.nextInt();
                Boat b1 = new Boat(name, volume, property - 1);
            }
            case 4 -> {
                System.out.println("enter weight of a car");
                property = input.nextInt();
                Offroad_car o1 = new Offroad_car(name, volume, property);
            }

            case 5 -> {
                System.out.println("Enter production year:");
                property = input.nextInt();
                Amphibious a1 = new Amphibious(name, volume, property);
            }
            case 6 -> {
                Basic_items i1 = new Basic_items(name, volume);
                System.out.println("Item added");
            }
        }
    }

    public static void Menu2() {
        int volume = 0;
        int choice;
        int choice1;
        String house_ID;
        System.out.println("Enter ID of a house where you want to add apartment/parking space:");
        Scanner input = new Scanner(System.in);
        house_ID = input.nextLine();
        Housing_estate housechosen = Housing_estate.housing_estate_findbyID(house_ID, Housing_estate.housing_estates_list);
        if (housechosen != null) {
            System.out.println("Choose 1 or 2");
            System.out.println("1 - Create an Apartment");
            System.out.println("2 - Create a Parking Place");
            System.out.println("0 - Go back");
            choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("1 - volume");
                    System.out.println("2 - height, width, length");
                    choice1 = input.nextInt();
                    switch (choice1) {
                        case 1 -> {
                            System.out.println("enter volume: ");
                            volume = input.nextInt();
                        }
                        case 2 -> {
                            System.out.println("enter height, width and length");
                            volume = input.nextInt() * input.nextInt() * input.nextInt();
                        }
                    }
                    housechosen.addApartment(volume);
                    return;
                }

                case 2 -> {
                    System.out.println("1 - volume");
                    System.out.println("2 - height, width, length");
                    choice1 = input.nextInt();
                    switch (choice1) {
                        case 1 -> {
                            System.out.println("enter volume: ");
                            volume = input.nextInt();
                        }
                        case 2 -> {
                            System.out.println("enter height, width and length");
                            volume = input.nextInt() * input.nextInt() * input.nextInt();
                        }
                    }
                    housechosen.addParkingspace(volume);
                    return;
                }
            }
            while (choice != 0) ;
        } else System.out.println("There is no house with this ID! Wrong ID!");
    }

    public static void writeToFile() throws IOException {
        PrintWriter file;
        file = new PrintWriter("housing_estate.txt", "UTF-8");
        file.close();//deleting contents of file
        file = new PrintWriter("housing_estate.txt", "UTF-8");
        file.println(Housing_estate.housing_estates_list.size() + "  <- Housing estates in total:");
        for (Housing_estate house : Housing_estate.housing_estates_list) {
            file.println("Housing estate " + house.getID() +" has " +house.apartments.size() + " apartments and " + house.parkings.size() + " parkings");
            file.println("--------------------------------------------------------------");
            file.println("Apartments");
            for (Apartment apartment : house.apartments) {
                file.println(apartment.getID() + " " + "with volume" + apartment.getVolume() + " ");
            }
            file.println("Parkings");
            for (Parking_space p : house.parkings) {
                file.println(p.getID() + "  with volume  " + p.getVolume() );
            }
            file.println("People");
            for (Person person : Person.getPeople_list()) {
                file.println(person.getID() + " " + person.getName() + " " + person.getSurname());
            }
        }
        file.println("---------------");
        file.close();
    }

}