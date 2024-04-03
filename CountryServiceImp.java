/*
it is service implementation 
in this class the all process have been processed like CURRENT TIMEOUT
from map arguments to seperate arguments to DAO class

*/

import java.sql.Timestamp;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.HashMap;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.sql.SQLException;

import java.time.format.DateTimeFormatter;
class CountryServiceImp implements CountryService{
	
	
	private CountryDAO contDAO = new CountryDAOImp();
	//insert operation to be done
	public void insertCountry( Map<String, Object> insert) {
		try{
			String id = String.valueOf(insert.get("ContId")); //object to be typecasted then store with the datatype (string)
			String name = String.valueOf(insert.get("ContName")); //object to be typecasted then store with the datatype(string)
			boolean isIsland =Boolean.valueOf(String.valueOf( insert.get("isIsland"))); //object to be typecasted then store with the datatype(boolean)
			String logInName = String.valueOf(insert.get("logInName")); //object to be typecasted then store with the datatype(string)
			String famousPlace = String.valueOf(insert.get("famous_Place")); //object to be typecasted then store with the datatype(string)
			// Pass the converted values to the insertCountry method
			LocalDateTime currentDateTime = LocalDateTime.now(); 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String formattedDateTime = currentDateTime.format(formatter);   // current time operation 
			Timestamp datetime = Timestamp.valueOf(formattedDateTime);
			int rowsAffected = contDAO.insertCountry(id, name, isIsland, logInName, datetime,famousPlace);
			if (rowsAffected > 0) {
				System.out.println("Country record inserted successfully.");
				System.out.println();
			} 
			else {
				System.out.println("Failed to insert country record.");
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//update operation to be done
	public void updateCountryName(Map<String, Object> updateName) {
		try{
			String idU = String.valueOf(updateName.get("CountryId"));  //object to be typecasted then store with the datatype(string)
			String nameU = String.valueOf(updateName.get("CountryName")); //object to be typecasted then store with the datatype(string)
			String logInNameU = String.valueOf(updateName.get("logInName")); //object to be typecasted then store with the datatype(string)
			//Timestamp datetimeU = (Timestamp) argMap.get("timestamp");
			
			LocalDateTime currentDateTime2 = LocalDateTime.now();
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String formattedDateTime2 = currentDateTime2.format(formatter2);
			Timestamp datetimeU = Timestamp.valueOf(formattedDateTime2);  // current time operation 
			int rowsAffected = contDAO.updateCountryName(idU, nameU, logInNameU, datetimeU); // map data's to be stored as argument and then passen to DAO implementation
			if (rowsAffected > 0) {
				System.out.println("Country updated successfully.");
				System.out.println();
			} 
			else {
				System.out.println("Failed to update country.");
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//updating island
	public void updateIsIsland(Map<String, Object> updateIsland){
		try{
			String idU = String.valueOf(updateIsland.get("CountryId")); //object to be typecasted then store with the datatype(string)
			String logInNameU = String.valueOf(updateIsland.get("logInName")); //object to be typecasted then store with the datatype(String)
			boolean isIslandU = Boolean.valueOf(String.valueOf( updateIsland.get("isIsland"))); //object to be typecasted then store with the datatype (boolean)
			LocalDateTime currentDateTime2 = LocalDateTime.now();
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String formattedDateTime2 = currentDateTime2.format(formatter2);
			Timestamp datetimeU = Timestamp.valueOf(formattedDateTime2);   // current time operation 
			int rowsAffected = contDAO.updateIsIsland(idU, isIslandU, logInNameU, datetimeU); // map data's to be stored as argument and then passen to DAO implementation
			if (rowsAffected > 0) {
				System.out.println("Country updated successfully.");
				System.out.println();
			} 
			else {
				System.out.println("Failed to update country.");
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	   
	}
	//update famous Place field
	public void updateFamousPlace(Map<String, Object> updatePlace){
		try{
			String idU = String.valueOf(updatePlace.get("CountryId"));
			String logInNameU = String.valueOf(updatePlace.get("logInName"));
			String famousPlace = String.valueOf(updatePlace.get("famousPlace"));
			LocalDateTime currentDateTime2 = LocalDateTime.now();
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String formattedDateTime2 = currentDateTime2.format(formatter2);
			Timestamp datetimeU = Timestamp.valueOf(formattedDateTime2);   // current time operation 
			int rowsAffected = contDAO.updateFamousPlace(idU, famousPlace, logInNameU, datetimeU); // map data's to be stored as argument and then passen to DAO implementation
			if (rowsAffected > 0) {
				System.out.println("Country updated successfully.");
				System.out.println();
			} 
			else {
				System.out.println("Failed to update country.");
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//it is used to display all the details in the country
	public void displayAllCountries() {
		try{
			ArrayList<Map<String, Object>> countries = contDAO.displayAllCountries();
			for (Map<String, Object> countryDetails : countries) {
				String countryId = String.valueOf(countryDetails.get("Country ID"));
				String name = String.valueOf(countryDetails.get("Country Name"));
				boolean isIsland = Boolean.parseBoolean(String.valueOf(countryDetails.get("Is Island")));
				String logInName = String.valueOf(countryDetails.get("Created By"));
				Timestamp datetime = (Timestamp) countryDetails.get("Created Date Time");
				String updateName = String.valueOf(countryDetails.get("Updated By"));
				Timestamp Udatetime = (Timestamp) countryDetails.get("Updated Date Time");
				String famousPlace = String.valueOf(countryDetails.get("Famous Place"));
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
				String createdDateTime = datetime.toLocalDateTime().format(formatter);
				String modifiedDateTime = Udatetime.toLocalDateTime().format(formatter);   // current time operation 
				System.out.println("Country ID        : " + countryId);
				System.out.println("Country Name      : " + name);
				System.out.println("Is Island         : " + isIsland);
				System.out.println("Created By        : " + logInName);
				System.out.println("Created Date Time : " + createdDateTime);
				System.out.println("Updated By        : " + updateName);
				System.out.println("Updated Date Time : " + modifiedDateTime);
				System.out.println("Famous Place      : " + famousPlace);
				
				System.out.println("---------------------------------------");
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//display by id
    public void displayCountryById(String id) {
		try{
			Map<String, Object> countryDetails = contDAO.displayCountryById(id);
			String countryId = String.valueOf(countryDetails.get("Country Id"));
			String name = String.valueOf(countryDetails.get("Country Name"));
			boolean isIsland = Boolean.valueOf(String.valueOf(countryDetails.get("Is Island")));
			String logInName = String.valueOf(countryDetails.get("Created By"));
			Timestamp datetime = (Timestamp) countryDetails.get("Created Date Time");
			String updateName = String.valueOf(countryDetails.get("Updated By"));
			Timestamp Udatetime = (Timestamp) countryDetails.get("Updated Date Time");
			String famousPlace = String.valueOf(countryDetails.get("Famous Place"));
			
			//convert "yyyy-MM-dd HH:mm:ss"   to  "dd-MMM-yyyy HH:mm:ss"  
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
			String createdDateTime = datetime.toLocalDateTime().format(formatter);
			String modifiedDateTime = Udatetime.toLocalDateTime().format(formatter);  // current time operation 
			System.out.println("Country ID        : " + countryId);
			System.out.println("Country Name      : "+name);
			System.out.println("Is Island         : "+isIsland);
			System.out.println("Created By        : "+logInName);
			System.out.println("Created Date Time : "+createdDateTime );
			System.out.println("Updated By        : "+updateName);
			System.out.println("Updated Date Time : "+modifiedDateTime);
			System.out.println("Famous Place      : "+famousPlace);
			System.out.println("---------------------------------------");
			System.out.println();
			System.out.println();
			//contDAO.displayCountry(id);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
    }
	//delete by id
    public void deleteCountry(String id) {
		try{
			// calling DAO interface and its implementation
			int rowsAffected = contDAO.deleteCountryById(id);
			if (rowsAffected > 0) {
				System.out.println("Country record deleted successfully.");
				System.out.println();
			} 
			else {
				System.out.println("Failed to delete country record.");
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
    }
}
