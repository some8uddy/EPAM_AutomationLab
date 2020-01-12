package stage2.io;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class TreeToFileTest {

    private TreeToFile treeToFile = new TreeToFile(new File(""), "");

    @Test
    public void testGetFormattedString() {
        assertEquals("two",
            treeToFile.getFormattedString(new File("C:\\one\\two"), 2));
        assertEquals("|---two",
            treeToFile.getFormattedString(new File("C:\\one\\two"), 1));
        assertEquals("|    |---three",
            treeToFile.getFormattedString(new File("C:\\one\\two\\three"), 1));
    }

    @Test
    public void testGetNestingDepth() {
        assertEquals(1, treeToFile.getNestingDepth("C:\\"));
        assertEquals(2, treeToFile.getNestingDepth("C:\\one\\two"));
        assertEquals(3, treeToFile.getNestingDepth("C:\\one\\two\\three"));
    }
}