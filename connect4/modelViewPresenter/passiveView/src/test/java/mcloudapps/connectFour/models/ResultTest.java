package mcloudapps.connectFour.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mcloudapps.connectFour.types.Color;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

public class ResultTest {

    private Result result;
    private BoardBuilder boardBuilder;

    @BeforeEach
    public void beforeEach() {
        this.boardBuilder = new BoardBuilder();
        this.result = new Result(new Board());
    }

    @Test
    public void testGivenNewResultWhenNullBoardThenAssertionError() {
        Assertions.assertThrows(AssertionError.class, () -> new Result(null));
    }

    @Test
    public void testGivenOneTokenOnBoardWhenConnectFourThenIsFalse(){
        Board board = this.boardBuilder.rows(
            "       ",
            "       ",
            "       ",
            "       ",
            "       ",
            "R      ").build();
        this.result = new Result(board);
        assertThat(this.result.isGameOver(), is(false));
    }

    @Test
    public void testGivenAllTokensOnBoardWhenIsDrawThenIsTrue(){
        Board board = this.boardBuilder.rows(
            "RRYRYYR",
            "YYRYRRY",
            "RRRYYYR",
            "YYRYYRY",
            "RRYRRRY",
            "YRRYYRY").build();
        this.result = new Result(board);
        assertThat(this.result.isGameOver(), is(true));
    }

    @Test
    public void testGivenResultWhenIsNotConnectFourThenIsNull(){
        Board board = this.boardBuilder.rows(
            "       ",
            "       ",
            "R      ",
            "YR     ",
            "YYY    ",
            "RYYRR  ").build();
        this.result = new Result(board);
        assertThat(this.result.getResult(), is(nullValue()));
    }

    @Test
    public void testGivenResultWhenIsVerticalConnectFourThenIsTrue(){
        Board board = this.boardBuilder.rows(
            "       ",
            "  R    ",
            "  R    ",
            "  R    ",
            "  R    ",
            "  R    ").build();
        this.result = new Result(board);
        assertThat(this.result.getResult(), not(Color.Y));
        assertThat(this.result.getResult(), is(Color.R));
    }

    @Test
    public void testGivenResultWhenIsHorizontalConnectFourThenIsTrue(){
        Board board = this.boardBuilder.rows(
            "       ",
            "       ",
            "       ",
            "       ",
            "       ",
            " RRRRR ").build();
        this.result = new Result(board);
        assertThat(this.result.getResult(), not(Color.Y));
        assertThat(this.result.getResult(), is(Color.R));
    }

    @Test
    public void testGivenResultWhenIsAscendingDiagonalConnectFourThenIsTrue(){
        Board board = this.boardBuilder.rows(
            "       ",
            "       ",
            "   R   ",
            "  R    ",
            " R     ",
            "R      ").build();
        this.result = new Result(board);
        assertThat(this.result.getResult(), not(Color.Y));
        assertThat(this.result.getResult(), is(Color.R));
    }

    @Test
    public void testGivenResultWhenIsDescendingDiagonalConnectFourThenIsTrue(){
        Board board = this.boardBuilder.rows(
            "       ",
            "       ",
            " R     ",
            "  R    ",
            "   R   ",
            "    R  ").build();
        this.result = new Result(board);
        assertThat(this.result.getResult(), not(Color.Y));
        assertThat(this.result.getResult(), is(Color.R));
    }
    
}
