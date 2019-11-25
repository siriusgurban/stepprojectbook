package src.main.java.controller;

import step.SystemConsole;
import src.main.java.entity.Flight;
import src.main.java.service.TimetableService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class TimetableController {
  private final TimetableService timetableService;
  private final SystemConsole systemConsole;
  private final BookingController bookingController;

  public TimetableController() {
    this.timetableService = new TimetableService();
    this.systemConsole = new SystemConsole();
    this.bookingController = new BookingController();
  }

  public void search() {
    systemConsole.printLn("Please enter source city name,  destination city name, date and number of tickets to buy");
    systemConsole.printLn("Example Baku Roma 2019.11.22 2");
    String fromCityName = systemConsole.readLn();
    String toCityName = systemConsole.readLn();
    String date = systemConsole.readLn();
    String nTickets = systemConsole.readLn();
    HashMap<Integer,Flight> chosen= timetableService.search(fromCityName, toCityName, date, nTickets);
    bookingController.add(chosen);
  }

  public void show() {
    LocalDateTime fromDateTime = LocalDateTime.now();
    LocalDateTime toDateTime = LocalDateTime.now().plusHours(24);
    timetableService.show(fromDateTime, toDateTime);
  }

  public void showLine() {
    systemConsole.printLn("Please enter flight id");
    String line;
    int id = -1;
    while (true) {
      try {
        line = systemConsole.readLn();
        id = Integer.parseInt(line);
        break;
      } catch (Exception e) {
        System.out.println("Please, enter an integer : ");
      }
    }
    timetableService.showLine(id);
  }

  public void load() throws IOException {
    timetableService.load();

  }
}
