import java.util.ArrayList;

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

class TryCommonMark {
    public static void main(String[] args) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse("This is *Sparta*");
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
        
        //this part actually does the computation
        Node nodeLink = parser.parse("[ein link](ucsd.edu)[canvas again](canvas.org)[google](google.com)");
        NumLinkVisitor visitorLink = new NumLinkVisitor();
        nodeLink.accept(visitorLink);
        System.out.println("number of links: " + visitorLink.numLinks);  // 1 
        
        Node nodeList = parser.parse("[ein link](ucsd.edu)[canvas again](canvas.org)[google](google.com)");
        ListLinkVisitor visitorList = new ListLinkVisitor();
        nodeList.accept(visitorList);
        System.out.println("list of links: ");
        for (String link: visitorList.listOfLinks) {
            System.out.println(link);
        }

        Node nodeText = parser.parse("Example\n=======\n\nSome more text");
        WordCountVisitor visitorText = new WordCountVisitor();
        nodeText.accept(visitorText);
        System.out.println("number of words: " + visitorText.wordCount);  // 4 */
        
    }
}

class ListLinkVisitor extends AbstractVisitor {
    ArrayList<String> listOfLinks = new ArrayList<String>();
    public void visit(Link link) {
        listOfLinks.add(link.toString());
        visitChildren(link);
    }
}

class NumLinkVisitor extends AbstractVisitor {
    int numLinks = 0;

    public void visit(Link link) {
        numLinks += 1;
        visitChildren(link);
    }
}

//this class can be defined anywhere in the file
class WordCountVisitor extends AbstractVisitor {
    int wordCount = 0;

    @Override
    public void visit(Text text) {
        // This is called for all Text nodes. Override other visit methods for other node types.

        // Count words (this is just an example, don't actually do it this way for various reasons).
        wordCount += text.getLiteral().split("\\W+").length;

        // Descend into children (could be omitted in this case because Text nodes don't have children).
        visitChildren(text);
    }
}


/* FROM THE BEGINNING
Parser parser = Parser.builder().build();
Node document = parser.parse("This is *Sparta*");
HtmlRenderer renderer = HtmlRenderer.builder().build();
renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
*/