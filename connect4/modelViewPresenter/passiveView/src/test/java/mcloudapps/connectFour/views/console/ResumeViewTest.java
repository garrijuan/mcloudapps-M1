package mcloudapps.connectFour.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import mcloudapps.utils.views.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ResumeViewTest {
    
        @Mock
        private Console console;
        private ResumeView resumeView;

        @BeforeEach
        public void beforeEach() {
            this.resumeView = new ResumeView();
        }
    
        @Test
        void testGivenResumeViewWhenReadThenIsFalse() {
            try (MockedStatic<Console> console = mockStatic(Console.class)) {
                console.when(Console::getInstance).thenReturn(this.console);
                when(this.console.readString(anyString())).thenReturn("n");
                assertThat(this.resumeView.read(), is(false));
            }
        }
    
        @Test
        void testGivenResumeViewWhenReadThenIsTrue() {
            try (MockedStatic<Console> console = mockStatic(Console.class)) {
                console.when(Console::getInstance).thenReturn(this.console);
                when(this.console.readString(anyString())).thenReturn("y");
                assertThat(this.resumeView.read(), is(true));
            }
        }   

}
