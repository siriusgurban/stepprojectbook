package src.main.java.io;

import src.main.java.entity.Booking;
import src.main.java.entity.Flight;
import src.main.java.entity.Passenger;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IOBooking {
    String path = "data/bookings.txt";

    public List<Booking> read() throws IOException, ParseException {
        List<Booking> bookings = new ArrayList<Booking>();
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null) {
            bookings.add(defineBooking(line));
        }

        br.close();
        return bookings;
    }

    public void write(Booking booking) throws IOException {
        File file = new File(path);
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        StringBuilder sb = new StringBuilder();
        String passengers = "";
        for (Passenger p : booking.getPassengers()){
            passengers+=p.getName()+p.getSurname()+"/";
        }
        sb.append(booking.getFlight().getId() + " : " + passengers +" : " + booking.getDate());
        bw.write(sb.toString());
        bw.newLine();
        bw.close();
    }

    public Booking defineBooking(String line) throws IOException, ParseException {
        IOFlight ioFlight = new IOFlight();
        String[] split = line.split(" : ");
        int flightId = Integer.parseInt(split[0]);
        List<Flight> flights = ioFlight.read();
        Flight flight1 = null;
        for (Flight flight:flights){
            if (flight.getId()==flightId){
                flight1=flight;
            }
        }
        String passengersName = split[1];
        String str = split[2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date = LocalDateTime.parse(str, formatter);
        List<Passenger> passengers = new ArrayList<>();
        String[] split1 = passengersName.split("/");
        List<String> ps = Arrays.asList(split1);
        for (String p : ps){
            String name = p.split(" ")[0];
            String surname = p.split(" ")[1];
            passengers.add(new Passenger(name,surname));
        }
        return new Booking(flight1,passengers, date,passengers.get(0));
    }
}
