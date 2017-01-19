import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by joakimnilfjord on 1/18/2017 AD.
 */
public class Downloader2 {
    public void download(String url,String path) throws MalformedURLException {
        File file = new File(createFile(path));
        File parentFile = new File(file.getParent());
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file.isDirectory()) {return;}
        URL webSite = new URL(url);
        try {
            FileUtils.copyURLToFile(webSite,file);
        } catch (IOException e) {

        }
    }
    private static String createFile(String path) {
        return "/Users/joakimnilfjord/Desktop/HEY" + path;
    }
}
