import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class CityDAO {
    public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;

    public void importCity() {
        Connection con = Database.getConnection();
        var countries = new CountryDAO();
        int country = 1;
        String csvPath = "C:/Users/raluc/Downloads/archive/concap.csv/";
        try (CSVReader reader = new CSVReader(new FileReader(csvPath))) {
            String[] csvLine;
            csvLine = reader.readNext();
            for (int i = 1; i < 246; i++) {
                csvLine = reader.readNext();
                String countryName = csvLine[0];
                String capitalName = csvLine[1];
                String latitude = csvLine[2];
                String longitude = csvLine[3];

                try (PreparedStatement pstmt = con.prepareStatement(
                        "insert ignore into cities (name,capital,country,latitude,longitude) values (?,?,?,?,?);")) {
                    //pstmt.setInt(1, id);

                    //country = countries.findByName(countryName);
                    pstmt.setString(1, capitalName);
                    pstmt.setInt(2, 1);
                    pstmt.setInt(3, country);
                    pstmt.setFloat(4, Float.parseFloat(latitude));
                    pstmt.setFloat(5, Float.parseFloat(longitude));
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double distance(String city1, String city2) {
        Connection con = Database.getConnection();
        float lat1 = 0, lat2 = 0, long1 = 0, long2 = 0;
        try (
                Statement stmt = con.createStatement();
                ResultSet rs1 = stmt.executeQuery("select latitude,longitude from cities where name='" + city1 + "'")) {
            rs1.next();
            lat1 = rs1.getFloat(1);
            long1 = rs1.getFloat(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (
                Statement stmt2 = con.createStatement();
                ResultSet rs2 = stmt2.executeQuery("select latitude,longitude from cities where name='" + city2 + "'")) {
            rs2.next();
            lat2 = rs2.getFloat(1);
            long2 = rs2.getFloat(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        long1 = (float) Math.toRadians(long1);
        long2 = (float) Math.toRadians(long2);
        lat1 = (float) Math.toRadians(lat1);
        lat2 = (float) Math.toRadians(lat2);

        // Haversine formula
        double dlon = long2 - long1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        double r = 6371;

        // calculate the result
        return (c * r);
    }
}
