package src.main.java.io;

import src.main.java.entity.City;
import src.main.java.entity.Flight;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class IOFlight {
    String path = "data/flights.txt";

    public List<Flight> read() throws IOException, ParseException {
        List<Flight> flights = new ArrayList<Flight>();
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedReader br = new BufferedReader(new FileReader(path));
        IOCity ioCity = new IOCity();
        String line;
        while ((line = br.readLine()) != null) {
            flights.add(defineFlight(line));
        }

        br.close();
        return flights;
    }

    public void write(Flight flight) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        StringBuilder sb = new StringBuilder();
        sb.append(flight.getId() + " : " + flight.getSource().getName() + " : " + flight.getDestination().getName() + " : " + flight.getSeats() + " : " + flight.getEmptySeats() + " : " + flight.getDate());
        bw.write(sb.toString());
        bw.newLine();
        bw.close();
    }

    public Flight defineFlight(String line) throws IOException, ParseException {
        IOCity ioCity = new IOCity();
        List<City> cities = ioCity.read();
        String[] split = line.split(" : ");
        int id = Integer.parseInt(split[0]);
        String citySource = split[1];
        String cityDes = split[2];
        int seats = Integer.parseInt(split[3]);
        int emptySeats = Integer.parseInt(split[4]);
        LocalDateTime date =LocalDateTime.parse(split[5]);
        City source =null;
        City destination =null;
        for (City city : cities) {
            if (city.getName().equals(citySource)) {
                source = city;
            }
            if (city.getName().equals(cityDes)) {
                destination = city;
            }
        }
        return new Flight(id,source,destination,seats,emptySeats,date);
    }
}
