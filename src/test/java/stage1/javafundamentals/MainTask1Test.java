package stage1.javafundamentals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTask1Test {

    @Test
    public void getResponse() {
        assertEquals("Hello Mr. John Dow!!!", MainTask1.getResponse(new String[]{"John", "Dow"}));
        assertEquals("Hello Mr. John!!!", MainTask1.getResponse(new String[]{"John"}));
        assertEquals("Hello Mr. No-name!!!", MainTask1.getResponse(new String[]{}));
    }

}