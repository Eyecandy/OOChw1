import org.apache.commons.io.FilenameUtils;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by joakimnilfjord on 1/17/2017 AD.
 */
public class ListLink2 {
    public static void main(String[] args) throws IOException {
        Downloader2 downloader22 = new Downloader2();
        HashSet<String> visited = new HashSet<String>();
        Stack<String> sHTML = new Stack();
        Stack<String> downloads = new Stack();
        sHTML.add("https://cs.muic.mahidol.ac.th/courses/ooc/docs/" + "index.html");
        int wordCount = 0;
        while (!sHTML.isEmpty()) {
            String stringURL = sHTML.pop();
            try {
                Document doc = Jsoup.connect(stringURL).get();
                String[] htmlWord = doc.text().split("\\w+");
                wordCount += htmlWord.length;
                Elements links = doc.select("a[href]");
                Elements media = doc.select("[src]");
                Elements imports = doc.select("link[href]");
                doForLoop("abs:href", visited, sHTML, downloads, links, downloader22);
                doForLoop("abs:src", visited, sHTML, downloads, media, downloader22);
                doForLoop("abs:href", visited, sHTML, downloads, imports, downloader22);
            } catch (HttpStatusException e) {
            }
        }
        System.out.println(wordCount);
    }

    public static String createString(String path) {
        return "https://cs.muic.mahidol.ac.th" + path;
    }

    public static void doForLoop(String attributeKey,
                                 HashSet<String> visited,
                                 Stack<String> html,
                                 Stack<String> downloads,
                                 Elements elements,
                                 Downloader2 downloader2
                                 ) throws IOException {
        for (Element element : elements) {
            String s = element.attr(attributeKey);
            if (!s.contains("https://cs.muic.mahidol.ac.th")) {
                continue;
            }
            URL url = new URL(s);
            String stringToUse = createString(url.getPath());

            if (!visited.contains(stringToUse)) {
                visited.add(stringToUse);
                if (isHtmlExt(url)) {
                    html.add(stringToUse);
                    downloader2.download(stringToUse, url.getPath());

                } else {
                    downloader2.download(stringToUse, url.getPath());
                    downloads.add(stringToUse);
                }
            }
        }
    }
    public static Boolean isHtmlExt(URL url) {

        String ext = FilenameUtils.getExtension(url.getPath());
        if (ext.contains("html")) {
            return true;
        } else {
            return false;
        }

    }
}
