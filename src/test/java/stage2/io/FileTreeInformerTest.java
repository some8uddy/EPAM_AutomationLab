package stage2.io;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class FileTreeInformerTest {

    private FileTreeInformer informer = new FileTreeInformer(new File(""));

    @Test
    public void testGetExtension() {
        assertEquals(".java", FileTreeInformer.getExtension("|    |    |    |    |---ClassificationLevel.java"));
        assertEquals(".txt", FileTreeInformer.getExtension("|    |    |    |---ClassificationLevel.txt"));
        assertEquals("", FileTreeInformer.getExtension("|    |    |    |---ClassificationLevel"));
    }

    @Test
    public void parseFileName() {
        assertEquals("PassengerPlane", informer.parseFileName("|    |    |    |    |---PassengerPlane.java"));
        assertEquals("Main", informer.parseFileName("|    |    |    |---Main.java"));
        assertEquals("OptionalTask1_3", informer.parseFileName("|    |    |    |---OptionalTask1_3.java"));
    }

    @Test
    public void testIsFolder() {
        assertFalse(informer.isFolder("|    |    |    |    |---PassengerPlane.java"));
        assertTrue(informer.isFolder("|    |---stage2"));
    }
}