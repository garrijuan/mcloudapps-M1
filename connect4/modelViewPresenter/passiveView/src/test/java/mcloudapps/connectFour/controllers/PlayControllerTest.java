package mcloudapps.connectFour.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import mcloudapps.connectFour.views.PlayerView;
import mcloudapps.connectFour.views.ResultView;
import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.models.GameBuilder;
import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;
import mcloudapps.connectFour.views.console.ErrorView;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayControllerTest extends ControllerTest {

    @Mock
    private PlayerView playerView;

    @Mock
    private ResultView resultView;

    @Mock
    private ErrorView errorView;

    private Game game;

    @Override
    protected Controller getController(String... rows) {
        this.game = new GameBuilder().rows(rows).build();
        return new PlayController(this.game, this.viewFactory);
    }

    private void setupMocks() {
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);
        when(this.viewFactory.createPlayerView()).thenReturn(this.playerView);
        when(this.viewFactory.createResultView()).thenReturn(this.resultView);
        when(this.viewFactory.createErrorView()).thenReturn(this.errorView);
    }

    @Test
    public void testGivenPlayControllerWinnerGameWhenControlThenIsWinnerAndPutToken() {
        this.setupMocks();
        this.controller = this.getController(
            "       ",
            "       ",
            "       ",
            "       ",
            "R      ",
            "YYY    ");
        int column = 4;
        when(this.playerView.readColumn(any())).thenReturn(column);
        ((PlayController) this.controller).control();
        verify(this.game).putToken(column, Color.Y);
        verify(this.resultView).writeWinner(Color.Y);
    }

    @Test
    public void testGivenPlayControllerWhenControlThenPutTokenError() {
        this.setupMocks();
        this.controller = this.getController(
                "Y      ",
                "R      ",
                "Y      ",
                "R      ",
                "Y      ",
                "RYYY   ");
        int column = 1;
        when(this.playerView.readColumn(any())).thenReturn(column, 5);
        ((PlayController) this.controller).control();
        verify(this.errorView).writeln(Error.FULL_COLUMN);
    }

    @Test
    public void testGivenPlayControllerTieGameWhenControlThenIsDraw() {
        this.setupMocks();
        this.controller = this.getController(
                "RRYRY R",
                "YYRYRRY",
                "RRRYYYR",
                "YYRYYRY",
                "RRYRRRY",
                "YRRYYRY");
        int column = 6;
        when(this.playerView.readColumn(any())).thenReturn(column);
        ((PlayController) this.controller).control();
        verify(this.game).putToken(column, Color.Y);
        verify(this.resultView).writeDraw();
    }    

}
