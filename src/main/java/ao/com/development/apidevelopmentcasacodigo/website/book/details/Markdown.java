package ao.com.development.apidevelopmentcasacodigo.website.book.details;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class Markdown {
    public static String toHtml(String markdownText) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdownText);
        HtmlRenderer htmlRenderer = HtmlRenderer.builder().build();

        return htmlRenderer.render(document);
    }

    public static String toMarkdown(String html) {
        return "";
    }
}
