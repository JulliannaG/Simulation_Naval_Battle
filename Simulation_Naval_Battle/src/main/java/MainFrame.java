import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    //etykiety do wyświetlania punktów i tur
    public static JLabel Score;
    public static JLabel Turn;

    //płotno do wyświetlenia przebiegu symulacji
    MainCanvas mainCanvas;

    private Radar _radar;

    public MainFrame(Radar radar) throws HeadlessException {
        setTitle("Bitwa morska");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        _radar = radar;

        String Fleet1Name = _radar.Fleet1.getFleetName();
        String Fleet2Name = _radar.Fleet2.getFleetName();

        Score= new JLabel(Fleet1Name + " score: " + "                           " + Fleet2Name + " score: ",SwingConstants.CENTER);
        Turn = new JLabel("current turn: "  , SwingConstants.CENTER);

        //dodanie etykiet i płótna
        mainCanvas = new MainCanvas(radar);
        add(mainCanvas);
        add(Score, BorderLayout.SOUTH);
        Score.setFont(new Font(Score.getFont().getName(), Font.BOLD, 20));
        add(Turn, BorderLayout.NORTH);
        Turn.setFont(new Font(Turn.getFont().getName(), Font.BOLD, 20));

        pack();
        setLocationRelativeTo(null);

    }
}

