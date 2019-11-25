package step;

import src.main.java.entity.Country;
import src.main.java.io.IOCountry;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Countries implements Iterable<Country> {
    Country country1 = new Country(1, "Latvia");
    Country country2 = new Country(2, "Malta");
    Country country3 = new Country(3, "Japan");
    Country country4 = new Country(4, "Finland");
    Country country5 = new Country(5, "France");
    Country country6 = new Country(6, "Bulgaria");
    Country country7 = new Country(7, "Italy");
    Country country8 = new Country(8, "Austria");
    Country country9 = new Country(9, "Cyprus");
    Country country10 = new Country(10, "Hungary");
    Country country11 = new Country(11, "Estonia");
    Country country12 = new Country(12, "Albania");
    Country country13 = new Country(13, "Greece");
    Country country14 = new Country(14, "China");
    Country country15 = new Country(15, "Belgium");
    Country country16 = new Country(16, "United Kingdom");
    Country country17 = new Country(17, "Sweden");
    Country country18 = new Country(18, "Germany");
    Country country19 = new Country(19, "United States");
    Country country20 = new Country(20, "Denmark");

    private final List<Country> data = Arrays.asList(country1, country2, country3, country4, country5,
            country6, country7, country8, country9, country10,
            country11, country12, country13, country14, country15,
            country16, country17, country18, country19, country20
    );

    @Override
    public Iterator<Country> iterator() {
        return data.iterator();
    }

    public void create() {
        IOCountry ioCountry = new IOCountry();
        data.forEach(country -> {
            try {
                ioCountry.write(country);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
