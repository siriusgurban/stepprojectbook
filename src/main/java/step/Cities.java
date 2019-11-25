package step;

import src.main.java.entity.City;
import src.main.java.io.IOCity;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Cities implements Iterable<City>{
  private final Countries countries = new Countries();
  City city1 = new City(1, "Riga",countries.country1);
  City city2 = new City(2, "Valletta",countries.country2);
  City city3 = new City(3, "Tokyo",countries.country3);
  City city4 = new City(4, "Helsinki",countries.country4);
  City city5 = new City(5, "Paris",countries.country5);
  City city6 = new City(6, "Sofia",countries.country6);
  City city7 = new City(7, "Roma",countries.country7);
  City city8 = new City(8, "Vienna",countries.country8);
  City city9 = new City(9, "Nicosia",countries.country9);
  City city10 = new City(10, "Budapest",countries.country10);
  City city11 = new City(11, "Tallinn",countries.country11);
  City city12 = new City(12, "Tirana",countries.country12);
  City city13 = new City(13, "Athens",countries.country13);
  City city14 = new City(14, "Beijing",countries.country14);
  City city15 = new City(15, "Brussels",countries.country15);
  City city16 = new City(16, "London",countries.country16);
  City city17 = new City(17, "Stockholm",countries.country17);
  City city18 = new City(18, "Berlin",countries.country18);
  City city19 = new City(19, "Washington",countries.country19);
  City city20 = new City(20, "Copenhagen",countries.country20);

  private final List<City> data = Arrays.asList(city1, city2, city3, city4, city5,
          city6, city7, city8, city9, city10,
          city11, city12, city13, city14, city15,
          city16, city17, city18, city19, city20
  );

  @Override
  public Iterator<City> iterator() {
    return data.iterator();
  }

  public void create(){
    IOCity ioCity = new IOCity();
    data.forEach(city -> {
      try {
        ioCity.write(city);
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }



}

