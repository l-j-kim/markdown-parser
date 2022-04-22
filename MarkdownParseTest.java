import static org.junit.Assert.*;   //imports junit.Assert

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;                 //imports junit
public class MarkdownParseTest {    //class header
    @Test                           //test annotation, indicates that this is a test case
    public void addition() {        //method headere
        assertEquals(2, 1 + 1);     //test that is run: checks if 2 = 1 + 1
    }

    @Test
    public void getLinksTest() throws IOException {
        Path pathes = Path.of("test-file.md");
        String contents = Files.readString(pathes);

        List<String> expected = List.of("https://something.com", "some-page.html");
        List<String> actual = MarkdownParse.getLinks(contents);

        assertEquals(expected, actual);
    }
}