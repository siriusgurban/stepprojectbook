package src.main.java.dao;

import src.main.java.entity.Booking;
import src.main.java.io.IOBooking;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class DAOBooking implements DAO<Booking> {
    List<Booking> bookings;
    IOBooking ioBooking = new IOBooking();
    public void load() throws IOException {
        File file = new File("data/bookings.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        bookings = getAll();
    }

    public Booking get(int id) {
        ioBooking = new IOBooking();
        bookings = null;
        try {
            bookings = ioBooking.read();
        } catch (IOException e) {
            System.out.println("Error");
        } catch (ParseException e) {
            System.out.println("Error");
        }
        for (Booking booking : bookings) {
            if (id == booking.getFlight().getId()) {
                return booking;
            }
        }
        if (bookings.equals(null)) {
            System.out.println("No bookings!");
        }
        throw new IllegalArgumentException("No bookings!");
    }

    public List<Booking> getAll() {
        bookings = null;
        try {
            return bookings = ioBooking.read();
        } catch (IOException e) {
            System.out.println("Error");
        } catch (ParseException e) {
            System.out.println("Error");
        }
        if (bookings.equals(null)) {
            System.out.println("No bookings!");
        }
        throw new IllegalArgumentException("No bookings!");
    }

    public void put(Booking booking) {
        getAll().add(booking);
    }

    public void delete(int id) {
        List<Booking> all = getAll();
        for (Booking booking : all) {
            if (id == booking.getFlight().getId()) {
                all.remove(booking);
            }
        }
    }
}
