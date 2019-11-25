package src.main.java.io;

import src.main.java.entity.Country;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOCountry {
    String path = "data/countries.txt";

    public List<Country> read() throws IOException {
        List<Country> countries = new ArrayList<Country>();
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null) {
            int id = Integer.parseInt(line.split(" : ")[0]);
            String name = line.split(" : ")[1];
            countries.add(new Country(id,name));
        }
        br.close();
        return countries;
    }

    public void write(Country country) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        StringBuilder sb = new StringBuilder();
        sb.append(country.getId() + " : " + country.getName());
        bw.write(sb.toString());
        bw.newLine();
        bw.close();
    }
}
