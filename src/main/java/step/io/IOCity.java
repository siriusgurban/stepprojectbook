package src.main.java.io;

import src.main.java.entity.City;
import src.main.java.entity.Country;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOCity {
    String path = "data/cities.txt";

    public List<City> read() throws IOException {
        List<City> cities = new ArrayList<City>();
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null) {
            cities.add(defineCity(line));
        }
        br.close();
        return cities;
    }

    public void write(City city) throws IOException {
        File file = new File(path);
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        StringBuilder sb = new StringBuilder();
        sb.append(city.getId() + " : " + city.getName() + " : " + city.getCountry().getName());
        bw.write(sb.toString());
        bw.newLine();
        bw.close();
    }

    public City defineCity(String line) throws IOException {
        IOCountry ioCountry = new IOCountry();
        int id = Integer.parseInt(line.split(" : ")[0]);
        String name = line.split(" : ")[1];
        String countryName = line.split(" : ")[2];
        List<Country> countries = ioCountry.read();
        Country c = null;
        for (Country country : countries) {
            if (countryName.equals(country.getName())) {
                c = country;
            }
        }
        return new City(id, name, c);
    }
}
