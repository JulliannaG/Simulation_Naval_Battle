import java.io.IOException;

public class Simulation {
    Radar _radar;
    MainFrame mainFrame;
    Saver saver;
    GameOverFrame gameOverFRame;

    public Simulation(String Fleet1Name, String Fleet2Name) throws IOException {
        //utworzenie radaru
        _radar = new Radar(Fleet1Name, Fleet2Name);

        //utworzenie savera
        saver = new Saver(_radar);

        //utworzenie ramki
        mainFrame = new MainFrame(_radar);
        mainFrame.setVisible(true);
    }

    //funkcja pauzy
    private void pause(int Seconds)
    {
        try {
            Thread.sleep(Seconds);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //start symulacji
    public void run(int TotalTurnNumber) throws IOException {

        boolean EndGame;

        //początkowe narysowanie planszy
        mainFrame.mainCanvas.repaint();

        //pauza 1 sek
        pause(1000);

        //Tury graczy
        for(int n = 0; n < TotalTurnNumber; n++)
        {
            //zapamiętanie numeru tury w radarze
            _radar.setTurnCounter(n+1);

            //TURA FLOTY 1
            //akcja floty 1
            _radar.fleetAction("Spain");

            //narysowanie planszy
            mainFrame.mainCanvas.repaint();

            //pauza
            pause(1000);

            //pobranie danych
            saver.saveData(n);

            //zapamiętanie numeru tury w radarze
            _radar.setTurnCounter(n+2);

            //sprawdzenie warunku końca gry
            EndGame = _radar.NoShipsInFleet();
            if(EndGame==true)
                break;

            //TURA FLOTY 2
            //akcja floty 2
            _radar.fleetAction("Pirates");

            //narysowanie planszy
            mainFrame.mainCanvas.repaint();

            //pauza
            pause(1000);

            //zapamiętanie numeru tury w radarze
            _radar.setTurnCounter(n++);

            //sprawdzenie warunku końca g
            EndGame = _radar.NoShipsInFleet();

            //pobranie danych
            saver.saveData(n);

            //sprawdzenie warunku końca gry
            if(EndGame==true)
                break;

            //w przypadku podania nieparzystej liczby tur tura zwiększa się o 1 aby każda flota zrobiła tyle samo ruchów
        }

        //wyświetlenie końcowej grafiki
        gameOverFRame = new GameOverFrame(_radar);

    }

}
