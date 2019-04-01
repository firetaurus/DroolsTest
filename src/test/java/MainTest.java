import org.junit.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class MainTest {

    private final String ruleFile = "Rule.drl";

    @Test
    public void testFilePath() throws FileNotFoundException {

        Path path = Paths.get(ruleFile);

        assertNotNull(path);

        InputStream resourceAsStream = getClass().getResourceAsStream(path.toString());

        FileReader reader = new FileReader(String.valueOf(resourceAsStream));

        assertNotNull(reader);
    }
}