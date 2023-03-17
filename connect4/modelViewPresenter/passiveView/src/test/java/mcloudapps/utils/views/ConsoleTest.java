package mcloudapps.utils.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsoleTest {

    @Mock
    private BufferedReader bufferedReader;

    @InjectMocks
    private Console console;

    @Mock
    private PrintStream outputStream;

    @BeforeEach
    public void beforeEach() {
        System.setOut(this.outputStream);
    }

    @Test
    public void testGivenConsoleWhenReadStringThenValue() throws IOException {
        String string = "***";
        when(this.bufferedReader.readLine()).thenReturn(string);
        assertThat(this.console.readString("TITLE"), is(string));
    }

    @Test
    public void testGivenConsoleWhenReadIntThenValue() throws IOException {
        String string = "123";
        when(this.bufferedReader.readLine()).thenReturn("", "***", string);
        assertThat(this.console.readInt("TITLE"), is(Integer.parseInt(string)));
    }

    @Test
    public void testGivenConsoleWhenWriteStringThenDisplay(){
        String string = "***";
        Console.getInstance().write(string);
        verify(this.outputStream).print(string);
    }

    @Test
    public void testGivenConsoleWhenWritelnThenDisplay(){
        Console.getInstance().writeln();
        verify(this.outputStream).println();
    }

    @Test
    public void testGivenConsoleWhenWritelnStringThenDisplay(){
        String string = "***";
        Console.getInstance().writeln(string);
        verify(this.outputStream).print(string);
        verify(this.outputStream).println();
    }

    @Test
    public void testGivenConsoleWhenWriteErrorThenDisplay(){
        String format = "(a | b)";
        Console.getInstance().writeError(format);
        verify(this.outputStream).print("FORMAT ERROR! " + "Enter a " + format + " formatted value.");
        verify(this.outputStream).println();
    }

}
