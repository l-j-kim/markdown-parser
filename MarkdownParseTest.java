import static org.junit.Assert.*;           //imports junit.Assert

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;                         //imports junit
public class MarkdownParseTest {            //class header
    @Test                                   //test annotation, indicates that this is a test case
    public void addition() {                //method headere
        assertEquals(2, 1 + 1);     //test that is run: checks if 2 = 1 + 1
    }

    @Test
    public void getLinksTestFile() throws IOException {
        Path pathes = Path.of("test-file.md");
        String contents = Files.readString(pathes);

        List<String> expected = List.of("https://something.com", "some-page.html");
        List<String> actual = MarkdownParse.getLinks(contents);

        assertEquals(expected, actual);
    }
    
    @Test
    public void getLinksTest2() throws IOException {
        Path pathes = Path.of("test-2.md");
        String contents = Files.readString(pathes);

        List<String> expected = List.of("https://www.convertunits.com/molarmass/(NH4)2SO4", 
       "https://www.convertunits.com/molarmass/Mg(NO3)2");
        List<String> actual = MarkdownParse.getLinks(contents);

        assertEquals(expected, actual);
    }
    
    @Test
    public void getLinksTest3() throws IOException {
        Path pathes = Path.of("test-3.md");
        String contents = Files.readString(pathes);

        List<String> expected = List.of("https://something.com", "https://canvas.ucsd.edu/");
        List<String> actual = MarkdownParse.getLinks(contents);

        assertEquals(expected, actual);
    }

    @Test
    public void getLinksTest4() throws IOException {
        Path pathes = Path.of("test-4.md");
        String contents = Files.readString(pathes);

        List<String> expected = new ArrayList<String>();
        List<String> actual = MarkdownParse.getLinks(contents);

        assertEquals(expected, actual);
    }

    @Test
    public void getLinksTestFile2() throws IOException {
        Path pathes = Path.of("test-file2.md");
        String contents = Files.readString(pathes);

        List<String> expected = List.of("https://something.com", "some-page.html");
        List<String> actual = MarkdownParse.getLinks(contents);

        assertEquals(expected, actual);
    }

    @Test
    public void getLinksTestFile3() throws IOException {
        Path pathes = Path.of("test-file3.md");
        String contents = Files.readString(pathes);

        List<String> expected = List.of();
        List<String> actual = MarkdownParse.getLinks(contents);

        assertEquals(expected, actual);
    }

    @Test
    public void getLinksTestFile4() throws IOException {
        Path pathes = Path.of("test-file4.md");
        String contents = Files.readString(pathes);

        List<String> expected = new ArrayList<String>();
        List<String> actual = MarkdownParse.getLinks(contents);

        assertEquals(expected, actual);
    }

    @Test
    public void getLinksTestFile5() throws IOException {
        Path pathes = Path.of("test-file5.md");
        String contents = Files.readString(pathes);

        List<String> expected = List.of("page.com");
        List<String> actual = MarkdownParse.getLinks(contents);

        assertEquals(expected, actual);
    }

    @Test
    public void getLinksTestFile6() throws IOException {
        Path pathes = Path.of("test-file6.md");
        String contents = Files.readString(pathes);

        List<String> expected = List.of("page.com");
        List<String> actual = MarkdownParse.getLinks(contents);

        assertEquals(expected, actual);
    }

    @Test
    public void getLinksTestFile7() throws IOException {
        Path pathes = Path.of("test-file7.md");
        String contents = Files.readString(pathes);

        List<String> expected = new ArrayList<String>();
        List<String> actual = MarkdownParse.getLinks(contents);

        assertEquals(expected, actual);
    }

    @Test
    public void getLinksTestFile8() throws IOException {
        Path pathes = Path.of("test-file8.md");
        String contents = Files.readString(pathes);

        List<String> expected = List.of("a link on the first line");
        List<String> actual = MarkdownParse.getLinks(contents);

        assertEquals(expected, actual);
    } 
}