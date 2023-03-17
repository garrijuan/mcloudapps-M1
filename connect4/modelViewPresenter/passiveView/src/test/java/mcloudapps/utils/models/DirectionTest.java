package mcloudapps.utils.models;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DirectionTest {

    @Test
    public void testGivenNewDirectionWhenGetValuesThenReturn() {
        assertThat(Direction.values().length, is(8));
    }

    @Test 
    public void testGivenNewDirectionWhenGetHalfValuesThenReturn() {
        assertThat(Direction.halfValues().length, is(4));
    }

    @Test
    public void testGivenNewDirectionWhenGetOppositeThenReturn() {
        assertThat(Direction.NORTH.reverse(), is(Direction.SOUTH));
        assertThat(Direction.NORTH_EAST.reverse(), is(Direction.SOUTH_WEST));
        assertThat(Direction.EAST.reverse(), is(Direction.WEST));
        assertThat(Direction.SOUTH_EAST.reverse(), is(Direction.NORTH_WEST));
    }

    
}
