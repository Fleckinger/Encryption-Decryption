package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;


public class Main {
    public static void main(String[] args) {
        start(args);
    }

    public static void start(String[] args) {
        ArgsAnalyzer argsAnalyzer = new ArgsAnalyzer();

        String mode = argsAnalyzer.getMode(args);
        String algorithm = argsAnalyzer.getAlgorithm(args);
        String writePath = argsAnalyzer.getFilePathToWrite(args);
        String readPath = argsAnalyzer.getFilePathToRead(args);

        boolean hasInArgument = argsAnalyzer.hasInArgument(args);
        boolean hasOutArgument = argsAnalyzer.hasOutArgument(args);
        boolean hasDataArgument = argsAnalyzer.hasDataArgument(args);

        String stringToProcess = argsAnalyzer.getDataToProcess(hasInArgument, hasDataArgument, readPath, args);
        int key = argsAnalyzer.getKey(args);

        String result = "";


        switch (mode) {
            case "enc":
                Encryptor encryptor = new Encryptor();
                result = encryptor.encrypt(stringToProcess, key, algorithm);
                break;

            case "dec":
                Decryptor decryptor = new Decryptor();
                result = decryptor.decrypt(stringToProcess, key, algorithm);
                break;
        }


       if (hasOutArgument) {
           writeToFile(writePath, result);
       } else {
           System.out.println(result);
       }

    }

    public static void writeToFile(String path, String data) {
        if (!path.isEmpty()) {
            File file = new File(path);
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(data);
            } catch (Exception ignored) {

            }
        } else {
            System.out.println(data);
        }
    }
}
