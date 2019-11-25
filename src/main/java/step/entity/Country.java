package src.main.java.entity;

public class Country {
    private final int id;
    private final String name;

    public Country(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return getId() == country.getId() &&
                getName().equals(country.getName());
    }

    @Override
    public int hashCode() {
        int r = id;
        r = r * 31 + name.hashCode();
        return r;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
