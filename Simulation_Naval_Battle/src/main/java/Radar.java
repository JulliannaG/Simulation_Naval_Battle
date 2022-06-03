import java.util.Random;
public class Radar {

    Random _r;
    Fleet Fleet1;
    Fleet Fleet2;

    private int _CurrentTurn;

    public Radar(String Fleet1Name, String Fleet2Name)
    {
        _r = new Random();

        Fleet1=new Fleet(Fleet1Name);

        //ustawienie pozycj statków floty1
        Fleet1.setShipPosition(0,2,1);
        Fleet1.setShipPosition(1,4,1);
        Fleet1.setShipPosition(2,6,1);
        Fleet1.setShipPosition(3,3,2);
        Fleet1.setShipPosition(4,8,1);
        Fleet1.setShipPosition(5,1,2);
        Fleet1.setShipPosition(6,7,2);
        Fleet1.setShipPosition(7,5,2);

        //ustawienie kierunków statków floty1
        Fleet1.setShipDirection(0, 2);
        Fleet1.setShipDirection(1, 2);
        Fleet1.setShipDirection(2, 2);
        Fleet1.setShipDirection(3, 2);
        Fleet1.setShipDirection(4,2);
        Fleet1.setShipDirection(5, 2);
        Fleet1.setShipDirection(6, 2);
        Fleet1.setShipDirection(7, 2);

        Fleet2=new Fleet(Fleet2Name);

        //ustawienie pozycji statków floty2
        Fleet2.setShipPosition(0,2,8);
        Fleet2.setShipPosition(1,4,8);
        Fleet2.setShipPosition(2,6,8);
        Fleet2.setShipPosition(3,3,7);
        Fleet2.setShipPosition(4,8,8);
        Fleet2.setShipPosition(5,1,7);
        Fleet2.setShipPosition(6,7,7);
        Fleet2.setShipPosition(7,5,7);

        //ustawienie pozycji statków floty2
        Fleet2.setShipDirection(0, 0);
        Fleet2.setShipDirection(1, 0);
        Fleet2.setShipDirection(2, 0);
        Fleet2.setShipDirection(3, 0);
        Fleet2.setShipDirection(4, 0);
        Fleet2.setShipDirection(5, 0);
        Fleet2.setShipDirection(6, 0);
        Fleet2.setShipDirection(7, 0);
    }

    //ustawienie licznika tur
    public void setTurnCounter(int CurrentTurn){
        _CurrentTurn = CurrentTurn;
    }

    //Odczytanie licznika tur
    public int getTurnCounter(){
        return _CurrentTurn;
    }

    //zwraca nazwę floty, któa zajmuje pozycję x,y
    public String checkPosition(int X, int Y)
    {
        String fleetName = "";

        for (int n = 0; n < Fleet1.countShips(); n++)
            if(Fleet1.checkShipPosition(n, X, Y) == true)
                fleetName = Fleet1.getFleetName();

        for (int n = 0; n < Fleet2.countShips(); n++)
            if(Fleet2.checkShipPosition(n, X, Y) == true)
                fleetName = Fleet2.getFleetName();

        return fleetName;
    }

    //jeśli statek jest z przeciwnej floty to strzel w niego
    public void fireAtPosition(int X, int Y, int FirePower)
    {
        for (int n = 0; n < Fleet1.countShips(); n++)
            if(Fleet1.checkShipPosition(n, X, Y) == true)
                Fleet1.fireAtShip(n, FirePower);

        for (int n = 0; n < Fleet2.countShips(); n++)
            if(Fleet2.checkShipPosition(n, X, Y) == true)
                Fleet2.fireAtShip(n, FirePower);
    }

    //punkty zdobyte przez flotę o podanej nazwie
    public int fleetScore(String FleetName){
        Fleet fleet;
        Fleet opponentFleet;

        //identyfikacja floty po nazwie
        if (Fleet1.getFleetName() == FleetName) {
            fleet = Fleet1;
            opponentFleet = Fleet2;
        }
        else {
            fleet = Fleet2;
            opponentFleet = Fleet1;
        }

        return opponentFleet.opponentProfit();
    }

    //akcja floty
    public void fleetAction(String FleetName){
        Fleet fleet;
        int ShipNumber;
        Position _p;
        String FleetNameAtPosition;
        int AttackerPower;
        int Ruch; //0 - rotacja; 1-7 - ruch

        //identyfikacja floty po nazwie
        if (Fleet1.getFleetName() == FleetName) {
            fleet = Fleet1;
        }
        else {
            fleet = Fleet2;
        }

        //identyfikacja statku we flocie do wykonania akcji
        ShipNumber = fleet.chooseShip();
        AttackerPower = fleet.shipPower(ShipNumber);

        //wybór czy rotacja czy ruch
        Ruch = _r.nextInt(8);

        //jeśli rotacja
        if(Ruch == 0)
            fleet.rotateShip(ShipNumber);

        else
        {
            //zasymuluj ruch
            _p = fleet.simulateMove(ShipNumber);

            //sprawdź jaka flota jest na zasymulowanej pozycji
            FleetNameAtPosition = checkPosition(_p.x, _p.y);

            //jeżeli nic tam nie ma - rusz się tam
            if (FleetNameAtPosition == "")
                fleet.setShipPosition(ShipNumber, _p.x, _p.y);

            else

                //jeżeli jest tam statek twojej floty to nic nie rób
                if(FleetNameAtPosition == FleetName);

                    //jeżeli jest tam statek obcej floty to strzel
                else
                    fireAtPosition(_p.x, _p.y, AttackerPower);

        }
    }

    //sprawdzenie, czy flota nie została w całości zatopiona
    public boolean NoShipsInFleet(){
        boolean Condition1 = Fleet1.noShips();
        boolean Condition2 = Fleet2.noShips();
        boolean End = false;
        if(Condition1==true || Condition2==true)
            End=true;
        return End;
    }

}
