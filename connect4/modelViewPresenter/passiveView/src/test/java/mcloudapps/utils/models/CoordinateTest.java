package mcloudapps.utils.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CoordinateTest {

    private Coordinate coordinate;

    @BeforeEach
    public void beforeEach() {
        this.coordinate = new Coordinate(1, 2);
    }
    
    @Test
    public void testGivenNewCoordinateWhenGetRowThenReturn() {
        assertThat(this.coordinate.getRow(), is(1));
    }

    @Test
    public void testGivenNewCoordinateWhenGetColumnThenReturn() {
        assertThat(this.coordinate.getColumn(), is(2));
    }

    @Test 
    public void testGivenNewCoordinateWhenIsNullThenReturnFalse() {
        assertThat(this.coordinate.isNull(), is(false));
    }

    @Test
    public void testGivenNewCoordinateWhenWrongThenReturnFalse() {
        assertThat(this.coordinate.isValid(-1, 2), is(false));
        assertThat(this.coordinate.isValid(1, 0), is(false));
    }

    @Test
    public void testGivenNewCoordinateWhenIsShiftedThenReturn() {
        this.coordinate.shift(Direction.NORTH);
        assertThat(this.coordinate.getRow(), is(2));
        assertThat(this.coordinate.getColumn(), is(2));
        this.coordinate.shift(Direction.EAST);
        assertThat(this.coordinate.getRow(), is(2));
        assertThat(this.coordinate.getColumn(), is(3));
        this.coordinate.shift(Direction.NORTH_EAST);
        assertThat(this.coordinate.getRow(), is(3));
        assertThat(this.coordinate.getColumn(), is(4));
        this.coordinate.shift(Direction.SOUTH_WEST);
        assertThat(this.coordinate.getRow(), is(2));
        assertThat(this.coordinate.getColumn(), is(3));
    }

}
