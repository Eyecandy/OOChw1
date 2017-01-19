package io.muic.ooc.hw1;
import java.io.File;

/**
 * Created by joakimnilfjord on 1/13/2017 AD.
 */
public class Main {
    public static void main(String[] args) {
        FileCount fc = new FileCount();
        File f = new File("/Users/joakimnilfjord/Desktop/docs");
        fc.startWalking(f);
        fc.getFileCount();
        fc.getDirCount();
        fc.getExtensionsCount();
        fc.getListExtensions();
        fc.getExtensionsPlus();

    }



}
