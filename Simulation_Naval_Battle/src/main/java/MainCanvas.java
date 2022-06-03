import java.awt.*;
import java.io.IOException;
public class MainCanvas extends Canvas {

    private DrawSmallShip _drawSmallShip = new DrawSmallShip();
    private DrawMediumShip _drawMediumShip = new DrawMediumShip();
    private DrawBigShip _drawBigShip = new DrawBigShip();
    private DrawFireShip _drawFireShip = new DrawFireShip();
    private Radar _radar;

    public MainCanvas(Radar radar) {
        setSize(new Dimension(Board.Max_x,Board.Max_y));
        _radar = radar;
    }

    @Override
    public void paint(Graphics g) {

        int Fleet1Score = _radar.fleetScore("Spain"); //czerwoni
        int Fleet2Score = _radar.fleetScore("Pirates"); //czarni
        int CurrentTurn = _radar.getTurnCounter(); //numer tury

        String Fleet1Name = _radar.Fleet1.getFleetName();
        String Fleet2Name = _radar.Fleet2.getFleetName();

        //ustawienie tekstu w etykietach
        MainFrame.Turn.setText("Current turn: " + CurrentTurn);
        MainFrame.Score.setText(Fleet1Name + " score: " + Fleet1Score + "                           " + Fleet2Name + " score: " + Fleet2Score);

        //narysowanie planszy
        Board.draw(g);
        g.setColor(Color.BLACK);
        for (int i=0;i<10;i++) {
            for (int j = 0; j < 10; j++) {
                g.drawLine(i*Board.Size_x, j*Board.Size_y,  (i+1)*Board.Size_x,  j*Board.Size_y);
                g.drawLine(i*Board.Size_x, j*Board.Size_y,  i*Board.Size_x,  (j+1)*Board.Size_y);
            }
        }

        //narysowanie wszystkich statków
        _drawSmallShip.draw(g, _radar);
        _drawMediumShip.draw(g, _radar);
        try {
            _drawBigShip.draw(g, _radar);
        } catch (IOException e) {
            e.printStackTrace();
        }
        _drawFireShip.draw(g, _radar);
    }
}






