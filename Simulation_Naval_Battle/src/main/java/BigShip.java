public class BigShip extends Ship {

    public BigShip(int Life, int Power, int Point) {
        super(Life, Power, Point);
        _shipType = "BigShip";

    }

    @Override
    public Position simulateMove() {
        int choice = _r.nextInt(3); //0- lewy ukos; 1- prosto; 2- prawy ukos
        Position position = new Position(_x, _y);

        switch(_direction){
            case 0: //north
                switch(choice){
                    case 0:
                        position.x = position.x - 1;
                        position.y = position.y - 1;
                        break;
                    case 1:
                        position.y = position.y - 1;
                        break;
                    case 2:
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
                        break;
                    case 2:
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
                        position.y = position.y + 1;
                        break;
                    case 2:
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
                        break;
                    case 2:
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
