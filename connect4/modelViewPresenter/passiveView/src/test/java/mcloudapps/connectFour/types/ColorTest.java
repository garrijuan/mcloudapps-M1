package mcloudapps.connectFour.types;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ColorTest {

    @Test
    public void testGivenNewColorWhenGetColorThenReturn() {
        assertThat(Color.get(0), is(Color.R));
        assertThat(Color.get(1), is(Color.Y));
    }

    @Test
    public void testGivenNewColorWhenGetThenAssertionError(){
        Assertions.assertThrows(AssertionError.class, () -> Color.get(-1));
        Assertions.assertThrows(AssertionError.class, () -> Color.get(2));
    }

    @Test
    public void testGivenNewColorWhenIsNullThenReturn() {
        assertThat(Color.R.isNull(), is(false));
        assertThat(Color.Y.isNull(), is(false));
        assertThat(Color.NONE.isNull(), is(true));
    }

}
