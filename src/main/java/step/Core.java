package step;

import src.main.java.controller.BookingController;
import src.main.java.controller.MainController;
import src.main.java.controller.TimetableController;
import src.main.java.io.Command;
import src.main.java.io.Parser;

import java.io.IOException;

public class Core {
  private final Console console;
  private final Database database;
  private final Menu menu;
  private final Parser parser;
  private final BookingController bookingController;
  private final TimetableController timetableController;
  private final MainController mainController;

  public Core(Console console, Database database){
    this.console = console;
    this.database = database;
    this.menu = new Menu();
    this.parser = new Parser();
    this.bookingController = new BookingController();
    this.timetableController = new TimetableController();
    this.mainController = new MainController();
  }

  public void run() throws IOException {
    bookingController.load();
    timetableController.load();
    if (!database.isExisted()) {
      database.createInitialData();
    }
    boolean cont = true;
    console.printLn(menu.show());
    while (cont) {
      String line = console.readLn();
      Command user_input = parser.parse(line);
      switch (user_input) {
        case TIMETABLE_SHOW:
          timetableController.show();
          break;
        case TIMETABLE_LINE_SHOW:
          timetableController.showLine();
          break;
        case FLIGHT_SEARCH:
          timetableController.search();
          break;
        case BOOKING_REMOVE:
          bookingController.remove();
          break;
        case MY_BOOKINGS_SHOW:
          bookingController.show();
          break;
        case EXIT:
          cont=false;
          break;
        default:
          console.printLn("Wrong");
          break;
      }
    }
  }
}

