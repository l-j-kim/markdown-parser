//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
//https://stackoverflow.com/questions/8141698/split-using-a-bracket

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )

        String[] divider = markdown.split("\\[");
        int openBracket = 0;
        int closeBracket; 
        int openParen;
        int closeParen;

        for (String str: divider) {
            if (str.indexOf("]") != -1 && str.indexOf("(") != -1 && str.indexOf(")") != -1) {
                closeBracket = str.indexOf("]", openBracket);
                openParen = str.indexOf("(", closeBracket);
                closeParen = str.lastIndexOf(")");

                toReturn.add(str.substring(openParen + 1, closeParen));
            }
        }
        return toReturn;
    }
    
    


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);

    }
}