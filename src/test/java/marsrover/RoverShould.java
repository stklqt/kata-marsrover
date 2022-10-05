package marsrover;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RoverShould {

    private Rover rover;

    @ParameterizedTest
    @CsvSource(
            {"R, 0:0:E"
                    ,"RR, 0:0:S"
                    ,"RRR, 0:0:W"
                    ,"RRRR, 0:0:N"
            })
    void rotate_sometime_at_position(String commands, String expectedPosition) {
        rover = new Rover();
        Assertions.assertThat(rover.execute(commands)).isEqualTo(expectedPosition);
    }


    @ParameterizedTest
    @CsvSource(
            {"L, 0:0:W"
            })
    @Disabled
    void rotate_sometime_left_at_position(String commands, String expectedPosition) {
        rover = new Rover();
        Assertions.assertThat(rover.execute(commands)).isEqualTo(expectedPosition);
    }

    @Test
    void start_at_position_0_0_N() {
        rover = new Rover();
        Assertions.assertThat(rover.execute("")).isEqualTo("0:0:N");
    }

    @Test
    void rotate_at_position() {
        rover = new Rover();
        Assertions.assertThat(rover.execute("R")).isEqualTo("0:0:E");
    }

    @Test
    @Disabled
    void move_to_position_2_3_N() {
        rover = new Rover();
        Assertions.assertThat(rover.execute("MMRMMLM")).isEqualTo("2:3:N");
    }
}
