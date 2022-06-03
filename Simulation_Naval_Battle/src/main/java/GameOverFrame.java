import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameOverFrame extends JFrame {

    public GameOverFrame(Radar radar) {
        super("Program obrazkowy");

        JPanel GameOverPanel = new GameOverPanel(radar);
        add(GameOverPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}