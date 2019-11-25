package src.main.java.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {
    private final int id;
    private final City source;
    private final City destination;
    private int seats;
    private int emptySeats;
    private LocalDateTime date;

    public Flight(int id, City source, City destination, int seats, int emptySeats, LocalDateTime date) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.seats = seats;
        this.emptySeats = emptySeats;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public City getSource() {
        return source;
    }

    public City getDestination() {
        return destination;
    }

    public int getSeats() {
        return seats;
    }

    public int getEmptySeats() {
        return emptySeats;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setEmptySeats(int emptySeats) {
        this.emptySeats = emptySeats;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return getId() == flight.getId() &&
                Objects.equals(getSource(), flight.getSource()) &&
                Objects.equals(getDestination(), flight.getDestination()) &&
                Objects.equals(getSeats(), flight.getSeats()) &&
                Objects.equals(getEmptySeats(), flight.getEmptySeats()) &&
                Objects.equals(getDate(), flight.getDate());
    }

    @Override
    public int hashCode() {
        int r = getId();
        r = r * 31 + source.hashCode();
        r = r * 31 + destination.hashCode();
        r = r * 31 + date.hashCode();
        return r;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", source=" + source +
                ", destination=" + destination +
                ", seats=" + seats +
                ", emptySeats=" + emptySeats +
                ", date=" + date +
                '}';
    }
}
