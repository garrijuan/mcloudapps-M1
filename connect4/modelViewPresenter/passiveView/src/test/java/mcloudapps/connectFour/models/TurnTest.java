package mcloudapps.connectFour.models;

import mcloudapps.connectFour.types.Color;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TurnTest {

    private Turn turn;

    @BeforeEach
    public void beforeEach() {
        this.turn = new Turn(new Board());
    }

    @Test
    public void testGivenNewTurnWhenNullBoardThenAssertionError() {
        Assertions.assertThrows(AssertionError.class, () -> new Turn(null));
    }

    @Test
    public void testGivenNewTurnWhenGetActivePlayerThenReturn() {
        assertThat(this.turn.getActivePlayer().getColor(), is(Color.get(this.turn.getActivePlayer().getColor().ordinal())));
    }

    @Test
    public void testGivenNewTurnWhenNextPlayerThenChangeActivePlayer() {
        Color color = this.turn.getActivePlayer().getColor();
        this.turn.nextPlayer();
        assertThat(this.turn.getActivePlayer().getColor(), is(Color.get(color.ordinal() + 1)));
    }
    
}
