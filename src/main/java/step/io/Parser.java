package src.main.java.io;

public class Parser {
  public Command parse(String origin) {
    switch (origin.toLowerCase()){
      case "1":
        return Command.TIMETABLE_SHOW;
      case "2":
        return Command.TIMETABLE_LINE_SHOW;
      case "3":
        return Command.FLIGHT_SEARCH;
      case "4":
        return Command.BOOKING_REMOVE;
      case "5":
        return Command.MY_BOOKINGS_SHOW;
      case "6":
        return Command.EXIT;
      default:
        return Command.WRONG;
    }
  }
}