
import org.apache.commons.cli.*;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        FileCount fc = new FileCount();
        CommandLineParser commandLineParser = new DefaultParser();
        Options options = new Options();
        options.addOption("a", "total-num-files", false, "The total number of files");
        options.addOption("b", "total-num-dirs",false, "Total number of directory");
        options.addOption("c", "total-unique-exts", false, "Total number of unique file extensions.");
        options.addOption("d", "list-extss",false, "List all unique file extensions.");
        options.addOption(null,"num-ext",true,"Path to the documentation folder. This is a required\n" +
                "argument.");
        options.addOption("f",null,true,"Path to the documentation folder. This is a required\n" +
                "argument.");


        try {
            CommandLine commandLine = commandLineParser.parse (options, args);
            if (!commandLine.hasOption("f")) {
                System.out.println("-f does not given");
            }
            else {
                File fileLocation = new File(commandLine.getOptionValue("f"));
                fc.startWalking(fileLocation);
            }

            if (commandLine.hasOption("a") || commandLine.hasOption("total-num-files")) {
                System.out.println(fc.getFileCount());
            }

            if (commandLine.hasOption("b") || commandLine.hasOption("total-num-dirs")) {
                System.out.println(fc.getDirCount());
            }
            if (commandLine.hasOption("c") || commandLine.hasOption("total-unique-exts")) {
                System.out.println(fc.getExtensionsSize());
            }
            if (commandLine.hasOption("d") || commandLine.hasOption("list-exts")) {
                fc.getListExtensions();
            }
            if (commandLine.hasOption("num-ext")) {
                String optVal = commandLine.getOptionValue("num-ext");
                if (fc.getExtensionsHashmap().containsKey(optVal)) {
                    System.out.println(fc.getExtensionsHashmap().get(optVal));
                }
                else {
                    System.out.println("File Extensions does not exist in this directory");
                }
            }
        }
        catch (ParseException e) {
            System.out.println("ParseException");

        }


    }




}
