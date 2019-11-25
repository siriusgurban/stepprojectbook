package step;

import src.main.java.entity.Flight;
import src.main.java.io.IOFlight;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Flights {
    private final IOFlight ioFlight;
    private final Database db;
    private final Cities cities = new Cities();
    Flight flight1 = new Flight(1, cities.city1, cities.city2, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight2 = new Flight(2, cities.city2, cities.city3, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight3 = new Flight(3, cities.city3, cities.city4, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight4 = new Flight(4, cities.city4, cities.city5, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight5 = new Flight(5, cities.city5, cities.city6, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight6 = new Flight(6, cities.city6, cities.city7, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight7 = new Flight(7, cities.city7, cities.city8, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight8 = new Flight(8, cities.city8, cities.city9, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight9 = new Flight(9, cities.city9, cities.city10, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight10 = new Flight(10, cities.city10, cities.city11, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight11 = new Flight(11, cities.city11, cities.city12, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight12 = new Flight(12, cities.city12, cities.city13, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight13 = new Flight(13, cities.city13, cities.city14, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight14 = new Flight(14, cities.city14, cities.city15, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight15 = new Flight(15, cities.city15, cities.city16, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight16 = new Flight(16, cities.city16, cities.city17, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight17 = new Flight(17, cities.city17, cities.city18, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight18 = new Flight(18, cities.city18, cities.city19, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight19 = new Flight(19, cities.city19, cities.city20, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight20 = new Flight(20, cities.city20, cities.city1, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight21 = new Flight(21, cities.city1, cities.city2, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight22 = new Flight(22, cities.city2, cities.city3, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight23 = new Flight(23, cities.city1, cities.city2, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight24 = new Flight(24, cities.city2, cities.city3, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight25 = new Flight(25, cities.city1, cities.city2, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight26 = new Flight(26, cities.city1, cities.city2, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight27 = new Flight(27, cities.city1, cities.city2, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    Flight flight28 = new Flight(28, cities.city1, cities.city2, 50, 50, LocalDateTime.parse("2019-11-22T00:00"));
    private final List<Flight> data = Arrays.asList(flight1, flight2, flight3, flight4, flight5,
            flight6, flight7, flight8, flight9, flight10,
            flight11, flight12, flight13, flight14, flight15,
            flight16, flight17, flight18, flight19, flight20,
            flight21, flight22, flight23, flight24,
            flight25, flight26, flight27, flight28);

    public Flights() {
        this.ioFlight = new IOFlight();
        this.db = new Database();
    }

    public Iterator<Flight> iterator() {
        return data.iterator();
    }

    public void load() throws IOException, ParseException {
        List<Flight> flights = ioFlight.read();
    }

    public void create() {
        data.forEach(flight -> {
            try {
                ioFlight.write(flight);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
