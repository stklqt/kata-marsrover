package marsrover;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoverShould {
    Rover rover;

    @Test
    void start_at_position_0_0_N() {
        rover = new Rover();
        Assertions.assertThat(rover.execute("")).isEqualTo("0:0:N");
    }

    @Test
    void move_to_position_2_3_N() {
        rover = new Rover();
        Assertions.assertThat(rover.execute("MMRMMLM")).isEqualTo("2:3:N");
    }
}
