import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawFireShip {
    private BufferedImage _image;
    private BufferedImage [][] _t;
    private File _file;
    public void draw(Graphics g, Radar radar){

        for (int n = 0; n < radar.Fleet1.countShips(); n++)
            if(radar.Fleet1.shipType(n) == "FireShip") {
                int position_X = radar.Fleet1.shipPosition(n).x;
                int position_Y = radar.Fleet1.shipPosition(n).y;
                int direction = radar.Fleet1.shipDirection(n);
                int life = radar.Fleet1.shipLife(n);

                //wstawienie grafiki
                _file = new File("./src/main/resources/ships/Spain_FireShip.png");
                try {
                    _image = ImageIO.read(_file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                _t = new BufferedImage[10][10];
                for(int y=0;y<10;y++){
                    for(int x=0;x<10;x++){
                        if(y==position_Y && x==position_X){
                            _t[y][x]= _image;
                            g.drawImage(_image,x*70,y*60,null);
                        }
                    }
                }


                //wstawienie wizualizacji kierunku ruchu oraz paska życia
                if(direction==0){
                    g.setColor(new Color(0x5E1D98));
                    g.fillOval(position_X * Board.Size_x + 30, position_Y * Board.Size_y , 10, 10);
                    if(life==4){
                        g.setColor(new Color(0x4DC539));
                        g.fillRect(position_X * Board.Size_x  , position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 5, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 15, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x +25 , position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 35, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 45, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 55, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 61, position_Y * Board.Size_y +50, 10, 10);
                    }
                    if(life==3) {
                        g.setColor(new Color(0xE8F105));
                        g.fillRect(position_X * Board.Size_x +25 , position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 35, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 45, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 55, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 61, position_Y * Board.Size_y +50, 10, 10);
                    }
                    if(life==2){
                        g.setColor(new Color(0xEF6D25));
                        g.fillRect(position_X * Board.Size_x + 45, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 55, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 61, position_Y * Board.Size_y +50, 10, 10);
                    }
                    if(life==1) {
                        g.setColor(new Color(0xF800E3));
                        g.fillRect(position_X * Board.Size_x + 61, position_Y * Board.Size_y +50, 10, 10);
                    }

                }
                if(direction==1){
                    g.setColor(new Color(0x5E1D98));
                    g.fillOval(position_X * Board.Size_x +59, position_Y * Board.Size_y+25, 10, 10);
                    if(life==4){
                        g.setColor(new Color(0x4DC539));
                        g.fillRect(position_X * Board.Size_x  , position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +5, 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +15, 10, 10);
                        g.fillRect(position_X * Board.Size_x  , position_Y * Board.Size_y +25, 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +35, 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +45, 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +50, 10, 10);
                    }
                    if(life==3) {
                        g.setColor(new Color(0xE8F105));
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +15, 10, 10);
                        g.fillRect(position_X * Board.Size_x  , position_Y * Board.Size_y +25, 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +35, 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +45, 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +50, 10, 10);
                    }
                    if(life==2){
                        g.setColor(new Color(0xEF6D25));
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +35, 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +45, 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +50, 10, 10);
                    }
                    if(life==1) {
                        g.setColor(new Color(0xF800E3));
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +50, 10, 10);
                    }
                }
                if(direction==2){
                    g.setColor(new Color(0x5E1D98));
                    g.fillOval(position_X * Board.Size_x +34, position_Y * Board.Size_y+50, 10, 10);
                    if(life==4){
                        g.setColor(new Color(0x4DC539));
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 5, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 15, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x +25 , position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 35, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 45, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 55, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 60, position_Y * Board.Size_y , 10, 10);
                    }
                    if(life==3) {
                        g.setColor(new Color(0xE8F105));
                        g.fillRect(position_X * Board.Size_x +25 , position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 35, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 45, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 55, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 60, position_Y * Board.Size_y , 10, 10);
                    }
                    if(life==2){
                        g.setColor(new Color(0xEF6D25));
                        g.fillRect(position_X * Board.Size_x + 45, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 55, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 60, position_Y * Board.Size_y , 10, 10);
                    }
                    if(life==1) {
                        g.setColor(new Color(0xF800E3));
                        g.fillRect(position_X * Board.Size_x + 60, position_Y * Board.Size_y , 10, 10);
                    }
                }
                if(direction==3){
                    g.setColor(new Color(0x5E1D98));
                    g.fillOval(position_X * Board.Size_x +1, position_Y * Board.Size_y+25, 10, 10);
                    if(life==4){
                        g.setColor(new Color(0x4DC539));
                        g.fillRect(position_X * Board.Size_x +60 , position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +5, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +15, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60 , position_Y * Board.Size_y +25, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +35, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +45, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +50, 10, 10);
                    }
                    if(life==3){
                        g.setColor(new Color(0xE8F105));
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +15, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60 , position_Y * Board.Size_y +25, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +35, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +45, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +50, 10, 10);
                    }
                    if(life==2){
                        g.setColor(new Color(0xEF6D25));
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +35, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +45, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +50, 10, 10);
                    }
                    if(life==1) {
                        g.setColor(new Color(0xF800E3));
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +50, 10, 10);
                    }
                }
            }


        for (int n = 0; n < radar.Fleet2.countShips(); n++)
            if(radar.Fleet2.shipType(n) == "FireShip") {
                int position_X = radar.Fleet2.shipPosition(n).x;
                int position_Y = radar.Fleet2.shipPosition(n).y;
                int direction = radar.Fleet2.shipDirection(n);
                int life = radar.Fleet2.shipLife(n);

                //wstawienie grafiki
                _file = new File("./src/main/resources/ships/Pirate_FireShip.png");
                try {
                    _image = ImageIO.read(_file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                _t = new BufferedImage[10][10];
                for(int y=0;y<10;y++){
                    for(int x=0;x<10;x++){
                        if(y==position_Y && x==position_X){
                            _t[y][x]= _image;
                            g.drawImage(_image,x*70,y*60,null);
                        }
                    }
                }

                //wstawienie wizualizacji kierunku ruchu oraz paska życia
                if(direction==0){
                    g.setColor(new Color(0x11B287));
                    g.fillOval(position_X * Board.Size_x + 30, position_Y * Board.Size_y , 10, 10);
                    if(life==4){
                        g.setColor(new Color(0x4DC539));
                        g.fillRect(position_X * Board.Size_x  , position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 5, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 15, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x +25 , position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 35, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 45, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 55, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 61, position_Y * Board.Size_y +50, 10, 10);
                    }
                    if(life==3) {
                        g.setColor(new Color(0xE8F105));
                        g.fillRect(position_X * Board.Size_x +25 , position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 35, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 45, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 55, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 61, position_Y * Board.Size_y +50, 10, 10);
                    }
                    if(life==2){
                        g.setColor(new Color(0xEF6D25));
                        g.fillRect(position_X * Board.Size_x + 45, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 55, position_Y * Board.Size_y +50, 10, 10);
                        g.fillRect(position_X * Board.Size_x + 61, position_Y * Board.Size_y +50, 10, 10);
                    }
                    if(life==1) {
                        g.setColor(new Color(0xF800E3));
                        g.fillRect(position_X * Board.Size_x + 61, position_Y * Board.Size_y +50, 10, 10);
                    }

                }
                if(direction==1){
                    g.setColor(new Color(0x11B287));
                    g.fillOval(position_X * Board.Size_x +59, position_Y * Board.Size_y+25, 10, 10);
                    if(life==4){
                        g.setColor(new Color(0x4DC539));
                        g.fillRect(position_X * Board.Size_x  , position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +5, 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +15, 10, 10);
                        g.fillRect(position_X * Board.Size_x  , position_Y * Board.Size_y +25, 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +35, 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +45, 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +50, 10, 10);
                    }
                    if(life==3) {
                        g.setColor(new Color(0xE8F105));
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +15, 10, 10);
                        g.fillRect(position_X * Board.Size_x  , position_Y * Board.Size_y +25, 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +35, 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +45, 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +50, 10, 10);
                    }
                    if(life==2){
                        g.setColor(new Color(0xEF6D25));
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +35, 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +45, 10, 10);
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +50, 10, 10);
                    }
                    if(life==1) {
                        g.setColor(new Color(0xF800E3));
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y +50, 10, 10);
                    }
                }
                if(direction==2){
                    g.setColor(new Color(0x11B287));
                    g.fillOval(position_X * Board.Size_x +34, position_Y * Board.Size_y+50, 10, 10);
                    if(life==4){
                        g.setColor(new Color(0x4DC539));
                        g.fillRect(position_X * Board.Size_x , position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 5, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 15, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x +25 , position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 35, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 45, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 55, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 60, position_Y * Board.Size_y , 10, 10);
                    }
                    if(life==3) {
                        g.setColor(new Color(0xE8F105));
                        g.fillRect(position_X * Board.Size_x +25 , position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 35, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 45, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 55, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 60, position_Y * Board.Size_y , 10, 10);
                    }
                    if(life==2){
                        g.setColor(new Color(0xEF6D25));
                        g.fillRect(position_X * Board.Size_x + 45, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 55, position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x + 60, position_Y * Board.Size_y , 10, 10);
                    }
                    if(life==1) {
                        g.setColor(new Color(0xF800E3));
                        g.fillRect(position_X * Board.Size_x + 60, position_Y * Board.Size_y , 10, 10);
                    }
                }
                if(direction==3){
                    g.setColor(new Color(0x11B287));
                    g.fillOval(position_X * Board.Size_x +1, position_Y * Board.Size_y+25, 10, 10);
                    if(life==4){
                        g.setColor(new Color(0x4DC539));
                        g.fillRect(position_X * Board.Size_x +60 , position_Y * Board.Size_y , 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +5, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +15, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60 , position_Y * Board.Size_y +25, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +35, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +45, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +50, 10, 10);
                    }
                    if(life==3){
                        g.setColor(new Color(0xE8F105));
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +15, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60 , position_Y * Board.Size_y +25, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +35, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +45, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +50, 10, 10);
                    }
                    if(life==2){
                        g.setColor(new Color(0xEF6D25));
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +35, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +45, 10, 10);
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +50, 10, 10);
                    }
                    if(life==1) {
                        g.setColor(new Color(0xF800E3));
                        g.fillRect(position_X * Board.Size_x +60, position_Y * Board.Size_y +50, 10, 10);
                    }
                }

            }
    }
}
