package io.muic.ooc.hw1;


import org.apache.commons.io.*;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.*;


/**
 * Hello world!
 *
 */
public class FileCount extends DirectoryWalker
{
    private int fileCount = 0;
    private int dirCount = 0;
    HashMap<String,Integer> extensions = new HashMap<String, Integer>();
    public FileCount() {
        super();
    }

    public void startWalking(File startDirectory)  {

        List results = new ArrayList();
        try {
        walk(startDirectory, results); }
        catch (IOException e){
            System.out.println("IOEException Error in walk");
        }

    }

    protected boolean handleDirectory(File directory, int depth, Collection results) {

        setDirCount();

        return true;
    }

    protected void handleFile(File file, int depth, Collection results) {
        setFileCount();
        String fileName= file.getName();
        String fileNameExt = FilenameUtils.getExtension(fileName);
        setExtension(fileNameExt);
    }

    protected void getFileCount() {
        System.out.println(fileCount);
    }

    protected void setFileCount() {
        fileCount +=1;
    }
    protected void getDirCount() {
        System.out.println(dirCount);
    }
    protected void setDirCount() {
        dirCount +=1;
    }

    protected void setExtension(String fileExtension) {
        fileExtension = fileExtension.toLowerCase();
        if (!extensions.containsKey(fileExtension)) {
            extensions.put(fileExtension,1);
        }
        else {
            extensions.put(fileExtension, extensions.get(fileExtension) +1);
        }
    }
    protected void getExtensionsCount() {
        System.out.println(extensions.size());
    }
    protected void getListExtensions() {
        for (String ext: extensions.keySet()) {
            System.out.println(ext);
        }
    }
    protected void getExtensionsPlus() {
        System.out.println(extensions.toString());
    }

}
