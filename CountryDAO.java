
//it is an interface of DAO class
import java.sql.Timestamp;
import java.util.Map;
import java.util.ArrayList;
import java.sql.SQLException;
interface CountryDAO {
    int insertCountry(String id, String name, boolean isIsland, String logInName, Timestamp datetime, String famousPlace) throws Exception;
    int updateCountryName(String id, String newName, String logInName, Timestamp datetime)throws Exception;
    int updateIsIsland(String id, boolean isIsland, String logInName, Timestamp datetime)throws Exception;
    int updateFamousPlace(String id, String famousPlace, String logInName, Timestamp datetime)throws Exception;
    ArrayList<Map<String, Object>> displayAllCountries()throws Exception;
    Map<String, Object> displayCountryById(String id)throws Exception;
    int deleteCountryById(String id)throws Exception;
}
