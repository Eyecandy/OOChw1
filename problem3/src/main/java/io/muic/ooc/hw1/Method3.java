package io.muic.ooc.hw1;
import java.io.*;
import java.net.*;
import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


/**
 * Created by joakimnilfjord on 1/14/2017 AD.
 */
public class Method3 {

    public static void main(String[] args) {
        URL website=null;
        try {
            website = new URL("https://cs.muic.mahidol.ac.th/courses/ooc/docs/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        ReadableByteChannel rbc = null;
        try {
            rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("/Users/joakimnilfjord/desktop/joakim.txt");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
