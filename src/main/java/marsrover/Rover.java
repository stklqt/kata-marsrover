package marsrover;

public class Rover {

    String direction = "N";

    Rover() {
    }

    public String execute(String commands) {
        for (char command : commands.toCharArray()) {
            if(command == 'R') direction = rotateRight();
            else if (command =='L') {
                throw  new UnsupportedOperationException();
            }
        }

        return "0:0:" + direction;
    }

    private String rotateRight() {
        if (direction == "E") {
            return "S";
        } else if (direction == "N") {
            return "E";
        } else if (direction == "S") {
            return "W";
        } else {
            return "N";
        }
    }


}
