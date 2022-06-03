import java.util.Random;
public abstract class Ship {
    //najlepiej wszystkie prywatne zmienne nazywać z _ przed nazwą żeby odróżnic je od tych publicznych

    private  int _Life;
    private  final int _Power;
    private  final int _Points;
    protected  int _x = -1; //klasa pochodna używa tej zmiennej w funkcji simulateMove
    protected  int _y = -1; //klasa pochodna używa tej zmiennej w funkcji simulateMove
    protected String _shipType; //klasa pochodna używa tej zmiennej w funkcji simulateMove
    protected Random _r; //klasa pochodna używa tej zmiennej w funkcji simulateMove
    protected int _direction; //0-north; 1-west, 2-south; 3-east


    //konstruktor
    public Ship(int Life, int Power, int Point) {
        this._Life = Life; this._Power = Power; this._Points = Point;
        _r = new Random();
        _shipType = "Unknown";
    }


    //ustawienie nowej pozycji
    public void setPosition(int x, int y){
        _x=x;
        _y=y;
    }

    //ustawienie nowego kierunku
    public void setDirection(int Direction){
        _direction=Direction;
    }

    //czy statek jest niezatopiony
    public boolean isStillAlive()
    {
        boolean Alive=true;
        if(_Life==0)
            Alive=false;
        return Alive;
    }

    //sprawdzenie czy statek jest na podanej pozycji
    public boolean checkPosition(int X, int Y)
    {
        if( X == _x & Y == _y)
            return true;
        else
            return false;
    }

    //trafienie statku
    public void fireAtShip(int FirePower)
    {
        _Life -= FirePower;
        if(_Life < 0)
            _Life = 0;
    }

    //obrót statku
    public void rotate() {
        int change;
        //_direction = _r.nextInt(4);
        change = _r.nextInt(2);
        if(change == 0 ) change = -1;
        _direction += change;

        //kontrola zakresu obrotu
        if(_direction < 0) _direction = 3;
        if(_direction > 3) _direction = 0;
    }

    //wyliczenie nowej pozycji
    abstract Position simulateMove();

    //siła rażenia statku
    public int getPower() {
        return _Power;
    }

    //wartość statku
    public int getPoints() {
        return _Points;
    }

    //życie statku
    public int getLife() {
        return _Life;
    }

    //kierunek statku
    public int getDirection() {
        return _direction;
    }

    //pozycja statku
    public Position getPosition() {
        return new Position(_x, _y);
    }

    //Typ statku
    public String getType() {
        return _shipType;
    }

    //kontrola zakresu ruchu (czy statek nie wychodzi poza planszy)
    protected Position checkBoundaries(Position position){
        if(position.x < 0)
            position.x = 0;
        if(position.x > 9)
            position.x = 9;
        if(position.y < 0)
            position.y = 0;
        if(position.y > 9)
            position.y = 9;
        return position;
    }
}
