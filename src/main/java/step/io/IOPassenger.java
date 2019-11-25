package src.main.java.io;

import src.main.java.entity.Passenger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOPassenger {
    String path = "data/Passengers.txt";


    public List<Passenger> read() throws IOException {
        List<Passenger> passengers = new ArrayList<Passenger>();
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null) {
            passengers.add(definePassenger(line));
        }
        br.close();
        return passengers;
    }

    public void write(Passenger passenger) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        StringBuilder sb = new StringBuilder();
        sb.append( passenger.getName() + " : " + passenger.getSurname());
        bw.write(sb.toString());
        bw.newLine();
        bw.close();
    }

    public Passenger definePassenger(String line){
        String[] split = line.split(" : ");
        String name = split[0];
        String surname = split[1];
        return new Passenger( name, surname);
    }
}
