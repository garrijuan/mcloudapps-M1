package mcloudapps.connectFour.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import mcloudapps.connectFour.types.Color;
import mcloudapps.utils.views.Console;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ResultViewTest {

    @Mock
    private Console console;
    private ResultView resultView;

    @BeforeEach
    public void beforeEach() {
        this.resultView = new ResultView();
    }

    @Test
    void testGivenResultViewWhenWriteWinnerThenWriteWinner() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.resultView.writeWinner(Color.R);
            verify(this.console).writeln("R player: You win!!! :-)");
            verify(this.console).writeln("------------------------------");
        }
    }

    @Test
    void testGivenResultViewWhenWriteDrawThenWriteDraw() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.resultView.writeDraw();
            verify(this.console).writeln("Nobody wins: Draw :/");
            verify(this.console).writeln("------------------------------");
        }
    }

    

}
