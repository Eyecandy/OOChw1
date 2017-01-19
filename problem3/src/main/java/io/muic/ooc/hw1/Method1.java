package io.muic.ooc.hw1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class Method1
{
    public static void main( String[] args ) throws  Exception
    {
        File file = new File ("/Users/joakimnilfjord/desktop/joe.txt");
        URL url = new URL("https://cs.muic.mahidol.ac.th/courses/ooc/docs/");
        FileUtils.copyURLToFile(url, file);

    }
}
