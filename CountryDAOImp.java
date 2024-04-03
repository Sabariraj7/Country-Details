import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class CountryDAOImp implements CountryDAO {
	public int insertCountry(String id, String name, boolean isIsland, String logInName, Timestamp datetime, String famousPlace) throws Exception {
		Connection con = null;
		Statement stmt = null;
		int resultAdd = 0;
		try {
			con = DBconnect.createConnection();
			stmt = con.createStatement();
			String query = "INSERT INTO country_details (country_ID, country_name, is_island, created_by, created_date_time, updated_by, updated_date_time, famous_place) VALUES (" +
					"'" + id + "', " +
					"'" + name + "', " +
					"'" + (isIsland ? 1 : 0) + "', " +  
					"'" + logInName + "', " +
					"'" + datetime + "', " +
					"'" + logInName + "', " +
					"'" + datetime + "', " +
					"'" + famousPlace + "')";
			resultAdd = stmt.executeUpdate(query);
		} 
		catch (SQLException e) {
			throw new Exception("SQL error while adding country: " + e.getMessage(), e);
		} 
		finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} 
			catch (Exception ex) {
				System.out.println(ex);
			}
		}
		return resultAdd;
	}
	
	
    public ArrayList<Map<String, Object>> displayAllCountries() throws Exception {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
        ArrayList<Map<String, Object>> countryMap = new ArrayList<>();
        try 
		{
			con = DBconnect.createConnection();
             stmt = con.createStatement();
             rs = stmt.executeQuery("SELECT * FROM Country_Details");
            while (rs.next()) {
                Map<String, Object> countryDetails = new HashMap<>();
                countryDetails.put("Country ID", rs.getString("country_iD"));
                countryDetails.put("Country Name", rs.getString("country_name"));
                countryDetails.put("Is Island", rs.getBoolean("is_island"));
                countryDetails.put("Created By", rs.getString("created_by"));
                countryDetails.put("Created Date Time", rs.getTimestamp("created_date_time"));
                countryDetails.put("Updated By", rs.getString("updated_by"));
                countryDetails.put("Updated Date Time", rs.getTimestamp("updated_date_time"));
                countryDetails.put("Famous Place", rs.getString("famous_place"));
                countryMap.add(countryDetails);
              }
        } catch (Exception e) {
            throw new Exception("Error while Displaying countries!!",e);
        }
		finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
        return countryMap;
    }
	// this menthod is used to take out the particular recode and it to passed
    public Map<String, Object> displayCountryById(String id) throws Exception {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int resultAdd = 0;
        Map<String, Object> countryDetails = new HashMap<>();
        try {
			con = DBconnect.createConnection();
             stmt = con.createStatement();
             rs = stmt.executeQuery("SELECT * FROM Country_Details WHERE country_id = '" + id + "'") ;
            if (rs.next()) {
                countryDetails.put("Country Id", rs.getString("Country_ID"));
                countryDetails.put("Country Name", rs.getString("Country_Name"));
                countryDetails.put("Is Island", rs.getBoolean("is_island"));
                countryDetails.put("Created By", rs.getString("created_by"));
                countryDetails.put("Created Date Time", rs.getTimestamp("created_date_time"));
                countryDetails.put("Updated By", rs.getString("updated_by"));
                countryDetails.put("Updated Date Time", rs.getTimestamp("updated_date_time"));
                countryDetails.put("Famous Place", rs.getString("famous_Place"));
            }
        } catch (Exception e) {
            throw new Exception("Error while Displaying country!!", e);

        }
		finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
        return countryDetails;
    }
	// This method is used to update the data in any field
    public int updateCountryName(String id, String newName, String updateLog, Timestamp datetime) throws Exception{
		Connection con = null;
		Statement stmt = null;
		int resultAdd = 0;
        try {
			con = DBconnect.createConnection();
             stmt = con.createStatement() ;
            String query = "UPDATE Country_Details SET country_name = '" + newName + "', updated_by = '" + updateLog + "', updated_date_time = '" + datetime + "' WHERE country_ID = '" + id + "'";
            resultAdd = stmt.executeUpdate(query);
        }
		catch (Exception e) {
            throw new Exception("Error while updating country name", e);

        }
		finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} 
			catch (Exception ex) {
				System.out.println( ex);
			}
		}
		return resultAdd;
    }
	
	// This method is used to update the data in any field
    public int updateIsIsland(String id, boolean isIsland, String updateLog, Timestamp datetime)throws Exception {
		Connection con = null;
		Statement stmt = null;
		int resultAdd = 0;
		try {
			con = DBconnect.createConnection();
			stmt = con.createStatement() ;
			int isIslandValue = isIsland ? 1 : 0; // Convert boolean to integer
			String query = "UPDATE Country_Details SET is_island = " + isIsland + ", updated_by = '" + updateLog + "', updated_date_time = '" + datetime + "' WHERE country_ID = '" + id + "'";
			resultAdd = stmt.executeUpdate(query);
		} 
		catch (Exception e) {
			throw new Exception("Error while updating Island", e);

		}
		finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} 
			catch (Exception ex) {
				System.out.println( ex);
			}
		}
		return resultAdd;
	}
	// This method is used to update the data in any field
    public int updateFamousPlace(String id, String famousPlace, String updateLog, Timestamp datetime) throws Exception {
		Connection con = null;
		Statement stmt = null;
		int resultAdd = 0;
        try {
			con = DBconnect.createConnection();
            stmt = con.createStatement() ;
            String query = "UPDATE Country_Details SET famous_place = '" + famousPlace + "', updated_by = '" + updateLog + "', updated_date_time = '" + datetime + "' WHERE country_ID = '" + id + "'";
            resultAdd = stmt.executeUpdate(query);
        } catch (Exception e) {
            throw new Exception("Error while updating Famous place", e); 
        }
		finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} 
			catch (Exception ex) {
				System.out.println( ex);
			}
		}
		return resultAdd;
    }
	// this method is used to delete the record in the table
    public int deleteCountryById(String id) throws Exception{
		Connection con = null;
		Statement stmt = null;
		int resultAdd = 0;
        try {
			con = DBconnect.createConnection();
             stmt = con.createStatement();
            String query = "DELETE FROM country_details WHERE country_id = '" + id + "'";
            resultAdd = stmt.executeUpdate(query);
        }
		catch (Exception e) {
            throw new Exception("Error while deleting a country  ", e);
        }
		finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} 
			catch (Exception ex) {
				System.out.println( ex);
			}
		}
		return resultAdd;
    }
}
