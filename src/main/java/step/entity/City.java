package src.main.java.entity;

public class City {
  private final int id;
  private final String name;
  private final Country country;

  public City(int id, String name, Country country) {
    this.id = id;
    this.name = name;
    this.country = country;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Country getCountry() {
    return country;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof City)) return false;
    City city = (City) o;
    return getId() == city.getId() &&
            getName().equals(city.getName()) &&
            getCountry().equals(city.getCountry());
  }

  @Override
  public int hashCode() {
    int r = getId();
    r = r * 31 + getCountry().hashCode();
    r = r * 31 + getName().hashCode();
    return r;
  }

  @Override
  public String toString() {
    return "City{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", Country=" + country +
            '}';
  }
}

