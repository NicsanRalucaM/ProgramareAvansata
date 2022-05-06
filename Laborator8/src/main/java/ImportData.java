import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImportData {

    public void importData() throws FileNotFoundException {
        Connection con = Database.getConnection();
        var continents = new ContinentDAO();
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
                String countryCode = csvLine[4];
               String continentName = csvLine[5];
                try (PreparedStatement pstmt = con.prepareStatement(
                        "INSERT ignore INTO continents (name) values (?)")){
                    pstmt.setString(1, continentName);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                con.commit();
                try (PreparedStatement pstmt = con.prepareStatement(
                        "insert into countries (name,code,continent) values (?,?,?)")) {
                    //pstmt.setInt(1, id);

                    int continent=continents.findByName(continentName);
                    pstmt.setString(1, countryName);
                    pstmt.setString(2, countryCode);
                    pstmt.setInt(3, continent);
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
