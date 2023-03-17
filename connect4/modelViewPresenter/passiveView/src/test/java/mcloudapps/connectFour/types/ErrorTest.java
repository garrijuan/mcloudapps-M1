package mcloudapps.connectFour.types;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ErrorTest {

    @Test
    public void testGivenNullErrorWhenIsNullThenReturnTrue() {
        assertThat(Error.NULL.isNull(), is(true));
    }

    @Test
    public void testGivenFullBoardErrorWhenIsNullThenReturnFalse() {
        assertThat(Error.FULL_BOARD.isNull(), is(false));
    }
    
}
