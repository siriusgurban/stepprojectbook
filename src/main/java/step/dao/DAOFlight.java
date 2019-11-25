package src.main.java.dao;

import src.main.java.entity.Flight;
import src.main.java.io.IOFlight;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DAOFlight implements DAO<Flight> {
    List<Flight> flights;
    IOFlight ioFlight = new IOFlight();

    public void load() throws IOException {
        File file = new File("data/flights.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        flights = getAll();
    }

    public Flight get(int id) {
        ioFlight = new IOFlight();
        flights = null;
        try {
            flights = ioFlight.read();
        } catch (IOException e) {
            System.out.println("Error");
        } catch (ParseException e) {
            System.out.println("Error");
        }
        for (Flight flight : flights) {
            if (id == flight.getId()) {
                return flight;
            }
        }
        if (flights.equals(null)) {
            System.out.println("No flights!");
        }
        throw new IllegalArgumentException("No flights!");
    }

    public List<Flight> getAll() {
        IOFlight ioFlight = new IOFlight();
        List<Flight> read = new ArrayList<>(0);
        try {
            read = ioFlight.read();
        } catch (IOException e) {
            System.out.println("Error");
        } catch (ParseException e) {
            System.out.println("Error");
        }
        return read;

    }

    public void put(Flight flight) {

    }

    public void delete(int id) {

    }
}
