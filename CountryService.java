
// it is an interface for service class
import java.util.Map;
import java.sql.Timestamp;
interface CountryService{
	void insertCountry(Map<String, Object> insert); 
	void updateCountryName(Map<String, Object> updateName);
	void updateIsIsland(Map<String, Object> updateIsland);
	void updateFamousPlace(Map<String, Object> updateFamous);
    void displayCountryById(String id);
    void deleteCountry(String id);
	void displayAllCountries();
	//update is_island
}

