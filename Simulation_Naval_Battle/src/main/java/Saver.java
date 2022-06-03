import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Saver {
    private Radar _radar;
    private BufferedWriter _bWriter;

    public Saver(Radar radar) {
        _radar=radar;
    }

    public void saveData(int Turn){

        String turn = Integer.toString(Turn+1);

        int Fleet1Score = _radar.fleetScore("Spain");
        int Fleet2Score = _radar.fleetScore("Pirates");
        String points1 = Integer.toString(Fleet1Score);
        String points2 = Integer.toString(Fleet2Score);

        try{
            _bWriter = new BufferedWriter(new FileWriter("saveFile.txt",true));
            _bWriter.write("Turn:" + turn);
            _bWriter.newLine();
            _bWriter.write("Spain points:" + points1);
            _bWriter.newLine();
            _bWriter.write("Pirates points:" + points2);
            _bWriter.newLine();
            _bWriter.newLine();

            _bWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}


