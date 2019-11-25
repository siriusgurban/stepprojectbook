package src.main.java.controller;

import step.SystemConsole;
import src.main.java.entity.Flight;
import src.main.java.service.BookingService;

import java.io.IOException;
import java.util.HashMap;

public class BookingController {
  private final BookingService bookingService;
  private final SystemConsole systemConsole;


  public BookingController() {
    this.bookingService = new BookingService();
    this.systemConsole = new SystemConsole();
  }

  public void remove() {
    systemConsole.printLn("Write an id of your booking to cancel:");
    String line;
    int id = -1;
    while (true) {
      try {
        line = systemConsole.readLn();
        id = Integer.parseInt(line);
        break;
      } catch (Exception e) {
        systemConsole.printLn("Please, enter an valid id : ");
      }
    }
    bookingService.delete(id);
  }

  public void show() {
    systemConsole.printLn("Enter your name and surname with enter");
    String name = systemConsole.readLn();
    String surname  = systemConsole.readLn();
    bookingService.show(name, surname);
  }

  public void add(HashMap<Integer, Flight> chosen) {
    bookingService.add(chosen);
  }

  public void load() throws IOException {
    bookingService.load();
  }
}
