public class MediumShip extends Ship {

    public MediumShip(int Life, int Power, int Point) {

        super(Life, Power, Point);
        _shipType = "MediumShip";
    }

    @Override
    public Position simulateMove() {
        int choice = _r.nextInt(2); //0- lewy ukos; 1- prawy ukos
        Position position = new Position(_x, _y);

        switch(_direction){
            case 0: //north
                switch(choice){
                    case 0:
                        position.x = position.x - 1;
                        position.y = position.y - 1;
                        break;
                    case 1:
                        position.x = position.x + 1;
                        position.y = position.y - 1;
                        break;

                }
                break;
            case 1: //east
                switch(choice) {
                    case 0:
                        position.x = position.x + 1;
                        position.y = position.y - 1;
                        break;
                    case 1:
                        position.x = position.x + 1;
                        position.y = position.y + 1;
                        break;
                }
                break;
            case 2: //south
                switch(choice) {
                    case 0:
                        position.x = position.x + 1;
                        position.y = position.y + 1;
                        break;
                    case 1:
                        position.x = position.x - 1;
                        position.y = position.y + 1;
                        break;
                }
                break;
            case 3: //west
                switch(choice) {
                    case 0:
                        position.x = position.x - 1;
                        position.y = position.y + 1;
                        break;
                    case 1:
                        position.x = position.x - 1;
                        position.y = position.y - 1;
                        break;
                }
                break;
        }

    position = checkBoundaries(position);

    return position;
    }

}
