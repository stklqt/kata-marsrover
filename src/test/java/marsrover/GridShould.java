package marsrover;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.singletonList;

public class GridShould {

    private Grid grid = new Grid(10, 10);

    @Test
    public void return_same_coordinate_when_next_cell_has_obstable() {
        List<Coordinate> obstacles = singletonList(new Coordinate(1, 2));
        grid = new Grid(10, 10, obstacles);
        Coordinate position = new Coordinate(1, 1);
        Direction direction = Direction.NORTH;

        Assertions.assertThat(grid.nextCellPosition(position, direction)).isEqualTo(position);
    }

}