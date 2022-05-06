import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class CountryDAO {
    public void create(String name, int continent) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert ignore into countries (name, continent) values (?,?)")) {
            pstmt.setString(1, name);
            pstmt.setInt(2, continent);
            pstmt.executeUpdate();
        }
    }

    public int findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from countries where name='" + name + "'")) {
            while (rs.next())
                return rs.getInt(1);
        }
        return -1;
    }

    public void findByContinent(int continent) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from countries where continent='" + continent + "'")) {
            while (rs.next())
                System.out.println(rs.getString("name"));
        }
    }

    public void findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select name from countries where id='" + id + "'");
        ) {

            while (rs.next())
                System.out.println(rs.getString("name"));
        }
    }

    public void importCountry() {
        Connection con = Database.getConnection();
        var continents = new ContinentDAO();
        String csvPath = "C:/Users/raluc/Downloads/archive/concap.csv/";
        try (CSVReader reader = new CSVReader(new FileReader(csvPath))) {
            String[] csvLine;
            csvLine = reader.readNext();
            for (int i = 1; i < 246; i++) {
                csvLine = reader.readNext();
                String countryName = csvLine[0];
                String countryCode = csvLine[4];
                String continentName = csvLine[5];
                try (PreparedStatement pstmt = con.prepareStatement(
                        "insert ignore into countries (name,code,continent) values (?,?,?)")) {

                    int continent = continents.findByName(continentName);
                    pstmt.setString(1, countryName);
                    pstmt.setString(2, countryCode);
                    pstmt.setInt(3, continent);
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
}
