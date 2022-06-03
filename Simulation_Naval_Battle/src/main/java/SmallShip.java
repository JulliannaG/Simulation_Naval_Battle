public class SmallShip extends Ship {

    public SmallShip(int Life, int Power, int Point) {

        super(Life, Power, Point);
        _shipType = "SmallShip";
    }

    @Override
    public Position simulateMove() {
        Position position = new Position(_x, _y);

        switch(_direction){
            case 0: //north
                position.y = position.y - 1;
                break;
            case 1: //east
                position.x = position.x + 1;
                break;
            case 2: //south
                position.y = position.y + 1;
                break;
            case 3: //west
                position.x = position.x - 1;
                break;
        }

        position = checkBoundaries(position);

        return position;
    }

}
