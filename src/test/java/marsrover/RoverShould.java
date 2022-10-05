package marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RoverShould {

    private Rover rover;
    private Grid grid;

    @BeforeEach
    public void initialise() {
        grid = new Grid(10, 10);
        rover = new Rover(grid);
    }

    @ParameterizedTest
    @CsvSource(
            {"R, 0:0:E",
                    "RR, 0:0:S",
                    "RRR, 0:0:W",
                    "RRRR, 0:0:N"
            })
    void rotate_sometime_right_at_position(String commands, String expectedPosition) {
        assertThat(rover.execute(commands)).isEqualTo(expectedPosition);
    }


    @ParameterizedTest
    @CsvSource(
            {
                    "L, 0:0:W",
                    "LL, 0:0:S",
                    "LLL, 0:0:E",
                    "LLLL, 0:0:N"
            })
    void rotate_sometime_left_at_position(String commands, String expectedPosition) {
        assertThat(rover.execute(commands)).isEqualTo(expectedPosition);
    }


    @ParameterizedTest
    @CsvSource(
            {
                    "M, 0:1:N",
                    "MMM, 0:3:N",
            })
    public void move_up(String command, String position) {
        assertThat(rover.execute(command)).isEqualTo(position);
    }


    @ParameterizedTest
    @CsvSource(
            {
                    "MRRM, 0:0:S",
                    "MMMMMRRMMM, 0:2:S"
            })
    public void move_down(String command, String position) {
        assertThat(rover.execute(command)).isEqualTo(position);
    }


    @Test
    void start_at_position_0_0_N() {
        assertThat(rover.execute("")).isEqualTo("0:0:N");
    }

    @Test
    void rotate_at_position() {
        assertThat(rover.execute("R")).isEqualTo("0:0:E");
    }

    @Test
    void move_to_position_2_3_N() {
        assertThat(rover.execute("MMRMMLM")).isEqualTo("2:3:N");
    }

    @ParameterizedTest
    @CsvSource({
            "RM, 1:0:E",
            "RMMMMM, 5:0:E"
    })
    public void
    move_right(String command, String position) {
        assertThat(rover.execute(command)).isEqualTo(position);
    }

    @ParameterizedTest
    @CsvSource({
            "RMRRM, 0:0:W",
            "RMMMMMRRMM, 3:0:W"
    })
    public void
    move_left(String command, String position) {
        assertThat(rover.execute(command)).isEqualTo(position);
    }

    @ParameterizedTest
    @CsvSource({
            "MMMMMMMMMM, 0:0:N",
            "MMMMMMMMMMMMMMM, 0:5:N"
    })
    public void
    wrap_from_top_to_bottom(String command, String position) {
        assertThat(rover.execute(command)).isEqualTo(position);
    }

    @ParameterizedTest
    @CsvSource({
            "RRM, 0:9:S",
            "RRMMMMM, 0:5:S"
    })
    public void
    wrap_from_bottom_to_top(String command, String position) {
        assertThat(rover.execute(command)).isEqualTo(position);
    }

    @ParameterizedTest
    @CsvSource({
            "RMMMMMMMMMM, 0:0:E",
            "RMMMMMMMMMMMMMMM, 5:0:E"
    })
    public void
    wrap_from_right_to_left(String command, String position) {
        assertThat(rover.execute(command)).isEqualTo(position);
    }

    @ParameterizedTest
    @CsvSource({
            "LM, 9:0:W",
            "LMMMMM, 5:0:W"
    })
    public void
    wrap_from_left_to_right(String command, String position) {
        assertThat(rover.execute(command)).isEqualTo(position);
    }


}
