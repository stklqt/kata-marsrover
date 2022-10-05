package marsrover;

import static marsrover.Direction.NORTH;

public class Rover{
    private Direction direction = NORTH;
    private Coordinate coordinate = new Coordinate(0, 0);
    private Grid grid;

    public Rover(Grid grid) {
        this.grid = grid;
    }

    public String execute(String commands) {
        for (char command : commands.toCharArray()) {
            if (command == 'R') {
                direction = direction.right();
            }
            if (command == 'L') {
                direction = direction.left();
            }
            if (command == 'M') {
                coordinate = grid.nextCellPosition(coordinate, direction);
            }
        }
        return coordinate.x() + ":" + coordinate.y() + ":" + direction.stringValue();


    }


}
