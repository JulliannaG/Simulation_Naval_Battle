public class FireShip extends Ship{

    public FireShip(int Life, int Power, int Point) {
        super(Life, Power, Point);
        _shipType = "FireShip";
    }

    @Override
    public Position simulateMove() {
        Position position = new Position(_x, _y);

        switch(_direction){
            case 0: //north
                position.y = position.y - 5;
                break;
            case 1: //east
                position.x = position.x + 5;
                break;
            case 2: //south
                position.y = position.y + 5;
                break;
            case 3: //west
                position.x = position.x - 5;
                break;
        }

        position = checkBoundaries(position);

        return position;
    }

    //statek nie zmienia swojej pozycji z wyjątkiem pierwszego rozstawienia
    @Override
    public void setPosition(int x, int y){
        if(_x == -1) _x = x;
        if(_y == -1) _y = y;
    }

}

