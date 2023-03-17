package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.views.Message;
import mcloudapps.utils.views.Console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MessageViewTest {

    @Mock
    private Console console;
    private MessageView messageView;

    @BeforeEach
    public void beforeEach(){
        this.messageView = new MessageView();
    }

    @Test
    public void testGivenNewMessageWhenWriteThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.messageView.write(Message.ENTER_COLUMN_TO_PUT);
            verify(this.console).write("Player #player turn - Enter the column to put a token: ");
        }
    }

    @Test
    public void testGivenNewMessageWhenWritelnThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.messageView.writeln(Message.ENTER_COLUMN_TO_PUT);
            verify(this.console).writeln("Player #player turn - Enter the column to put a token: ");
        }
    }

    @Test
    public void testGivenMessageWhenWriteWinnerThenPrint(){
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.messageView.writeWinner(Color.R);
            verify(this.console).writeln("R player: You win!!! :-)");
            this.messageView.writeWinner(Color.Y);
            verify(this.console).writeln("Y player: You win!!! :-)");            
        }
    }

    @Test
    public void testGivenMessageWhenWriteColorThenPrint(){
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.messageView.writeColor(Color.R);
            verify(this.console).write("R");
            this.messageView.writeColor(Color.Y);
            verify(this.console).write("Y");            
        }
    }



}