package mcloudapps.connectFour.views.console;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import mcloudapps.connectFour.models.Board;
import mcloudapps.connectFour.types.Color;
import mcloudapps.utils.models.Coordinate;
import mcloudapps.utils.views.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BoardViewTest {

    @Mock
    private Console console;
    private BoardView boardView;

    @BeforeEach
    public void beforeEach() {
        this.boardView = new BoardView();
    }

    @Test
    void testGivenBoardViewWhenSetTooManyTimesThenAssertionError() {
        for (int i = 1; i <= Board.getNumberOfRows(); i++) {
            for (int j = 1; j <= Board.getNumberOfColumns(); j++) {
                this.boardView.set(new Coordinate(i, j), Color.R);
            }
        }
        Assertions.assertThrows(AssertionError.class, () -> this.boardView.set(new Coordinate(1, 1), Color.R));
    }

    @Test
    void testGivenBoardViewWhenWriteThenWrite() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.addColors();
            this.boardView.write();
            String expectedBoard = this.getExpectedBoard();
            ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
            verify(this.console, atLeast(0)).writeln(argumentCaptor.capture());
            verify(this.console, atLeast(0)).write(argumentCaptor.capture());
            List<String> argumentCaptorValues = argumentCaptor.getAllValues();
            this.reorder(argumentCaptorValues);
            assertThat(expectedBoard, is(this.arrayToString(argumentCaptorValues.toArray()).replaceAll("NONE"," ").replaceAll("\\n", "")));
        }
    }

    private void addColors(){    
        this.boardView.set(new Coordinate(1, 1), Color.R);
        this.boardView.set(new Coordinate(1, 2), Color.Y);           
        for (int i = 1; i <= Board.getNumberOfRows(); i++) {
            for (int j = 1; j <= Board.getNumberOfColumns(); j++) {
                if (i != 1 && j > 2) {
                    this.boardView.set(new Coordinate(i, j), Color.NONE);
                }
            }   
        }             
    }

    private String getExpectedBoard() {
        return arrayToString(new String[]{
            "------------------------------",
            " |   |   |   |   |   |   |   | ",
            " |   |   |   |   |   |   |   | ",
            " |   |   |   |   |   |   |   | ",
            " |   |   |   |   |   |   |   | ",
            " |   |   |   |   |   |   |   | ",
            " | R | Y |   |   |   |   |   | ",
            "------------------------------"}
        ).replaceAll(", ", "");
    }

    private String arrayToString(Object[] objects) {
        String string = "";
        for (Object object : objects) {
            string += object;
        }
        return string;
    }

    private void reorder(List<String> list) {
        list.add(list.size() - 1, list.remove(1));
    }
}
