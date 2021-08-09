package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArgsAnalyzer {

    public String getMode(String[] args) {

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                return args[i + 1];
            }
        }
        return "enc";
    }

    public String getAlgorithm(String[] args) {

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-alg")) {
                return args[i + 1];
            }
        }
        return "shift";
    }

    public boolean hasInArgument(String[] args) {
        for (String argument : args) {
            if (argument.equals("-in")) {
                return true;
            }
        }
        return false;
    }

    public boolean hasOutArgument(String[] args) {
        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-out")) {
                return true;
            }
        }
        return false;
    }

    public String getFilePathToRead(String[] args) {
        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-in")) {
                return args[i + 1];
            }
        }
        return "";

    }

    public boolean hasDataArgument(String[] args) {
        for (String argument : args) {
            if (argument.equals("-data")) {
                return true;
            }
        }
        return false;
    }

    public int getKey(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-key")) {
                return Integer.parseInt(args[i + 1]);
            }
        }
        return 0;
    }

    public String getFilePathToWrite(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-out")) {
                return args[i + 1];
            }
        }
        return "";
    }

    public String getDataFromArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-data")) {
                return args[i + 1];
            }
        }
        return "";
    }

    public static String getDataFromFile(String path) {
        File file = new File(path);
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error! File not found!");
        }
        return sb.toString();
    }

    public String getDataToProcess(boolean hasInArgument, boolean hasDataArgument, String path, String[] args) {
        if (hasDataArgument) {
            return getDataFromArgs(args);
        } else if (hasInArgument) {
            return getDataFromFile(path);
        }
        return "";
    }
}
