import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    private BufferedReader _bReader;
    private String _line;

    public int readData () throws IOException {
        _line ="";
        try{
            _bReader = new BufferedReader(new FileReader("readFile.txt"));
            _line = _bReader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return Integer.parseInt(_line);
    }
}
