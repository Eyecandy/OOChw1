
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
        checkFileExistance(startDirectory);
        List results = new ArrayList();
        try {
             walk(startDirectory, results);
             }
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

    protected int getFileCount() {
        return fileCount;
    }
    protected void setFileCount() {
        fileCount +=1;
    }

    protected int getDirCount() {return dirCount;}
    protected void setDirCount() {
        dirCount +=1;
    }

    protected void setExtension(String fileExtension) {
        if (!extensions.containsKey(fileExtension)) {
            extensions.put(fileExtension,1);
        }
        else {
            extensions.put(fileExtension, extensions.get(fileExtension) +1);
        }
    }
    protected int getExtensionsSize() {
        return extensions.size();
    }
    protected void getListExtensions() {
        for (String ext: extensions.keySet()) {
            System.out.println(ext);
        }
    }
    protected HashMap<String, Integer> getExtensionsHashmap() {
        return extensions;
    }

    private void checkFileExistance(File filePath) {
        if (!filePath.exists()) {
            System.out.println("invalid filepath: ");
            System.out.print(filePath);
            System.exit(1);

        }
    }

}
