package mcloudapps.connectFour.views;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MessageTest {

    @Test
    public void testGivenNewMessageWhenToStringThenReturn() {
        assertThat(Message.ENTER_COLUMN_TO_PUT.toString(), is("Player #player turn - Enter the column to put a token: "));
    }

}

