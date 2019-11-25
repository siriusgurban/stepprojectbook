package src.main.java.entity;

public class Passenger {
    private final String name;
    private final String surname;

    public Passenger(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return getName().equals(passenger.getName()) &&
                getSurname().equals(passenger.getSurname());
    }

    @Override
    public int hashCode() {
        int r = getName().hashCode();
        r = r * 31 + getSurname().hashCode();
        return r;
    }


    @Override
    public String toString() {
        return "Passenger{" +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

}
