package src.main.java.service;

import step.SystemConsole;
import src.main.java.dao.DAOFlight;
import src.main.java.entity.Flight;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TimetableService {
    private final SystemConsole systemConsole;
    DAOFlight daoFlight = new DAOFlight();

    public TimetableService() {
        this.systemConsole = new SystemConsole();
    }

    public void show(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        try {
            List<Flight> all = daoFlight.getAll().stream().filter(flight -> {
                LocalDateTime checkDateTime = flight.getDate();
                boolean isDateTrue = (checkDateTime.compareTo(fromDateTime) >= 0) && (checkDateTime.compareTo(toDateTime) <= 0);
                return isDateTrue;
            }).collect(Collectors.toList());
            printFlights(all);
        } catch (Exception e) {
            System.out.println("It is not correct");
        }
    }

    public void showLine(int id) {
        try {
            Flight flight = daoFlight.get(id);
            List<Flight> all = new ArrayList<>();
            all.add(flight);
            printFlights(all);
        } catch (Exception e) {
            System.out.println("It is not correct");
        }
    }

    public HashMap<Integer, Flight> search(String fromCityName, String toCityName, String date, String nTickets) {
        HashMap<Integer, Flight> book = new HashMap<>(0);
        try {
            List<Flight> all = daoFlight.getAll().stream().filter(flight -> {
                String from = flight.getSource().getName();
                String to = flight.getDestination().getName();
                int year = Integer.parseInt(date.split("\\.")[0]);
                int month = Integer.parseInt(date.split("\\.")[1]);
                int day = Integer.parseInt(date.split("\\.")[2]);
                boolean equalDate = (year == flight.getDate().getYear()) && (month == flight.getDate().getMonthValue()) && (day == flight.getDate().getDayOfMonth());
                boolean enoughEmptySeats = Integer.parseInt(nTickets) <= flight.getEmptySeats();
                return enoughEmptySeats
                        && from.equalsIgnoreCase(fromCityName)
                        && to.equalsIgnoreCase(toCityName)
                        && equalDate;
            }).collect(Collectors.toList());
            printFlights(all);

            if (all.size() > 0) {
                systemConsole.printLn("Please enter flight id to book a flight or press 0 to return back to the main menu");
                String in = systemConsole.readLn();
                int flightId = checkInputIsInteger(in);
                for (Flight flight : all) {
                    if (flight.getId() == flightId) {
                        int n = checkInputIsInteger(nTickets);
                        book.put(n, flight);
                        System.out.println(book);
                        return book;
                    }
                }
            }
        } catch (Exception e) {
            systemConsole.printLn("No flights");
        }
        return book;
    }

    public void printFlights(List<Flight> all) {
        for (Flight flight : all) {
            systemConsole.printLn("id:" + flight.getId()
                    + ", source:" + flight.getSource().getName()
                    + ", destination:" + flight.getDestination().getName()
                    + ", emptySeats:" + flight.getEmptySeats()
                    + ", date:" + flight.getDate());
        }

        if (all.size() == 0) System.out.println("No Flights");
    }

    public int checkInputIsInteger(String input) {
        int id = -1;
        while (true) {
            try {
                input = systemConsole.readLn();
                id = Integer.parseInt(input);
                break;
            } catch (Exception e) {
                System.out.println("Please, enter an right integer : ");
            }
        }
        return id;
    }

    public void load() throws IOException {
        daoFlight.load();
    }
}
