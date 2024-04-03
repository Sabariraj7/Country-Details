/*
It is used for get the country Details and updation
*/

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class CountryDetails {                                           
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String logInName = "";
        while (true) { //it is end when the we want to exit 
            System.out.println("Enter login : ");
            logInName = sc.next();  // This input is used to store the details with the name
            // creation of object to CountryService
            CountryService countryService = new CountryServiceImp();

            while (true) {
                System.out.println("1.Insert a Country");
                System.out.println("2.Update");
                System.out.println("3.DisplayAll Country");
                System.out.println("4.Display Country");
                System.out.println("5.Delete Country by ID");
                System.out.println("6.Close");
                int inpt = sc.nextInt();

                switch (inpt) {
                    case 1:
                        // Inserting new records
                        System.out.print("Enter Country Id : ");
                        String countryId = sc.next();
                        System.out.print("Enter Country Name : ");
                        String countryName = sc.next();
                        System.out.print("isIsland : ");
						char ch = sc.next().charAt(0);
						boolean isIsland = false;
						if(ch == 'y') isIsland = true;
                        System.out.print("Enter Famous Place : ");
                        String famousPlace = sc.next();
						System.out.println();
                        Map<String, Object> insertDetails = new HashMap<>(); //details are stored in the map and it is passen to the next class
                        insertDetails.put("ContId", countryId);
                        insertDetails.put("ContName", countryName);
                        insertDetails.put("isIsland", isIsland);
                        insertDetails.put("logInName", logInName);
                        insertDetails.put("famous_Place", famousPlace);
                        countryService.insertCountry(insertDetails);
                        break;

                    case 2:
                        // Updating the existing records
                        System.out.println("-->1.Update Name\n   2.Update Is Island\n   3.Update Famous Place");
                        int option = sc.nextInt();
                        if (option == 1) {  // update name
                            System.out.print("Enter country id to update : ");
                            String countryIdUd = sc.next();
                            System.out.print("Enter Name : ");
                            String countryNameUd = sc.next();
                            Map<String, Object> updateDetails = new HashMap<>();//details are stored in the map and it is passen to the next class
                            updateDetails.put("CountryId", countryIdUd);
                            updateDetails.put("CountryName", countryNameUd);
                            updateDetails.put("logInName", logInName);
                            countryService.updateCountryName(updateDetails);
                        } 
						else if (option == 2) {  // update isIsland
                            System.out.print("Enter country id : ");
                            String countryIdUd = sc.next();
                            System.out.print("isIsland : ");
                            char cha = sc.next().charAt(0);
							boolean isIslandUd = false;
							if(cha == 'y') isIsland = true;
							System.out.println();
                            Map<String, Object> updateDetails = new HashMap<>();//details are stored in the map and it is passen to the next class
                            updateDetails.put("CountryId", countryIdUd);
                            updateDetails.put("IsIsland", isIslandUd);
                            updateDetails.put("logInName", logInName);
                            countryService.updateIsIsland(updateDetails);
                        } 
						else if (option == 3) { // update famous place
                            System.out.print("Enter country id : ");
                            String countryIdUd = sc.next();
                            System.out.print("Enter Famous Place : ");
                            String famousPlaceUd = sc.next();
                            Map<String, Object> updateDetails = new HashMap<>(); //details are stored in the map and it is passen to the next class
                            updateDetails.put("CountryId", countryIdUd);
                            updateDetails.put("famousPlace", famousPlaceUd);
                            updateDetails.put("logInName", logInName);
                            countryService.updateFamousPlace(updateDetails);
                        }
                        break;

                    case 3:
                        // Print all details in the table
                        System.out.println("All Country Data's ");
                        countryService.displayAllCountries();
                        break;

                    case 4:
                        // Print the details by id
                        System.out.print("Enter ID to Display Country ");
                        String dispId = sc.next();
                        countryService.displayCountryById(dispId);
                        break;

                    case 5:
                        // Delete country by id
                        System.out.print("Enter ID to Delete Country ");
                        String delId = sc.next();
                        countryService.deleteCountry(delId);
                        break;
                }
                // Exit
                if (inpt == 6) {
                    break;
                }
            }
            System.out.print("Do you Want to LogIN y/n : ");
            char cur = sc.next().charAt(0);
            if (cur != 'y' && cur != 'Y') {
                break;
            }
        }

        // Close the Scanner
        sc.close();
    }
}


  