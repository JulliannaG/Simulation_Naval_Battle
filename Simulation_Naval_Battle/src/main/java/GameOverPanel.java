import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameOverPanel extends JPanel {
    private BufferedImage _image;

    public GameOverPanel(Radar radar) {
        super();
        int Fleet1Score = radar.fleetScore("Spain"); //czerwoni
        int Fleet2Score = radar.fleetScore("Pirates"); //czarni

        //wstawienie grafiki z napisem końcowym
        //sprawdzenie kto wygrał
        if(Fleet1Score>Fleet2Score) {
            File imageFile = new File("./src/main/resources/ships/The_Battle_is_over_Spain.png");
            try {
                _image = ImageIO.read(imageFile);
            } catch (IOException e) {
                System.err.println("Blad odczytu obrazka");
                e.printStackTrace();
            }

            Dimension dimension = new Dimension(_image.getWidth(), _image.getHeight());
            setPreferredSize(dimension);
        }
        else
        if(Fleet1Score<Fleet2Score) {
            File imageFile = new File("./src/main/resources/ships/The_Battle_is_over_Pirate.png");
            try {
                _image = ImageIO.read(imageFile);
            } catch (IOException e) {
                System.err.println("Blad odczytu obrazka");
                e.printStackTrace();
            }

            Dimension dimension = new Dimension(_image.getWidth(), _image.getHeight());
            setPreferredSize(dimension);
        }
        else
        if(Fleet1Score==Fleet2Score)
        {
            File imageFile = new File("./src/main/resources/ships/The_Battle_is_over.png");
            try {
                _image = ImageIO.read(imageFile);
            } catch (IOException e) {
                System.err.println("Blad odczytu obrazka");
                e.printStackTrace();
            }

            Dimension dimension = new Dimension(_image.getWidth(), _image.getHeight());
            setPreferredSize(dimension);
        }
    }

    //wyświetlenie grafiki
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(_image, 0, 0, this);
    }
}