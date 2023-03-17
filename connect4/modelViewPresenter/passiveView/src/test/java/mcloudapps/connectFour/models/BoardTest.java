package mcloudapps.connectFour.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mcloudapps.connectFour.types.Color;
import mcloudapps.utils.models.Coordinate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardTest {

    private BoardBuilder boardBuilder;

    @BeforeEach
    public void beforeEach() {
        this.boardBuilder = new BoardBuilder();
    }

    @Test
    public void testGivenNewBoardWhenResetThenEmpty() {
        Board board = new Board();
        board.reset();
        assertThat(board.cells.isEmpty(), is(true));
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenThenIsColumnFullIsTrue() {
        Board board = this.boardBuilder.rows(
                "Y      ",
                "R      ",
                "Y      ",
                "R      ",
                "Y      ",
                "R      ").build();
        assertThat(board.isColumnFull(1), is(true));
    }

    @Test
    public void testGivenBoardWhenGetColorThenReturn() {
        Board board = this.boardBuilder.rows(
                "Y      ",
                "R      ",
                "Y      ",
                "R      ",
                "Y      ",
                "R      ").build();
        assertThat(board.getCoordinate(new Coordinate(1, 1)), is(Color.R));
    }

    @Test
    public void testGivenBoardWhenGetColorThenReturnNull() {
        Board board = this.boardBuilder.rows(
                "Y      ",
                "R      ",
                "Y      ",
                "R      ",
                "Y      ",
                "R      ").build();
        assertThat(board.getCoordinate(new Coordinate(1, 2)), is((Color) null));
    }

    @Test
    public void testGivenNewBoardWhenPutTokenThenLastCoordinate() {
        Board board = this.boardBuilder.build();
        board.putToken(1, Color.R);
        assertThat(board.lastCoordinate, is(new Coordinate(1, 1)));
    }

    @Test 
    public void testGivenBoardWhenPutTokenThenLastCoordinateIsUpdated() {
        Board board = this.boardBuilder.rows(
                "Y      ",
                "R      ",
                "Y      ",
                "R      ",
                "Y      ",
                "R      ").build();
        board.putToken(2, Color.Y);
        assertThat(board.lastCoordinate, is(new Coordinate(1, 2)));
    }

    @Test
    public void testGivenBoardWhenPutTokenThenIsColumnFullIsTrue() {
        Board board = this.boardBuilder.rows(
                "       ",
                "   R   ",
                "   Y   ",
                "   R   ",
                "   Y   ",
                "   R   ").build();
        board.putToken(4, Color.Y);
        assertThat(board.isColumnFull(4), is(true));
    }

    @Test
    public void testGivenBoardWhenBoardIsFullThenIsTrue(){
        Board board = this.boardBuilder.rows(
            "RRYRYYR",
            "YYRYRRY",
            "RRRYYYR",
            "YYRYYRY",
            "RRYRRRY",
            "YRRYYRY").build();
        assertThat(board.isBoardFull(), is(true));
    }
    
}
