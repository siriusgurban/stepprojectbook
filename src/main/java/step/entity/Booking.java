package step.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Booking {
    private final Flight flight;
    private final Passenger buyer;
    private List<Passenger> passengers;
    private LocalDateTime date;

    public Booking(Flight flight, List<Passenger> passengers, LocalDateTime date, Passenger buyer) {
        this.flight = flight;
        this.passengers = passengers;
        this.date = date;
        this.buyer = buyer;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getBuyer() {
        return buyer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return getFlight().equals(booking.getFlight()) &&
                getBuyer().equals(booking.getBuyer()) &&
                getPassengers().equals(booking.getPassengers()) &&
                getDate().equals(booking.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlight(), getPassengers(), getDate());
    }

    @Override
    public String toString() {
        return "Booking{" +
                ", flight=" + flight +
                ", passengers=" + passengers +
                ", date=" + date +
                ", buyer=" + buyer +
                '}';
    }
}


