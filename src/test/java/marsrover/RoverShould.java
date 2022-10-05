package marsrover;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RoverShould {
    private Rover rover;

    @BeforeEach
    void setUp() {
        rover = new Rover(2, 3);
    }

    @Test
    void start_at_position_0_0_N() {
        Assertions.assertThat(rover.execute("")).isEqualTo("0:0:N");
    }

    @Test
    void move_to_position_2_3_N() {
        Assertions.assertThat(rover.execute("MMRMMLM")).isEqualTo("2:3:N");
    }

    @ParameterizedTest
    @CsvSource({
            "'', 0:0:N",
            "M, 0:1:N",
            "RM, 1:0:E",
            "LM, 2:0:W",
            "RRM, 0:3:S",
            "MMMM, 0:0:N",
            "RMMM, 0:0:E",
            "MMRMMLM, 2:3:N",
    })
    void should_move(String command, String expectedPosition) {
        assertThat(rover.execute(command)).isEqualTo(expectedPosition);
    }

    @ParameterizedTest
    @CsvSource({"R, E", "RR, S", "RRR, W", "RRRR, N"})
    void should_turn_right(String command, String expectedDirection) {
        assertThat(rover.execute(command)).isEqualTo("0:0:"+expectedDirection);
    }

    @ParameterizedTest
    @CsvSource({"L, W", "LL, S", "LLL, E", "LLLL, N"})
    void should_turn_left(String command, String expectedDirection) {
        assertThat(rover.execute(command)).isEqualTo("0:0:"+expectedDirection);
    }
}
