package step;

import java.io.File;

public class Database {
  public boolean isExisted(){
    File a  = new File("data/cities.txt");
    File b  = new File("data/countries.txt");
    File c  = new File("data/flights.txt");
    return a.exists() && b.exists() && c.exists();
  }

  public void createInitialData(){
    Cities cities = new Cities();
    Countries countries = new Countries();
    Flights flights = new Flights();
    if (!isExisted()){
      cities.create();
      countries.create();
      flights.create();
    }
  }
}
