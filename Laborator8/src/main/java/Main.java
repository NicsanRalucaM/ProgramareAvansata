import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {
    public static void main(String args[]) {
        try {
            var continents = new ContinentDAO();
            continents.create("Europe");
            continents.create("Africa");
            Database.getConnection().commit();
            var countries = new CountryDAO();
            var cities = new CityDAO();
            int europeId = continents.findByName("Europe");
            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);
            Database.getConnection().commit();

            countries.findByContinent(europeId);
            Database.getConnection().commit();

            continents.importContinent();
            Database.getConnection().commit();

            countries.importCountry();
            Database.getConnection().commit();

            cities.importCity();
            Database.getConnection().commit();

            System.out.println(cities.distance("Paris", "London"));
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            //Database.rollback();
        }
    }

}
