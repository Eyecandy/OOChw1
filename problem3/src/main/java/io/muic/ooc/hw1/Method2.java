package io.muic.ooc.hw1;

/**
 * Created by joakimnilfjord on 1/14/2017 AD.
 */
import java.net.*;
import java.io.*;
public class Method2 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://cs.muic.mahidol.ac.th/courses/ooc/docs/");
        URLConnection urlConnection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        File file = new File ("/Users/joakimnilfjord/desktop/jo.txt");
        file.getParentFile().mkdirs();
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        BufferedWriter br = new BufferedWriter(writer);

        while ((inputLine = in.readLine()) != null){
            br.write(inputLine+"\n");

        }
        br.close();
        writer.close();
        in.close();
    }



}