import java.awt.*;

public class Board {
    public static final int Field_x = 10;
    public static final int Field_y = 10;
    public static final int Size_x = 70;
    public static final int Size_y = 60;
    public static final int  Max_x=Field_x*Size_x;
    public static final int  Max_y=Field_y*Size_y;

    //rysowanie planszy
    public static void draw(Graphics g){
        g.setColor(new Color(0x2370C7));

        g.fillRect(0,0,Max_x, Max_y);
    }
}
