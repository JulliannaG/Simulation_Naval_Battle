import java.awt.*;
import java.io.IOException;
import javax.swing.*;


public class Run {

    //obiekt simulation
    static Simulation simulation;

    // obiekt reader
    static Reader reader = new Reader();


    public static void main(String[] args) throws IOException {
        int TotalTurnNumber;

        simulation = new Simulation("Spain", "Pirates");

        //pobranie ilości tur z pliku
        TotalTurnNumber = reader.readData();

        //uruchomienie symulacji
        simulation.run(TotalTurnNumber);



    }

}

