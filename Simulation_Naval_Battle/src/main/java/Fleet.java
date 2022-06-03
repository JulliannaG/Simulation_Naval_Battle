import java.util.ArrayList;
import java.util.Random;
public class Fleet {
    ArrayList<Ship> Ships;
    private Random _r;
    private String _fleetName;
    private int _initialPoints;
    public String getFleetName()
    {
        return _fleetName;
    }

    //konstruktor
    public Fleet(String FleetName) {
        _r = new Random();
        _fleetName = FleetName;

        //lista statków floty
        Ships= new ArrayList<Ship>();
        Ships.add(new SmallShip(1, 1, 1));
        Ships.add(new MediumShip(2, 2, 2));
        Ships.add(new BigShip(3, 3, 3));
        Ships.add(new FireShip(4, 2, 4));
        Ships.add(new SmallShip(1, 1, 1));
        Ships.add(new MediumShip(2, 2, 2));
        Ships.add(new BigShip(3, 3, 3));
        Ships.add(new FireShip(4, 2, 4));

        //początkowa wartość floty
        _initialPoints = countFleetPoints();
    }

    //ilość aktywnych statków we flocie
    public int countShips()
{
    return Ships.size();
}

    //bieżąca wartość floty
    public int countFleetPoints(){
        int Score = 0;
        for(int n = 0; n<Ships.size(); n++)
            Score += Ships.get(n).getPoints();
        return Score;
    }

    //punkty przeciwnika
    public int opponentProfit(){
        return _initialPoints - countFleetPoints();
    }

    //nowa pozycja wybranego statku we flocie
    public void setShipPosition(int ShipNo, int X, int Y)
    {
    Ships.get(ShipNo).setPosition(X,Y);
    }

    //nowy kierunek wybranego statku we flocie
    public void setShipDirection(int ShipNumber, int Direction)
    {
        Ships.get(ShipNumber).setDirection(Direction);
    }

    //sprawdź czy na zadanej pozycji znajduje się wybrany statek
    public boolean checkShipPosition(int ShipNumber, int X, int Y)
{
    return Ships.get(ShipNumber).checkPosition(X,Y);
}

    //wybierz losowo jeden z aktywnych statków floty
    public int chooseShip(){
        int ShipNumber = _r.nextInt(Ships.size());
        return ShipNumber;
    }

    //obróć losowo wybrany statek
    public void rotateShip(int ShipNumber){
    Ships.get(ShipNumber).rotate();
    }


    //wyliczenie nowej pozycji wybranego statku
    public Position simulateMove(int ShipNumber){
    return Ships.get(ShipNumber).simulateMove();
    }

    //siła rażenia wybranego statku
    public int shipPower(int ShipNumber){
      return Ships.get(ShipNumber).getPower();
    }

    //ostrzelaj wybrany statek zadaną siłą rażenia
    public void fireAtShip(int ShipNumber, int FirePower){
        Ships.get(ShipNumber).fireAtShip(FirePower);
        if (!Ships.get(ShipNumber).isStillAlive())
            Ships.remove(ShipNumber);
    }

    //pozycja wybranego statku
    public Position shipPosition(int ShipNumber){
        return Ships.get(ShipNumber).getPosition();
    }

    //kierunek wybranego statku
    public int shipDirection(int ShipNumber){
        return Ships.get(ShipNumber).getDirection();
    }

    //życie wybranego statku
    public int shipLife(int ShipNumber){
        return Ships.get(ShipNumber).getLife();
    }

    //typ wybranego statku
    public String shipType(int ShipNumber){
        return Ships.get(ShipNumber).getType();
    }

    //sprawdzenie czy ArrayList jest pusta
    public boolean noShips(){
        boolean condition=false;
        if(Ships.isEmpty())
            condition=true;
        return condition;
    }

}
