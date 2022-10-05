package marsrover;

public class Rover {

    private Direction direction = Direction.N;
    private int x;
    private int y;
    private final int maxX;
    private final int maxY;

    public Rover(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public String execute(String command) {

        for (char c : command.toCharArray()) {
            if ('R' == c) {
                turnRight();
            } else if ('L' == c) {
                turnLeft();
            } else if ('M' == c) {
                move();
            }

            normalize();
        }

        return toString();
    }

    public String toString() {
        return x + ":" + y + ":" + direction.name();
    }

    private void normalize() {
        if (x<0) {
            x = maxX;
        }
        if (y<0) {
            y = maxY;
        }
        if (x>maxX){
            x=0;
        }
        if (y>maxY){
            y=0;
        }
    }

    private void turnLeft() {
        direction = direction.left();
    }

    private void turnRight() {
        direction = direction.right();
    }

    private void move() {
        if (direction == Direction.N) {
            y++;
        } else if (direction == Direction.E) {
            x++;
        } else if (direction == Direction.W) {
            x--;
        } else if (direction == Direction.S) {
            y--;
        }
    }

    enum Direction {
        N, E, S, W;

        private Direction right;
        private Direction left;

        static {
            N.right = Direction.E;
            E.right = Direction.S;
            S.right = Direction.W;
            W.right = Direction.N;

            N.left = Direction.W;
            E.left = Direction.N;
            S.left = Direction.E;
            W.left = Direction.S;
        }

        public Direction right() {
            return right;
        }

        public Direction left() {
            return left;
        }
    }
}
