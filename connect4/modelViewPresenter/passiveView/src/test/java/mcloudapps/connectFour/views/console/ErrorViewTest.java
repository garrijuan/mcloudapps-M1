package mcloudapps.connectFour.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import mcloudapps.utils.views.Console;
import mcloudapps.connectFour.types.Error;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ErrorViewTest {
    @Mock
    private Console console;
    private ErrorView errorView;

    @BeforeEach
    public void beforeEach(){
        this.errorView = new ErrorView();
    }

    @Test
    public void testGivenCorrectErrorWhenWritelnThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.errorView.writeln(Error.FULL_COLUMN);
            verify(this.console).writeln("The column is full");
        }
    }

    @Test
    public void testGivenNullErrorWhenWritelnThenConsoleIsNotCalled() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.errorView.writeln(Error.NULL);
            verify(this.console, never()).writeln(anyString());
        }
    }


}