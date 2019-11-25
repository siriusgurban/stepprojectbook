package src.main.java.dao;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface DAO<T> {
  T get(int id) throws IOException;
  List<T> getAll() throws IOException, ParseException;
  void put(T t) throws IOException;
  void delete(int id) throws IOException;
}
