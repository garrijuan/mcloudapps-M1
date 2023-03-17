package mcloudapps.connectFour.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import mcloudapps.connectFour.types.Color;
import mcloudapps.utils.views.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerViewTest {
    
    @Mock
    private Console console;
    private PlayerView playerView;

    @BeforeEach
    public void beforeEach() {
        this.playerView = new PlayerView();
    }

    @Test
    void testGivenPlayerViewWhenReadColumnThenReturnInt() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt("Player R turn - Enter the column to put a token:  [1, 7]: ")).thenReturn(1);
            assertThat(this.playerView.readColumn(Color.R), is(1));
        }
    }

}
